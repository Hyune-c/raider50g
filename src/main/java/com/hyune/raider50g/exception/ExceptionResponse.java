package com.hyune.raider50g.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionResponse {

  private final String exceptionClass;
  private final String message;

  public static ExceptionResponse from(Exception e) {
    return ExceptionResponse.builder()
        .exceptionClass(e.getClass().toString())
        .message(e.getMessage())
        .build();
  }
}
