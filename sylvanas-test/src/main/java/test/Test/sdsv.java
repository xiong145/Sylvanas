package test.Test;

import cn.hutool.json.JSONObject;

public class sdsv {
    public static void main(String[] args) {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("chargeItemId",137);
        System.out.println(jsonObject.getLong("chargeItemId").equals(137L));  ;
    }
}
