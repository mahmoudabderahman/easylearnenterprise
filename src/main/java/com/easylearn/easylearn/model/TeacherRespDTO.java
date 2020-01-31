package com.easylearn.easylearn.model;

import com.easylearn.easylearn.model.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.management.remote.rmi._RMIConnection_Stub;

@Getter
@Setter
@Builder // It does not work unless, there is a @AllArgsConstructor.
@AllArgsConstructor
public class TeacherRespDTO {
    private Long id; // Was not created in Req, because it will be automatically generated while creating.
    private String lastName;
    private String firstName;
    private String username;
    private String password;
    private UserType userType;
    private String role;


}
