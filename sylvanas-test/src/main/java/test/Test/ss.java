package test.Test;

import cn.hutool.extra.spring.SpringUtil;

import static cn.hutool.core.text.CharSequenceUtil.isNumeric;

public class ss {
    public static void main(String[] args) {
//        System.out.println(Integer.valueOf("5.5")); ;
        System.out.println(SpringUtil.getBean(id.class).getStr());;
    }
}
