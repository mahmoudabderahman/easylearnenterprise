package com.easylearn.easylearn.model;

import com.easylearn.easylearn.model.enums.ParentType;

import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder // It does not work unless, there is a @AllArgsConstructor.
@AllArgsConstructor

public class ParentReqDTO {
    private String firstName;

    private String lastName;

    @Email(message = "Invalid email address")
    private String email;

    private String password;

    private ParentType type;
}
