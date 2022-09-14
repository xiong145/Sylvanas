package consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    @HystrixCommand(fallbackMethod = "userErr")
    @RequestMapping(value = "user", method = RequestMethod.GET)
    public Map<String, Object> user() {
        Map map = userProviderApiService.userApi();
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
