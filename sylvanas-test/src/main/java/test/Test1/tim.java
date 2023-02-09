package test.Test1;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class tim {
    public static void main(String[] args) throws ParseException {
        System.out.println(new Date());
        System.out.println(new Date((new Date()).getTime()));
//        String s = DateFormatUtils.format(new Date(), "yyyy-MM-dd 00:00:00");
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//定义时间格式
//        Date scanTime = sdf.parse(s);//将String字符串类型转换为date时间类型
//        Long zero = scanTime.getTime();//获取date的值
//        Double a=(( new Date()).getTime()-zero)/1000.00/60.00/60.00;
//        System.out.println(a);   
    }
}
