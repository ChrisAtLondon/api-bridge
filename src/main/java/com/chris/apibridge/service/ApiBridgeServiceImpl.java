package com.chris.apibridge.service;

import com.chris.apibridge.libary.ApiBridgeLibary;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiBridgeServiceImpl implements ApiBridgeService {

  @Override
  public String invokeDll(String traffic) {
//      return traffic;
      String rs =  ApiBridgeLibary.INSTANCE.loadData("Hello, world");
      return rs;
  }
}
