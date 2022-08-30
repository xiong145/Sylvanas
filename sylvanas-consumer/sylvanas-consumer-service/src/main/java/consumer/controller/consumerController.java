package user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiong
 */
@RestController
@RequestMapping("consumer")
public class consumerController {


    @RequestMapping(value = "consumer", method = RequestMethod.GET)
    public Map<String, Object> user() {
        HashMap hash = new HashMap<String, Object>() {{
            put("consumer", "admin");
        }};
        return hash;
    }
}
