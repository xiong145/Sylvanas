//package test.server;
//
//
//import cn.hutool.core.util.IdUtil;
//import com.alibaba.fastjson.JSONObject;
//
//import com.cfne.cuckoo.fin.domain.entity.finance.webvo.QuoteTestVo;
//import com.cfne.cuckoo.fin.service.finance.IQuoteTestService;
//import org.apache.dubbo.config.annotation.DubboReference;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
////@RestController
//@Service
////@RequestMapping("/dome")
//public class dubbo {
//
//    @DubboReference
//    IQuoteTestService iQuoteTestService;
//
//    //    @GetMapping("/1")
//    public String psvm() {
//        List<QuoteTestVo> list = new ArrayList<>();
//        QuoteTestVo quoteTestVo = new QuoteTestVo();
//        quoteTestVo.setQuoteId(IdUtil.simpleUUID());
//        quoteTestVo.setSendSite("9338");
//        quoteTestVo.setDispatchSite("9372");
//        quoteTestVo.setServiceMode("111");
//        quoteTestVo.setAccountingType("0");
//        quoteTestVo.setFeeType("28");
//        quoteTestVo.setProductType("24");
//        quoteTestVo.setWeight("100");
//        quoteTestVo.setWhetherlightCastGoods("0");
//        quoteTestVo.setQuoteTime("2022-08-09 16:02:39");
//        list.add(quoteTestVo);
//        Map<String, Object> map = null;
////        Map<String, Object> map = iQuoteTestService.selectQuote(list);
//
//        System.out.println(JSONObject.toJSONString(map));
//        return JSONObject.toJSONString(map);
//    }
//
//
//}
