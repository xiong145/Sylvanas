package test.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fc {
    public static void main(String[] args) {
        List<Long> chargeItemIdList=new ArrayList<>();
        chargeItemIdList.add(165L);
        chargeItemIdList.add(111L);
        chargeItemIdList.add(341L);
        chargeItemIdList.removeAll(Arrays.asList(341L, 342L, 343L, 344L, 308L, 309L,190L,191L,354L,165L,175L,1L));
        System.out.println(chargeItemIdList);
    }
}
