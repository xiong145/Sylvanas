package test.utils;

import cn.hutool.crypto.Mode;
import cn.hutool.crypto.Padding;
import cn.hutool.crypto.symmetric.AES;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

public class dome {
    public static void main(String[] args) {

        String ak = "210FDA7686BF4CC1";

        //  转换成对象
        MergerEwbNoVO mergerEwb = new MergerEwbNoVO();
        mergerEwb.setEcId("111");
        mergerEwb.setMergerEwbNo("222");
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        MergerInfosDto mergerInfosDto = new MergerInfosDto();
        mergerInfosDto.setEwbNo("333");
        mergerInfosDto.setOrderNo("444");
        mergerInfosDto.setIsStatus("0");
        MergerInfosDto mergerInfosDto1 = new MergerInfosDto();
        mergerInfosDto1.setEwbNo("555");
        mergerInfosDto1.setOrderNo("666");
        mergerInfosDto1.setIsStatus("1");
        MergerInfosDto mergerInfosDto3 = new MergerInfosDto();
        mergerInfosDto3.setEwbNo("7777");
        mergerInfosDto3.setOrderNo("挥发发回复氨挥发i发哦v奥v啊v白vu阿八匹柏哦额");
        mergerInfosDto3.setIsStatus("2");
        jsonArray.add(mergerInfosDto);
        jsonArray.add(mergerInfosDto1);
        jsonArray.add(mergerInfosDto3);
        jsonObject.put("data", jsonArray);
        mergerEwb.setMergerInfos(jsonObject);
        /**
         *
         */
        JSONObject jsonObject2 = (JSONObject) JSONObject.toJSON(mergerEwb);
        String str = jsonObject2.toJSONString();
        /**
         *
         */
        AES aes = new AES(Mode.ECB, Padding.PKCS5Padding, ak.getBytes());
        /**
         * 加密
         */
        String aesstr = aes.encryptBase64(str);
        System.out.println(aesstr);
/**
 * 解密
 */
        String str2 = aes.decryptStr(aesstr);

        MergerEwbNoVO u1 = JSON.parseObject(str2, new TypeReference<MergerEwbNoVO>() {
        });


        System.out.println(u1);

    }
}
