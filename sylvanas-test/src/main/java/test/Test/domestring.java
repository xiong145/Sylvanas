package test.Test;


import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringEscapeUtils;

public class domestring {
    public static void main(String[] args) {
      String aa="{\\\"Status\\\":\\\"true\\\",\\\"ErroeMsg\\\":\\\"查询成功!\\\",\\\"date\\\":[{\\\"accnbr\\\":\\\"571" +
              "909872210406\\\",\\\"autflg\\\":\\\"5\\\",\\\"balflg\\\":\\\"Y\\\",\\\"ccynbr\\\":\\\"10\\\",\\\"dmanam\\\":" +
              "\\\"IT测试一级发件部\\\",\\\"dmanbr\\\":\\\"66030211\\\",\\\"onlbal\\\":\\\"2.00\\\",\\\"rpyacc\\\":\\\"6214852106303822\\" +
              "\",\\\"rpynam\\\":\\\"汪顺平\\\",\\\"trxamt\\\":\\\"1.00\\\",\\\"trxdir\\\":\\\"C\\\",\\\"trxnbr\\\":\\\"C0246KG0005MYNZ\\\",\\" +
              "\"trxtim\\\":\\\"091547\\\",\\\"trxtxt\\\":\\\"转账\\\"},{\\\"accnbr\\\":\\\"571909872210406\\\",\\\"autflg\\\":\\\"5\\\",\\\"balflg\\\":\\\"Y\\\",\\\"ccynbr\\\":\\\"10\\\",\\\"dmanam\\\":\\\"IT测试一级发件部\\\",\\\"dmanbr\\\":\\\"66030211\\\",\\\"onlbal\\\":\\\"2.01\\\",\\\"rpyacc\\\":\\\"6214852106303822\\\",\\\"rpynam\\\":\\\"汪顺平\\\",\\\"trxamt\\\":\\\"0.01\\\",\\\"trxdir\\\":\\\"C\\\",\\\"trxnbr\\\":\\\"C0246KG0000BMFZ\\\",\\\"trxtim\\\":\\\"094731\\\",\\\"trxtxt\\\":\\\"转账\\\"},{\\\"accnbr\\\":\\\"571909872210406\\\",\\\"autflg\\\":\\\"5\\\",\\\"balflg\\\":\\\"Y\\\",\\\"ccynbr\\\":\\\"10\\\",\\\"dmanam\\\":\\\"IT测试一级发件部\\\",\\\"dmanbr\\\":\\\"66030211\\\",\\\"onlbal\\\":\\\"2.02\\\",\\\"rpyacc\\\":\\\"6214852106303822\\\",\\\"rpynam\\\":\\\"汪顺平\\\",\\\"trxamt\\\":\\\"0.01\\\",\\\"trxdir\\\":\\\"C\\\",\\\"trxnbr\\\":\\\"C0246KG0001ZZGZ\\\",\\\"trxtim\\\":\\\"104600\\\",\\\"trxtxt\\\":\\\"转账\\\"},{\\\"accnbr\\\":\\\"571909872210406\\\",\\\"autflg\\\":\\\"5\\\",\\\"balflg\\\":\\\"Y\\\",\\\"ccynbr\\\":\\\"10\\\",\\\"dmanam\\\":\\\"IT测试一级发件部\\\",\\\"dmanbr\\\":\\\"66030211\\\",\\\"onlbal\\\":\\\"2.03\\\",\\\"rpyacc\\\":\\\"6214852106303822\\\",\\\"rpynam\\\":\\\"汪顺平\\\",\\\"trxamt\\\":\\\"0.01\\\",\\\"trxdir\\\":\\\"C\\\",\\\"trxnbr\\\":\\\"C0246KG00066A0Z\\\",\\\"trxtim\\\":\\\"161805\\\",\\\"trxtxt\\\":\\\"转账\\\"}]}";
        String sd = StrUtil.strip(aa, "\"");
        String q = StringEscapeUtils.unescapeJava(sd);
        JSONObject jsonObject = JSONObject.parseObject(q);

        System.out.println(jsonObject.get("Status"));
        ;
        System.out.println(jsonObject);
    }
}
