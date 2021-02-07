/**
 * @Author: Mahmoud Abdelrahman
 * Teacher Request Data Transfer Object is where the specifications required for requests declared.
 */
package com.easylearn.easylearn.model;

import com.easylearn.easylearn.model.enums.UserType;
import lombok.*;

import javax.validation.constraints.Email;

@Getter
@Builder // It does not work unless, there is a @AllArgsConstructor.
@AllArgsConstructor
public class TeacherReqDTO {
    private String lastName;
    private String firstName;

    @Email(message = "Invalid email address")
    private String username;

    private String password;

    private UserType userType;

}
