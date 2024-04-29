package org.github.bubochkana.enums;

import lombok.Getter;

@Getter
public enum HttpStatus {
  OK(200, "OK"),
  CREATED(201, "Created"),
  NOT_FOUND(404, "Not Found");
  private final int statusCode;
  private final String status;

  HttpStatus(int statusCode, String status) {
    this.statusCode = statusCode;
    this.status = status;
  }
}
