/**
 * @Author: Mahmoud Abdelrahman
 * Authentication Exception class is where all AuthenticationException specifications are declared.
 */
package com.easylearn.easylearn.jwt.resource;

public class AuthenticationException extends RuntimeException {
    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
