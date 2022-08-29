package com.sylvanas.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiong
 */
@RestController
@RequestMapping("user")
public class userController {


    @RequestMapping(value = "user", method = RequestMethod.GET)
    public Map<String, Object> user() {
        HashMap hash = new HashMap<String, Object>() {{
            put("user", "admin");
        }};
        return hash;
    }
}
