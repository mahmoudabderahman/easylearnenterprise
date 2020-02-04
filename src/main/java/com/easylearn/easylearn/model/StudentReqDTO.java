/**
 * @Author: Mahmoud Abdelrahman, Steve Titinang
 * Student Request Data Transfer Object is where the specifications required for requests declared.
 */
package com.easylearn.easylearn.model;


import javax.validation.constraints.Email;

import com.easylearn.easylearn.model.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder // It does not work unless, there is a @AllArgsConstructor.
@AllArgsConstructor
public class StudentReqDTO {

    private String firstName;

    private String lastName;

    @Email(message = "Invalid email address")
    private String username;

    private String password;
    private UserType userType;

}
