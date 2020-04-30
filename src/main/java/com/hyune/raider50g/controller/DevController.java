package com.hyune.raider50g.controller;

import com.hyune.raider50g.model.ApiResponse;
import com.hyune.raider50g.service.DevService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dev-api")
public class DevController {

  private final DevService devService;

  public DevController(DevService devService) {
    this.devService = devService;
  }

  @GetMapping("/test")
  public String test() {
    return "hello";
  }

  @GetMapping("/pingpong")
  public ApiResponse addPingPong() {
    return ApiResponse.ok(devService.addPingPong());
  }

  @GetMapping("/echo")
  public ApiResponse echo() {
    return ApiResponse.ok(devService.addEcho());
  }
}
