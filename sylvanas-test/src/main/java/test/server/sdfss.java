package test.server;

import cn.hutool.core.util.IdUtil;

import java.util.Calendar;

public class sdfss {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        Integer month = cal.get(Calendar.MONTH) + 1;
        System.out.println(year + "" + month);

        System.out.println(IdUtil.simpleUUID().substring(15));
    }
}
