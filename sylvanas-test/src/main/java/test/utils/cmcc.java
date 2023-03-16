package test.utils;

import java.io.Serializable;

public class cmcc implements Serializable {
    private String ll;

    public cmcc(String ll) {
        this.ll = ll;
    }

    public String getLl() {
        return ll;
    }

    public void setLl(String ll) {
        this.ll = ll;
    }
}
