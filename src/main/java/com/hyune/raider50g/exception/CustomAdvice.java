package com.hyune.raider50g.exception;


import com.hyune.raider50g.model.ApiResponse;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomAdvice {

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ApiResponse handleException(Exception e) {
    return ApiResponse.error(e.getMessage());
  }

  @ExceptionHandler({ParseException.class, CustomParseException.class})
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ApiResponse handleParseException(ParseException e) {
    return ApiResponse.error(e.getMessage());
  }
}
