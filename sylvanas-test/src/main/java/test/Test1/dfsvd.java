package test.Test1;

import java.util.HashMap;

public class dfsvd {
    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<String, Object>() {
            {
                 put("name", "test");
                put("age", "20");
            }
        };
        System.out.println(map);
    }
}
