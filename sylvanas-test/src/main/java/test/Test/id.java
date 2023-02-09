package test.Test;

import cn.hutool.core.util.IdUtil;
import org.springframework.stereotype.Component;

@Component
public class id {
    public String getStr() {
        return "str";
    }

    public static void main(String[] args) {
        System.out.println(IdUtil.simpleUUID());
    }
}
