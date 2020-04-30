package com.hyune.raider50g.model;

import lombok.Getter;

@Getter
public class ApiResponse<T> {

  private final T body;

  private ApiResponse(T body) {
    this.body = body;
  }

  public static <T> ApiResponse ok(T body) {
    return new ApiResponse(body);
  }

  public static <T> ApiResponse error(T body) {
    return new ApiResponse(body);
  }
}
