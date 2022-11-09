package test.server;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class time {
    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateFormat df= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //（1）获取当前时间
        LocalDateTime date = LocalDateTime.now();
        String nowtime=dateTimeFormatter.format(date);
        System.out.println("系统当前时间      ："+nowtime);
        //（2）获取当前时间的前12小时时间
        LocalDateTime localDateTime = date.minusHours(12);
        String nowtime12=dateTimeFormatter.format(localDateTime);
        System.out.println("获取当前时间的前12小时时间      ："+nowtime12);

        LocalDateTime dataTime = date.minusMinutes(5);
        String now5=dateTimeFormatter.format(dataTime);
        System.out.println("获取当前时间的5分钟时间      ："+now5);
    }
}
