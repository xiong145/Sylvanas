package test.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.Map.Entry;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class http {
//    @Value("${zto.wsApp.httpUrl}")
    private static String httpUrl="http://wsapp-pre.ky.ztosys.com/";

    /**
     * header 在传输header时请务必加上charset=utf-8;
     * "Content-Type: application/x-www-form-urlencoded;charset=utf-8\n"
     */
    public static final String HEADER =
            "Accept-Encoding: gzip,deflate\n" +
                    "Content-Type: application/x-www-form-urlencoded;charset=utf-8\n" +
                    "Connection: Keep-Alive";
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("employeeId", String.valueOf(5L));
        hashMap.put("content", "结算成功");
        hashMap.put("chargeItemId", String.valueOf(5L));
        hashMap.put("chargeItemName", "测试1");
        hashMap.put("amount", String.valueOf(5.0));
        hashMap.put("ewbNo","1786");
        hashMap.put("createdBy", String.valueOf(25L));
        System.out.println ("推送到" + httpUrl + hashMap);

        try {
            String result = postMap(httpUrl + "api/base/push/settlement", splid(HEADER), hashMap);
            System.out.println("resultJson" + result);
            JSONObject resultJson = JSONObject.parseObject(result);
            if (resultJson.getBoolean("success")) {
                System.out.println( "推送成功");
            } else {
                System.out.println(httpUrl  + "推送失败" + result + "参数" + hashMap);
            }
        } catch (Exception e) {
            System.out.println("调用网点版http错" + e.getMessage());
            System.out.println("调用网点版http错误,e={}" );
        }
    }
    /**
     * @param url        访问地址
     * @param headerMap  header 参数；可以通过下面工具类将string类型转换成map
     * @param contentMap 需要传输参数参数；对象可以通过json转换成map
     * @return 返回网页返回的数据
     */
    public static String postMap(String url, Map<String, String> headerMap, Map<String, String> contentMap) {
        String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        List<NameValuePair> content = new ArrayList<NameValuePair>();
        //将content生成entity
        Iterator iterator = contentMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> elem = (Map.Entry<String, String>) iterator.next();
            content.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
        }
        CloseableHttpResponse response = null;
        try {
            //循环增加header
            Iterator headerIterator = headerMap.entrySet().iterator();
            while (headerIterator.hasNext()) {
                Map.Entry<String, String> elem = (Map.Entry<String, String>) headerIterator.next();
                post.addHeader(elem.getKey(), elem.getValue());
            }
            if (content.size() > 0) {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(content, "UTF-8");
                post.setEntity(entity);
            }
            //发送请求并接收返回数据
            response = httpClient.execute(post);
            if (response != null && response.getStatusLine().getStatusCode() == 200) {
                //获取response的body部分
                HttpEntity entity = response.getEntity();
                //读取reponse的body部分并转化成字符串
                result = EntityUtils.toString(entity);
            }
            return result;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    /**
     * Header字符串转map
     *
     * @param zz
     * @return
     */
    public static Map<String, String> splid(String zz) {
        String[] stepOne = zz.split("\n");
        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < stepOne.length; i++) {
            String[] stepTwo = stepOne[i].split(": ");
            if (map.get(stepTwo[0]) == null) {
                map.put(stepTwo[0], stepTwo[1]);
            } else {
                map.put(stepTwo[0], stepTwo[1] + "," + map.get(stepTwo[0]));
            }
        }
        return map;
    }
}
