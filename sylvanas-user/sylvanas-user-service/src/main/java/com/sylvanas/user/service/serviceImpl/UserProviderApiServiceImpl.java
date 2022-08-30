package com.sylvanas.user.service.serviceImpl;

import org.apache.dubbo.config.annotation.Service;
import userInterface.UserProviderApiService;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserProviderApiServiceImpl implements UserProviderApiService {
    @Override
    public Map<String, Object> userApi() {
        HashMap hash = new HashMap<String, Object>() {{
            put("user", "admin");
        }};
        return hash;
    }
}
