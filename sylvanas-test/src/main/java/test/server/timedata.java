package test.server;

import java.text.SimpleDateFormat;
import java.util.Date;

public class timedata {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
        String time = sdf.format(now);
        System.out.println(time);
    }
}
