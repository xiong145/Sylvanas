package test.Controller;


import cn.hutool.core.util.IdUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author xiong
 */
@RequestMapping(value = "/testController")
@RestController
public class testController {

    @PostMapping(value = "kuaiyun")
    public String kuaiyun( ) {

//
//        List<String> ll=new ArrayList<>();
//        ll.stream().filter(i->i.)
//        Random r = new Random();
//        System.out.println(str);
//        return "{\"Status\":\"true\",\"ErroeMsg\":\"查询成功!\",\"date\":\"[{\"accnbr\":\"571909872210406\",\"ccynbr\":\"10\",\"dmanam\":\"测试\",\"dmanbr\":\"456123\",\"rpyacc\":\"000029\",\"rpynam\":\"炫辉测试000029\",\"trxamt\":\"" + r.nextInt(18) + "\",\"trxdir\":\"D\",\"trxnbr\":\"" + IdUtil.simpleUUID() + "\",\"trxtim\":\"164009\",\"trxtxt\":\"312\"}]\"}";
        return "ssssss";

    }


}

