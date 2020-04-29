package com.hyune.raider50g.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dev-api")
public class DevController {

  @GetMapping("/test")
  public String test() {
    return "hello";
  }
}
