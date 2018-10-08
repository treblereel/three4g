package org.treblereel.gwt.three4g;

import com.google.auto.service.AutoService;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 9/30/18.
 */
@AutoService(Processor.class)
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes("org.treblereel.gwt.three4g.InjectJavaScriptFor")
public class Three4GProcessor extends AbstractProcessor {
    private static final String JS_PATH = "org.treblereel.gwt.three4g.extensions.resources";
    private final ClassName utils = ClassName.get("org.treblereel.gwt.three4g.utils", "Utils");
    private final ClassName threeJsTextResource = ClassName.get("org.treblereel.gwt.three4g.resources", "ThreeJsTextResource");
    private final ClassName threeJsTextextensionsResource = ClassName.get("org.treblereel.gwt.three4g.extensions.resources", "Extensions");

    private TypeSpec.Builder body;
    private MethodSpec.Builder onModuleLoad, onModuleLoadMin;

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (annotations.isEmpty()) { // for some unknown reason it runs 3 times
            return false;
        }
        Set<String> paths = new HashSet();
        for (Element typeElement : roundEnv.getElementsAnnotatedWith(InjectJavaScriptFor.class)) {
            List<? extends AnnotationMirror> annotationMirrors = typeElement.getAnnotationMirrors();
            for (AnnotationMirror annotationMirror : annotationMirrors) {
                Map<? extends ExecutableElement, ? extends AnnotationValue> elementValues = annotationMirror.getElementValues();
                for (Map.Entry<? extends ExecutableElement, ? extends AnnotationValue> entry : elementValues.entrySet()) {
                    entry.getValue().accept(new ValueVisitor(processingEnv, paths), null);
                }
            }
        }
        generateThree4gEntryPoint(paths);
        return true;
    }

    private void generateThree4gEntryPoint(Set<String> paths) {

        onModuleLoad = MethodSpec.methodBuilder("onModuleLoad")
                .addAnnotation(Override.class)
                .addModifiers(Modifier.PUBLIC)
                .returns(void.class)
                .addStatement("$T.injectJavaScript($T.IMPL.getThreeJS())", utils, threeJsTextResource);

        onModuleLoadMin = MethodSpec.methodBuilder("onModuleLoad")
                .addAnnotation(Override.class)
                .addModifiers(Modifier.PUBLIC)
                .returns(void.class)
                .addStatement("$T.injectJavaScript($T.IMPL.getThreeJSMin())", utils, threeJsTextResource);

        body = TypeSpec.interfaceBuilder("Extensions")
                .addSuperinterface(ClientBundle.class)
                .addModifiers(Modifier.PUBLIC);

        FieldSpec impl = FieldSpec.builder(threeJsTextextensionsResource, "IMPL")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                .initializer("$T.create($T.class)", GWT.class, threeJsTextextensionsResource)
                .build();
        body.addField(impl);

        paths.forEach(p -> addJSImportToClientBundle(p));

        TypeSpec bootstrap = TypeSpec.classBuilder("Three4G")
                .addSuperinterface(EntryPoint.class)
                .addModifiers(Modifier.PUBLIC)
                .addMethod(onModuleLoad.build())
                .build();

        TypeSpec bootstrapMin = TypeSpec.classBuilder("Three4GMin")
                .addSuperinterface(EntryPoint.class)
                .addModifiers(Modifier.PUBLIC)
                .addMethod(onModuleLoadMin.build())
                .build();

        JavaFile loader = JavaFile.builder("org.treblereel.gwt.three4g", bootstrap).build();
        JavaFile loaderMin = JavaFile.builder("org.treblereel.gwt.three4g", bootstrapMin).build();
        TypeSpec extensions = body.build();
        JavaFile extensionsFile = JavaFile.builder(JS_PATH, extensions).build();

        try {
            extensionsFile.writeTo(processingEnv.getFiler());
            loader.writeTo(processingEnv.getFiler());
            loaderMin.writeTo(processingEnv.getFiler());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addJSImportToClientBundle(String path) {
        AnnotationSpec spec = AnnotationSpec.builder(ClientBundle.Source.class).addMember("value", "$S", path).build();

        body.addMethod(MethodSpec.methodBuilder(escapeSlashAndDot(path))
                .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT).returns(TextResource.class)
                .addAnnotation(spec)
                .build()).build();

        onModuleLoad.addStatement("$T.injectJavaScript($T.IMPL." + escapeSlashAndDot(path) + "())", utils, threeJsTextextensionsResource);
        onModuleLoadMin.addStatement("$T.injectJavaScript($T.IMPL." + escapeSlashAndDot(path) + "())", utils, threeJsTextextensionsResource);

    }

    private String escapeSlashAndDot(String s) {
        return s.replace("/", "").replace(".", "");
    }

}
