package consumer.controller;

//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import org.apache.dubbo.config.annotation.Reference;

import api.dto.HsBasicChargeItemNameDto;
import api.service.IHsBasicChargeItemApiService;
import cn.hutool.core.lang.Assert;
import com.cfne.cuckoo.fin.domain.entity.finance.dto.FinAccountDto;
import com.cfne.cuckoo.fin.service.finance.HsFinAccountService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.log4j.Log4j2;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import userInterface.UserProviderApiService;
//import userInterface.UserProviderApiService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiong
 */
@RestController
@RequestMapping("cuckooTest")
@Log4j2
public class consumerController {

    /**
     * dubbo调用user服务
     */
//    @Reference
//    private UserProviderApiService userProviderApiService;
//
//    @HystrixCommand(fallbackMethod = "userErr")
//    @RequestMapping(value = "user", method = RequestMethod.GET)
//    public Map<String, Object> user() {
//        Map map = userProviderApiService.userApi();
//        return map;
//    }


    @Reference(retries = 0, check = false)
    private HsFinAccountService hsFinAccountService;
//
//    @Reference(retries = 0, check = false, version = "1.0.0")
//    private IHsBasicChargeItemApiService ihsBasicChargeItemApiService;
//
//    @GetMapping("/a")
//    public Map<String, Object> psv() {
//        HsBasicChargeItemNameDto hsBasicChargeItemNameDto = new HsBasicChargeItemNameDto();
//        hsBasicChargeItemNameDto.getChargeItemNameList().addAll(Arrays.asList("派费", "adad"));
//        Map<String, Object> map = ihsBasicChargeItemApiService.selectChargeItemByNameList(hsBasicChargeItemNameDto);
//        log.info(map);
//        return map;
//    }


    //    @HystrixCommand(fallbackMethod = "userErr")
    @RequestMapping(value = "cuckoo", method = RequestMethod.GET)
    public Map<String, Object> user() {
        Map map = hsFinAccountService.queryFinAccount(new FinAccountDto());
        return map;
    }


    public Map<String, Object> userErr() {
        HashMap hash = new HashMap<String, Object>() {{
            put("userErr", "admin");
        }};
        return hash;
    }

    @RequestMapping(value = "consumer", method = RequestMethod.GET)
    public Map<String, Object> consumer() {
        HashMap hash = new HashMap<String, Object>() {{
            put("consumer", "admin");
        }};
        return hash;
    }
}
