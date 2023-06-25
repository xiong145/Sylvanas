package test.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class dsf {
    public static void main(String[] args) {
        String DateStr = "2022" + "-" + "11" + "-01 00:00:00";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(DateStr);
        } catch (Exception e) {
            e.printStackTrace();

        }
        System.out.println(date.getTime());
        System.out.println(date);
    }
}
