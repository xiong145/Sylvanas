//package test.server;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.cfne.cuckoo.fin.domain.entity.finance.AuditInformationRecordVO;
//import groovy.util.logging.Slf4j;
////import org.apache.commons.beanutils.BeanUtils;
//import org.slf4j.Logger;
//import org.springframework.stereotype.Component;
//
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.Map;
//
//public class ss {
//    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//    public static void main(String[] args) throws Exception {
//        String result = "{\"Status\":\"true\",\"ErroeMsg\":\"查询成功!\",\"date\":[{\"accnbr\":\"571909872210406\",\"ccynbr\":\"10\",\"dmanam\":\"富阳市区\",\"dmanbr\":\"66044720\",\"rpyacc\":\"1209240009200079903\",\"rpynam\":\"浙江诚石物流有限公司\",\"trxamt\":\"30000.00\",\"trxdir\":\"C\",\"trxnbr\":\"KK938301299832C\",\"trxtim\":\"091030\"}]}";
//          result = "{\"Status\":\"true\",\"ErroeMsg\":\"查询成功!\",\"date\":[{\"accnbr\":\"571909872210406\",\"ccynbr\":\"10\",\"dmanam\":\"永城\",\"dmanbr\":\"66007549\",\"rpyacc\":\"8111101012701248887\",\"rpynam\":\"永城市天安物流有限公司\",\"trxamt\":\"15000.00\",\"trxdir\":\"C\",\"trxnbr\":\"C0246ER000BFJ8Z\",\"trxtim\":\"132326\",\"trxtxt\":\"370003系统充值\"},{\"accnbr\":\"571909872210406\",\"ccynbr\":\"10\",\"dmanam\":\"永城\",\"dmanbr\":\"66007549\",\"rpyacc\":\"8111101012701248887\",\"rpynam\":\"永城市天安物流有限公司\",\"trxamt\":\"40000.00\",\"trxdir\":\"C\",\"trxnbr\":\"C0246ER000DCS2Z\",\"trxtim\":\"142445\",\"trxtxt\":\"370003系统充值\"}]}";
//        Thread.sleep(2000);
//        result = result.replaceAll("\\\\n", "");
//        result = result.replaceAll("\\\\", "");
//        char s = '\"';
//        if (s == result.substring(result.indexOf("date") + 6, result.indexOf("date") + 7).charAt(0) && s != result.substring(result.indexOf("date") + 7, result.indexOf("date") + 8).charAt(0)) {
//            result = result.substring(0, result.indexOf("date") + 6) + result.substring(result.indexOf("date") + 7, result.length());
//            result = result.substring(0, result.length() - 2) + "}";
//        }
//        result = result.replaceAll(" ", "");
//        Map maps = (Map) JSON.parse(result);
//        if ("false".equals(maps.get("Status"))) {
//            //无返回记录
//        } else {
//            JSONObject jsonObject = JSON.parseObject(result);
//            JSONArray date = (JSONArray) jsonObject.get("date");
//            for (int i = 0; i < date.size(); i++) {
//                date.getJSONObject(i).get("trxtim");
//                String trxtim = (String) date.getJSONObject(i).get("trxtim");
//                String trxtimH = trxtim.substring(0, 2) + ":";
//                String trxtimS = trxtim.substring(2, 4) + ":";
//                String trxtimM = trxtim.substring(4);
//                trxtim = trxtimH + trxtimS + trxtimM;
//                Calendar now = Calendar.getInstance();
//                String a = now.get(Calendar.YEAR) + "-" + (now.get(Calendar.MONTH) + 1) + "-" + now.get(Calendar.DAY_OF_MONTH) + " " + trxtim;
//                Date aDate = sdf.parse(a);
//                date.getJSONObject(i).put("trxtim", aDate);
//                AuditInformationRecordVO record = new AuditInformationRecordVO();
////                BeanUtils.populate(record, date.getJSONObject(i));
////                Long accountBroughtId = auditInformationService.getInputId();//获取流水号
////                record.setAccountBroughtId(accountBroughtId);
//                //创建时间
//                Date date1 = new Date();
//                record.setCreatedTime(date1);
//                //通过网点账号查询网点id
//                //Long siteId = auditInformationService.getSiteIdBySiteAccount(l.getSiteAccount());
////                record.setSiteId(l.getSiteId());
////                record.setSiteAccount(l.getSiteAccount());
////                recordList.add(record);
//            }
//        }
//    }
//}
