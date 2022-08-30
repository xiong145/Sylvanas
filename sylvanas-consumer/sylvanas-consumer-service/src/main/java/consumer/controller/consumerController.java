package consumer.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import userInterface.UserProviderApiService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiong
 */
@RestController
@RequestMapping("consumer")
public class consumerController {

    /**
     * dubbo调用user服务
     */
    @Reference
    private UserProviderApiService userProviderApiService;


    @RequestMapping(value = "user", method = RequestMethod.GET)
    public Map<String, Object> user() {
        Map map = userProviderApiService.userApi();
        return map;
    }


    @RequestMapping(value = "consumer", method = RequestMethod.GET)
    public Map<String, Object> consumer() {
        HashMap hash = new HashMap<String, Object>() {{
            put("consumer", "admin");
        }};
        return hash;
    }
}
