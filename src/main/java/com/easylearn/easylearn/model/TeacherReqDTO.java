package com.easylearn.easylearn.model;

import com.easylearn.easylearn.model.enums.UserType;
import lombok.*;

import javax.validation.constraints.Email;

@Getter
@Setter
@Builder // It does not work unless, there is a @AllArgsConstructor.
@AllArgsConstructor
public class TeacherReqDTO {
    private String lastName;
    private String firstName;

    @Email(message = "Invalid email address")
    private String email;

    private String password;

    private UserType userType;

}
