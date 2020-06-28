package org.treblereel.gwt.three4g.demo.client.local.mvc.presenter;

import com.google.gwt.core.client.GWT;
import elemental2.dom.HTMLDivElement;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.examples.loaders.WebglLoaderAssimp;

/**
 * @author Dmitrii Tikhomirov Created by treblereel 12/14/18
 */
public class WebglLoaderAssimpPresenter implements Presenter {

  @Override
  public void dispatch(HTMLDivElement container) {
    container.appendChild(((Attachable) GWT.create(WebglLoaderAssimp.class)).asWidget());
  }
}

