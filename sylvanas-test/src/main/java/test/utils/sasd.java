package test.utils;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class sasd {
    public static void main(String[] args) {
        MergerEwbNoVO mergerEwbNoVO = new MergerEwbNoVO();
        mergerEwbNoVO.setEcId("111");
        mergerEwbNoVO.setMergerEwbNo("222");
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        MergerInfosDto mergerInfosDto = new MergerInfosDto();
        mergerInfosDto.setEwbNo("800012101163");
        mergerInfosDto.setOrderNo("X23021800045");
        MergerInfosDto mergerInfosDto1 = new MergerInfosDto();
        mergerInfosDto1.setEwbNo("555");
        mergerInfosDto1.setOrderNo("X2302dsd0045");
        MergerInfosDto mergerInfosDto3 = new MergerInfosDto();
        mergerInfosDto3.setEwbNo("7777");
        mergerInfosDto3.setOrderNo("挥发发回复氨挥发i发哦v奥v啊v白vu阿八匹柏哦额");
        jsonArray.add(mergerInfosDto);
        jsonArray.add(mergerInfosDto1);
        jsonArray.add(mergerInfosDto3);
        jsonObject.put("data", jsonArray);
        mergerEwbNoVO.setMergerInfos(jsonObject);
        HsRgShop hsRgShop = new HsRgShop();

        List<MergerInfosDto> list = JSONObject.parseArray(mergerEwbNoVO.getMergerInfos().getJSONArray("data").toJSONString(), MergerInfosDto.class);
       try {
           for (MergerInfosDto dd : list) {
               hsRgShop.setHsRgShopId(IdUtil.simpleUUID());
               hsRgShop.setEcId(mergerEwbNoVO.getEcId());
               hsRgShop.setEwbNo(dd.getEwbNo());
               hsRgShop.setOrderNo(dd.getOrderNo());
               hsRgShop.setMergerEwbNo(mergerEwbNoVO.getMergerEwbNo());
               System.out.println(hsRgShop);
           }
       }catch (JSONException e) {
           System.out.println(e);
       }

    }
}
