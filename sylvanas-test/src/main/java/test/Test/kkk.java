package test.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class kkk {
    public static void main(String[] args) {
        List<String> aa = new ArrayList<>();
        aa.addAll(Arrays.asList("12", "23", "24", "56"));
        aa.remove("12");
        aa.removeIf(a -> a.contains("23"));
        aa.stream().forEach(f -> {
            System.out.println(f);
        });
    }
}
