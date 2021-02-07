/**
 * @Author: Mahmoud Abdelrahman
 * JwtTokenResponse is a class, where the specifications of a JwtToken response
 * are implemented.
 */
package com.easylearn.easylearn.jwt.resource;

import com.easylearn.easylearn.model.enums.UserType;

import java.io.Serializable;

public class JwtTokenResponse implements Serializable {
    private static final long serialVersionUID = 8317676219297719109L;

    private String token;
    private Long id;


    private String username;
    private UserType userType;

    public JwtTokenResponse(String token, Long id, String username, UserType userType) {
        this.token = token;
        this.id = id;
        this.username = username;
        this.userType = userType;
    }

    public String getToken() {
        return this.token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
