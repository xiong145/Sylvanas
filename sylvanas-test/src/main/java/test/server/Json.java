package test.server;


import com.alibaba.fastjson.JSONObject;

public class Json {
    public static void main(String[] args) {
        try {
            String jsonStr = JSONObject.toJSONString(null);
            System.out.println(jsonStr);
        } catch (Exception e) {

        }

    }
}
