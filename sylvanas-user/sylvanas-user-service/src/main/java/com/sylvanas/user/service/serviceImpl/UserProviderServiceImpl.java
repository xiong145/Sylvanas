package com.sylvanas.user.service.serviceImpl;

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


    @Override
    public Map<String, Object> user() {
        HashMap hash = new HashMap<String, Object>() {{
            put("user", "admin");
        }};
        return hash;
    }


}
