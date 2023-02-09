package test.Test;

import java.util.Arrays;

public class sdsd {
    public static void main(String[] args) {
        pri("ddd", "sas", "sds");
    }

    public static void pri(String... str) {
        for (String str1 : str) {
            System.out.println(str1);
        }
       Arrays.stream(str).forEach(a->{
           System.out.println(a);
       });

    }
}
