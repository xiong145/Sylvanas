package test.utils;

import java.io.DataInputStream;

public class saas {
    public static void main(String[] args) {
        Double amount=52.259656;
        String str = String.format("%.2f", amount);
        amount = Double.parseDouble(str);
        System.out.println(amount);
    }
}
