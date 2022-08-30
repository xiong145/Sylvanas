package com.sylvanas.user.controller;

import com.sylvanas.user.service.UserProviderService;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Autowired
    UserProviderService userProviderService;


    @RequestMapping(value = "user", method = RequestMethod.GET)
    public Map<String, Object> user() {
        return userProviderService.user();
    }
}
