package com.hyune.raider50g.model;


import java.util.HashMap;
import java.util.Map;

public class ApiResponse {

  private Map<String, ?> response;

  public ApiResponse(Map<String, ?> responseMap) {
    this.response = responseMap;
  }

  public static ApiResponse ok(String message) {
    Map<String, String> responseMap = new HashMap<>();
    responseMap.put("message", message);

    return new ApiResponse(responseMap);
  }

  public static ApiResponse error(String message, String errorTrace) {
    Map<String, String> responseMap = new HashMap<>();
    responseMap.put("message", message);
    responseMap.put("errorTrace", errorTrace);

    return new ApiResponse(responseMap);
  }

  public Map<String, ?> getResponse() {
    return response;
  }
}
