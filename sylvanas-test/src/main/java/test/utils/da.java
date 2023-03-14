package test.utils;

import java.util.Date;

public class da {
    public static void main(String[] args) {
        while (true) {
            Double a = ((new Date()).getTime() % 99.0) / 100.0;
            System.out.println(a);
        }
    }
}
