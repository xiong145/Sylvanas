package test.Test;

import java.util.Arrays;
import java.util.List;

public class listg {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("123", "45634", "7892", "abch", "sdfhrthj", "mvkd");
        list.stream().forEach(e ->{
            if(e.length() >= 5){
                return;
            }
            System.out.println(e);
        });
    }
}
