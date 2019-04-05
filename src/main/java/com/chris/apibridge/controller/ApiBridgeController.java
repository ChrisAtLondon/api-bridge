package com.chris.apibridge.controller;

import com.chris.apibridge.service.ApiBridgeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@Api(value = "API Bridge Service", description = "Bridge RESTful http between client and Dll ")
public class ApiBridgeController {
  private static final Logger LOG = LoggerFactory.getLogger(ApiBridgeController.class);
  @Autowired ApiBridgeServiceImpl apiBridgeService;

  @RequestMapping(
      value = "/bridge/traffic",
      method = RequestMethod.POST,
      produces = "application/json")
  @ApiOperation(value = "Send data through bridge", response = String.class)
  public ResponseEntity<String> invokeDll(
      @RequestBody
          @ApiParam(value = "data to send", required = true)
          @RequestParam(value = "traffic")
          String traffic) {
    String response = apiBridgeService.invokeDll(traffic);

    return new ResponseEntity(response, HttpStatus.CREATED);
  }
}
