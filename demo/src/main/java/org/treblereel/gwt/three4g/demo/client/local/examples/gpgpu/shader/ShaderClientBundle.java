package org.treblereel.gwt.three4g.demo.client.local.examples.gpgpu.shader;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 4/12/18.
 */
public interface ShaderClientBundle extends ClientBundle {

    ShaderClientBundle IMPL = GWT.create(ShaderClientBundle.class);

    @Source("fragmentShaderPosition.c")
    TextResource getFragmentShaderPosition();

    @Source("fragmentShaderVelocity.c")
    TextResource getFragmentShaderVelocity();

    @Source("birdFS.c")
    TextResource getBirdFS();

    @Source("birdVS.c")
    TextResource getBirdVS();
}
