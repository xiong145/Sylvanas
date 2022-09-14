package test.server;

import com.alibaba.fastjson.JSONObject;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class tiem {
    public static void main(String[] args) {
        Map<String, Object> params = new HashMap<>();
        //当前月第一天
        Date currentDate = getFirstDetailDayOfMonth(new Date());
        //上月第一天
        Date firstDayOfUpMonth = getFirstDayOfUpMonth(currentDate);
        //上月最后一天
        Date endDayOfUpMonth = getEndDayOfUpMonth(currentDate);
        endDayOfUpMonth = getDateAfterHour(endDayOfUpMonth, 23);
        endDayOfUpMonth = getDateAfterMinute(endDayOfUpMonth, 59);
        endDayOfUpMonth = getDateAfterSeconds(endDayOfUpMonth, 59);
        //条件封装
        params.put("beginTime", firstDayOfUpMonth);
        params.put("endTime", endDayOfUpMonth);

        System.out.println( JSONObject.toJSONString(params));;
    }

    public static Date getEndDayOfUpMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        return calendar.getTime();
    }

    public static Date getDateAfterSeconds(Date date, int second) {
        Calendar dateTime = Calendar.getInstance();
        dateTime.setTime(date);
        dateTime.add(Calendar.SECOND, +second);
        return dateTime.getTime();
    }

    public static Date getDateAfterMinute(Date date, int minute) {
        Calendar dateTime = Calendar.getInstance();
        dateTime.setTime(date);
        dateTime.add(Calendar.MINUTE, +minute);
        return dateTime.getTime();
    }

    public static Date getDateAfterHour(Date date, int hour) {
        Calendar dateTime = Calendar.getInstance();
        dateTime.setTime(date);
        dateTime.add(Calendar.HOUR, +hour);
        return dateTime.getTime();
    }

    public static Date getFirstDetailDayOfMonth(Date date) {
        Calendar cDay = Calendar.getInstance();
        cDay.setTime(date);
        cDay.set(Calendar.DAY_OF_MONTH, 1);
        cDay.set(Calendar.HOUR_OF_DAY, 00);
        cDay.set(Calendar.MINUTE, 00);
        cDay.set(Calendar.SECOND, 00);
//        System.out.println(cDay.getTime());
        return cDay.getTime();
    }

    public static Date getFirstDayOfUpMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

}
