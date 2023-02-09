package test.Test;

import java.util.Calendar;
import java.util.Date;

public class INTLONG {
    public static void main(String[] args) {
        long a=0;
        Long n=0L;
        System.out.println(n.equals(a));

        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -1);
        Date time = c.getTime();
        System.out.println(time);
    }
}
