package test.Test;

import java.util.HashMap;

public class sanyuan {
//    public static void main(String[] args) {
//        System.out.println(true ? 1 : 0);
//    }

    public static void main(String[] args) {
        HashMap idsMap = new HashMap();
        String ids = "464654646,654646,";
        if (ids != null) {
            if (ids.substring(ids.length() - 1, ids.length()).equals(",")) {
                ids = ids.substring(0, ids.length() - 1);
            }
            idsMap.put("dispatchGroupId", ids);
        }
        System.out.println(idsMap);
    }

}
