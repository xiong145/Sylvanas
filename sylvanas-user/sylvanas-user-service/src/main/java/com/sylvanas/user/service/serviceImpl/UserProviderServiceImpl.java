package com.sylvanas.user.service.serviceImpl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sylvanas.user.service.UserProviderService;
import org.apache.dubbo.config.annotation.Service;
import userInterface.UserProviderApiService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiong
 */
@Service
public class UserProviderServiceImpl implements UserProviderService {


    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    @Override
    public Map<String, Object> user() {
        HashMap hash = new HashMap<String, Object>() {{
            put("user", "admin");
        }};
        return hash;
    }



}
