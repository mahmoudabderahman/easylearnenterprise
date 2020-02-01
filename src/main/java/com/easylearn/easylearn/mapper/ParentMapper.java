package com.easylearn.easylearn.mapper;

import com.easylearn.easylearn.entity.Parent;
import com.easylearn.easylearn.model.ParentReqDTO;
import com.easylearn.easylearn.model.ParentRespDTO;

import com.easylearn.easylearn.model.enums.UserType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Transient;
import java.util.HashSet;
import java.util.Set;

// firstName, lastName, email, password
@Component
@Transactional
public class ParentMapper implements ObjectMapper<Parent, ParentReqDTO, ParentRespDTO> {

    @Override
    public Parent mapToEntity(ParentReqDTO request) {

        return Parent.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .username(request.getUsername())
                .password(request.getPassword())
                .type(request.getType())
                .userType(UserType.PARENT)
                .build();
    }

    @Override
    public Parent mapToEntity(Parent parent, ParentReqDTO request) {
        parent.setFirstName(request.getFirstName());
        parent.setLastName(request.getLastName());
        parent.setUsername(request.getUsername());
        parent.setPassword(request.getPassword());
        parent.setType(request.getType());
        parent.setUserType(UserType.PARENT);
        return parent;
    }

    @Override
    public ParentRespDTO mapToDTO(Parent parent) {
        return ParentRespDTO.builder()
                .id(parent.getId())
                .firstName(parent.getFirstName())
                .lastName(parent.getLastName())
                .username(parent.getUsername())
                .password(parent.getPassword())
                .type(parent.getType())
                .userType(UserType.PARENT)
                .build();
    }

    @Override
    public Set<ParentRespDTO> mapToDTOs(Set<Parent> parents) {
        if (parents == null || parents.isEmpty())
            return null;
        Set<ParentRespDTO> parentsItr = new HashSet<>();
        parents.forEach(parent -> parentsItr.add(mapToDTO(parent)));
        return parentsItr;
    }
}
