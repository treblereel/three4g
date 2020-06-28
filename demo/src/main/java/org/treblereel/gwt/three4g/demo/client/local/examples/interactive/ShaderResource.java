package org.treblereel.gwt.three4g.demo.client.local.examples.interactive;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/7/18.
 */
public interface ShaderResource extends ClientBundle {

    ShaderResource INSTANCE = GWT.create(ShaderResource.class);

    @Source("fragmentshader.txt")
    TextResource fragmentshader();

    @Source("vertexshader.txt")
    TextResource vertexshader();

}
