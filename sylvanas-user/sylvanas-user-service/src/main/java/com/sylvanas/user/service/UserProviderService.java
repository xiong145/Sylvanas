package com.sylvanas.user.service;

import org.springframework.stereotype.Service;
import userInterface.UserProviderApiService;

import java.util.Map;

/**
 * @author xiong
 */
public interface UserProviderService   {


    Map<String, Object> user();
}
