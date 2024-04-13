package test.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class sa {
    private static final int s = 601;

    public static void main(String[] args) {
         int f=1;
        System.out.println(f);
        List<Integer> lists = Arrays.asList(1, 2);
        Map<Boolean, List<Integer>> itemList = lists.stream().collect(Collectors.groupingBy(i -> Arrays.asList(1, 2).contains(i)));
        System.out.println(itemList.get(false));
        System.out.println(itemList.get(true));
        for (Integer i : itemList.get(false)) {
            System.out.println(1);
        }



    }
}
