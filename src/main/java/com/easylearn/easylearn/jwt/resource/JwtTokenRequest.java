/**
 * @Author: Mahmoud Abdelrahman, Steve Titinang
 * JwtTokenRequest is a class, where the specifications of a JwtToken request is implemented.
 */
package com.easylearn.easylearn.jwt.resource;

import java.io.Serializable;

public class JwtTokenRequest implements Serializable {
    private static final long serialVersionUID = -5616176897013108345L;

    private String username;
    private String password;

    public JwtTokenRequest() {
        super();
    }

    public JwtTokenRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
