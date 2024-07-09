package com.amzur.registration.practice.handlers;

public class UserAlreadyExistsException extends RuntimeException {
  public UserAlreadyExistsException(String msg)
  {
	  super(msg);
  }
}
