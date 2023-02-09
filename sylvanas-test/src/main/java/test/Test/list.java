package test.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class list {
    public static void main(String[] args) throws ParseException {
        List<String> list=new ArrayList<>();
     list.add("ssss");
     list.add("ssss");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(list.size());
//        System.out.println(format.format( "'"));
    }
}
