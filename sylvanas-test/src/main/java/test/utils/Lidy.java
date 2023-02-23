package test.utils;

import java.util.ArrayList;
import java.util.List;

public class Lidy {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(10);
        list.addAll(null);
        System.out.println(list.size());
    }
}
