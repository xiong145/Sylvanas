package test.utils;

import org.springframework.boot.convert.DataSizeUnit;


public class Aa {
    private String aaa;
    private Long nnn;
    private Integer sss;

    @Override
    public String toString() {
        return "Aa{" +
                "aaa='" + aaa + '\'' +
                ", nnn=" + nnn +
                ", sss=" + sss +
                '}';
    }

    public String getAaa() {
        return aaa;
    }

    public void setAaa(String aaa) {
        this.aaa = aaa;
    }

    public Long getNnn() {
        return nnn;
    }

    public void setNnn(Long nnn) {
        this.nnn = nnn;
    }

    public Integer getSss() {
        return sss;
    }

    public void setSss(Integer sss) {
        this.sss = sss;
    }
}
