package org.treblereel.gwt.three4g;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 9/30/18.
 */
@Documented
@Target(ElementType.TYPE)
public @interface Three4gElement {
    String[] paths();
}
