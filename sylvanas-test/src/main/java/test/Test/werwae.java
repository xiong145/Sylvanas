package test.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class werwae {
    public static void main(String[] args) {
        Map<String, Object> params = new HashMap<>();
        params.put("costMoney",BigDecimal.valueOf(20.00000));
        BigDecimal costMoney = Optional.ofNullable((BigDecimal) params.get("costMoney")).orElse(BigDecimal.ZERO);

        Map<String, Object> params2 = new HashMap<>();
        params2.put("amount", costMoney.doubleValue());
        System.out.println(params);
    }
}
