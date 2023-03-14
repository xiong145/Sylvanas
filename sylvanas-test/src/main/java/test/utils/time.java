package test.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class time {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (format.parse("2023-02-26 14:15:14").getTime()  > ((new Date()).getTime() - (1000.0 * 60.0 * 60.0 * 24.0 * 30.0 * 1.5))) {
            System.out.println("dds");
        }
        System.out.println((new Date()).getTime());
        System.out.println(format.parse("2023-02-26 14:15:14").getTime());
        System.out.println((new Date()).getTime() - (1000 * 60 * 60 * 24 ));
    }
}
