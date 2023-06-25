package test.utils;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class gAWEF {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        hashMap.put("timeBegin", getDateAfterDay(calendar.getTime(), 5));
        hashMap.put("timeEnd", getDateAfterDay(calendar.getTime(), 4));
        System.out.println(hashMap);
    }

    public static Date getDateAfterDay(Date date, int day) {
        Calendar dateTime = Calendar.getInstance();
        dateTime.setTime(date);
        dateTime.add(Calendar.DATE, -day);
        return dateTime.getTime();
    }
}
