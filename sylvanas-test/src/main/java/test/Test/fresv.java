package test.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class fresv {
    //
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        Date date = sdf.parse(" 2019-12-31");
        System.out.println(date);
        String str = sdf.format(date);
        System.out.println(str);


        Date date1 = sdf.parse(" 2022-12-31");
        System.out.println(date1);
        String str1 = sdf.format(date1);
        System.out.println(str1);

    }
}
