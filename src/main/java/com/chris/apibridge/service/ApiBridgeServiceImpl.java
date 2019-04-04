package com.chris.apibridge.service;

import org.springframework.stereotype.Service;

@Service
public class ApiBridgeServiceImpl implements ApiBridgeService {

  @Override
  public String invokeDll(String traffic) {
    return traffic;
  }
}
