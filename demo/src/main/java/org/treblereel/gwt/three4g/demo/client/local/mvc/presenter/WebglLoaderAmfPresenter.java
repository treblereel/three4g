package org.treblereel.gwt.three4g.demo.client.local.mvc.presenter;

import com.google.gwt.core.client.GWT;
import elemental2.dom.HTMLDivElement;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.examples.loaders.WebglLoaderAmf;

/**
 * @author Dmitrii Tikhomirov Created by treblereel 1/18/19
 */
public class WebglLoaderAmfPresenter implements Presenter {

  @Override
  public void dispatch(HTMLDivElement container) {
    container.appendChild(((Attachable) GWT.create(WebglLoaderAmf.class)).asWidget());
  }
}

