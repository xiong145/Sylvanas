package test.Test1;

import cn.hutool.core.util.IdUtil;

import java.util.Date;

public class idut {
    public static void main(String[] args) {
        System.out.println(IdUtil.simpleUUID() );
        System.out.println(IdUtil.simpleUUID().length());
        System.out.println("0141bf95797241c18b58aa4b5a14dbd".length());

    }
}
