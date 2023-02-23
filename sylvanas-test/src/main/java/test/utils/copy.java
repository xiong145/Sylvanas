package test.utils;

import org.springframework.beans.BeanUtils;

public class copy {

    public static void main(String[] args) {
        Aa a = new Aa();
        a.setAaa("444");
        a.setNnn(52L);
        a.setSss(5);

        Aa b=new Aa();
        BeanUtils.copyProperties(a, b);
        b.setAaa("597");
        b.setNnn(582L);
        b.setSss(7);
        System.out.println(a.toString()+b.toString());
    }


}
