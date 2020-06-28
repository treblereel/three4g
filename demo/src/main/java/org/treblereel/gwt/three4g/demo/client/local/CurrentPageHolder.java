package org.treblereel.gwt.three4g.demo.client.local;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 6/12/18.
 */
public class CurrentPageHolder {

    private Attachable page;

    CurrentPageHolder() {

    }

    public Attachable getCurrentPage() {
        return this.page;
    }

    public void setCurrentPage(Attachable page) {
        this.page = page;
    }
}
