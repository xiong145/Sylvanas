package test.server;

import com.alibaba.fastjson.JSONObject;

public class fff {
    public static void main(String[] args) {
        String aa = "{\"Status\":\"false\",\"ErroeMsg\":\"鏌ヨ\uE1D7澶辫触!\",\"date\":\"{\\n\\\"response\\\":{\\n\\\"body\\\":{},\\n\\\"head\\\":{\\n\\\"resultcode\\\":\\\"DCCF005\\\",\\n\\\"resultmsg\\\":\\\"servererror.CDCServer:IP:115.231.16.251ErrMsg:DCXM009-鎶ユ枃涓\uE162潪绌烘帴鍙\uE5B4tdmtlsty涓虹┖\\\"\\n}\\n}\\n}\\n\"}";
        JSONObject jsonObject = JSONObject.parseObject(aa);
        System.out.println(jsonObject.get("Status")); ;
    }

}
