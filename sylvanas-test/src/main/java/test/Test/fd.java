package test.Test;

import java.util.ArrayList;
import java.util.List;

public class fd {

    public static void main(String[] args) {
        List<Long> originChargeItemIdList=new ArrayList<>();
        originChargeItemIdList.add(1L);
        originChargeItemIdList.add(213L);
        if( originChargeItemIdList.contains(213L)){
            System.out.println("d");
        }
    }
}
