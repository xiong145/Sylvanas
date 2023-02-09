package test.Test1;

import cn.hutool.json.JSONObject;
import sun.plugin.javascript.navig.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class dvwv {
    public static void main(String[] args) {
        JSONObject json = new JSONObject();
        json.set("a", "0");
//        System.out.println(json.getDouble("a"));
        List<Double> list = new ArrayList<Double>();
        list.addAll(Arrays.asList(15.2, 25.2, 96.2, 0.0, 6.3, 0.0, 59.2));


        List<Double> doubles = list.stream().filter(l -> 0.0 != l).collect(Collectors.toList());
        doubles.remove(25.2);
        doubles.stream().forEach(l -> {
            System.out.println(l);
        });

    }
}
