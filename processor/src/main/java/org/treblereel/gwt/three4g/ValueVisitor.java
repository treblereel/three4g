package org.treblereel.gwt.three4g;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.SimpleAnnotationValueVisitor8;
import javax.lang.model.util.Types;
import java.util.List;
import java.util.Set;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 10/2/18.
 */
public class ValueVisitor extends SimpleAnnotationValueVisitor8<Void, Void> {
    private final Types typeUtils;
    private final Set<String> paths;


    ValueVisitor(ProcessingEnvironment processingEnvironment, Set<String> paths) {
        this.typeUtils = processingEnvironment.getTypeUtils();
        this.paths = paths;
    }

    @Override
    public Void visitType(TypeMirror t, Void p) {
        TypeElement typeElement = (TypeElement) typeUtils.asElement(t);
        Three4gElement three4gElement = typeElement.getAnnotation(Three4gElement.class);

        for (int i = 0; i < three4gElement.paths().length; i++) {
            paths.add(three4gElement.paths()[i]);
        }
        return p;
    }

    @Override
    public Void visitArray(List<? extends AnnotationValue> vals, Void p) {
        for (AnnotationValue val : vals) {
            val.accept(this, p);
        }
        return p;
    }
}
