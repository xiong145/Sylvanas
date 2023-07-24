package test.Test;

import cn.hutool.core.lang.Assert;

import java.util.HashMap;
import java.util.Map;

public class as {
    public static void main(String[] args) {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("rootSite", "rootSite");
            Assert.isTrue(map.containsKey("rootSite"), "需存在rootSite");
        } catch (Exception e) {
            System.out.println(e.getMessage() + e.getCause());
        }

        Integer a = 3;
        if (a.equals(null)) {
            System.out.println(1);
        }
    }
}
