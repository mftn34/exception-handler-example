package com.mtfn.exception.handler.data;

import com.mtfn.exception.handler.enums.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;



@Component
public class RestResponseGenerator {

  public ResponseEntity<Object> success() {

    return success("");
  }

  public <T> ResponseEntity<Object> success(T responseData) {

    return success(responseData, HttpStatus.OK);
  }

  public <T> ResponseEntity<Object> success(T responseData, HttpStatus httpStatus) {
    var baseResponse = BaseResponse.<T>builder()
                                     .status(httpStatus.value())
                                     .data(responseData)
                                     .build();
    return new ResponseEntity<>(baseResponse, httpStatus);
  }

  public ResponseEntity<Object> error(HttpStatus httpStatus, String error, String errorMessage) {
    var baseResponse = BaseResponse.builder()
                                     .status(httpStatus.value())
                                     .error(error)
                                     .message(errorMessage)
                                     .build();
    return new ResponseEntity<>(baseResponse, httpStatus);
  }

  public ResponseEntity<Object> error(HttpStatus httpStatus, String error, String errorMessage, String errorCode) {
    var baseResponse = BaseResponse.builder()
                                     .status(httpStatus.value())
                                     .error(error)
                                     .errorCode(errorCode)
                                     .message(errorMessage)
                                     .build();
    return new ResponseEntity<>(baseResponse, httpStatus);
  }

  public <T> ResponseEntity<Object> error(HttpStatus httpStatus, String error, String errorMessage, T responseData) {
    var baseResponse = BaseResponse.builder()
                                     .status(httpStatus.value())
                                     .error(error)
                                     .message(errorMessage)
                                     .data(responseData)
                                     .build();
    return new ResponseEntity<>(baseResponse, httpStatus);
  }

  public ResponseEntity<Object> badRequest(String errorMessage, ErrorCode errorCode) {
    var baseResponse = BaseResponse.builder()
                                     .status(HttpStatus.BAD_REQUEST.value())
                                     .error(errorCode.getName())
                                     .errorCode(errorCode.getCode())
                                     .message(errorMessage)
                                     .build();
    return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
  }

  public ResponseEntity<Object> badRequest(ErrorCode errorCode) {
    var baseResponse = BaseResponse.builder()
                                     .status(HttpStatus.BAD_REQUEST.value())
                                     .error(errorCode.getName())
                                     .errorCode(errorCode.getCode())
                                     .message(errorCode.getName())
                                     .build();
    return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
  }
}
