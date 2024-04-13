package test.Test;

import java.util.*;

public class sada {
    public static void main(String[] args) {

        List<Long> stringList = new ArrayList<>();
        stringList.add(1L);
        stringList.add(2L);
        stringList.add(3L);
        stringList.add(4L);
        stringList.add(5L);
        stringList.add(6L);

        //一、求交集
        //方法1：直接通过retainAll直接过滤
        List<Long> stringList1 =  new ArrayList<>(Arrays.asList(1L,2L,6L,7L,8L));
        stringList1.retainAll(stringList);
        System.out.println("交集1: " + stringList1);



      List<String> k=null;
        System.out.println(k.contains("s")); ;
//        System.out.println((String) new Integer(0));
        Map m=new HashMap();
        m.put("2",4);
        System.out.println(m.get(2));
        System.out.println(String.valueOf(null));
        System.out.println(getId("011a467b77234f748e54b8ddf8e1f68d") );
//        System.out.println(0.2*0.01*100/100);
//        System.out.println(Math.round(0.2 * 0.01 * 100) / 100.0);
//        Integer m = 2;
//        Integer n = 2;
//        System.out.println(m == n); //
        System.out.println("a".hashCode());
    }

    public static Long getId(String UUID) {
        Integer userId = UUID.toString().hashCode();
        // String.hashCode()可能会是负数，如果为负数需要转换为正数
        userId = userId < 0 ? -userId : userId;
        return Long.valueOf(String.valueOf(userId));
    }
}
