package org.treblereel.gwt.three4g.demo.client.local.mvc.presenter;

import com.google.gwt.core.client.GWT;
import elemental2.dom.HTMLDivElement;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.examples.loaders.WebglLoaderBvh;

/**
 * @author Dmitrii Tikhomirov Created by treblereel 1/18/19
 */
public class WebglLoaderBvhPresenter implements Presenter {

  @Override
  public void dispatch(HTMLDivElement container) {
    container.appendChild(((Attachable) GWT.create(WebglLoaderBvh.class)).asWidget());
  }
}