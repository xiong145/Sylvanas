package test.utils;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

public class fd {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("ascString", "8dk52l2a4/EeWhB9KpdVjqX/HuL+WvCkGi9HAjKLRPJHsaEcSl/KXb7uqFkDOx3Gc40mlyw2pRAJq4k88VVrEiwbllvBq7+Mdf1Ydo/n+5uRVfEu1S0FV59QjlEW0TgZLm7+2kHY0twDYzfAtCpI5iUvCV+75lUh4tTDjLwu95ssvwPW5uE2Zl2pyPKHix4SFoYaephC3+KTAPhShrAFNpHwIqU7Nz1/05CqYg7CW4M8yAQUJLqsKoP1SMeQD6p606jA0vSdUhnBB9oh9Os5jl6NfKDu+WhqbmFu9X16agA=");
        JSONObject jsonObj = new JSONObject(hashMap);
        String str = HttpUtil.post("http://10.202.116.98:8080/appHsRgShop/HsRgShop/addHsRgShop", jsonObj.toString(), "application/json");
        System.out.println(str);

        try {
            byte[] aa = HttpsUtil.post("https://finyu.zto56.com/finance/appHsRgShop/HsRgShop/addHsRgShop", jsonObj.toString(), "utf-8");
            String ss = new String(aa);
            System.out.println(ss);
        }catch (Exception e) {
            System.out.println(e);
        }


    }
}
