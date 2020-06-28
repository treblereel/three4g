package org.treblereel.gwt.three4g.demo.client.local.utils;

public class Pair<A, B> {

    public A fst;
    public B snd;

    public Pair(A fst, B snd) {
        this.fst = fst;
        this.snd = snd;
    }

    public String toString() {
        return "Pair[" + fst + "," + snd + "]";
    }

}
