/**
 * @Author: Mahmoud Abdelrahman
 * ParentMapper class is where the code required for mapping parents declared.
 */
package com.easylearn.easylearn.mapper;

import com.easylearn.easylearn.entity.Parent;
import com.easylearn.easylearn.model.ParentReqDTO;
import com.easylearn.easylearn.model.ParentRespDTO;

import com.easylearn.easylearn.model.enums.UserType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Component
@Transactional
public class ParentMapper implements ObjectMapper<Parent, ParentReqDTO, ParentRespDTO> {

    /**
     * mapToEntity method, which is responsible for mapping requests to entities,
     * used mainly for the creation of parents.
     *
     * @param request is the request body, which will be passed to this method
     * @return the parent entity object after being built.
     */
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

    /**
     * mapToEntity method, which is responsible for mapping requests to entities,
     * used mainly for the update of parents.
     *
     * @param parent is the already created parent entity, which will be modified.
     * @param request     is the body of the modifications.
     * @return the parent entity after being modified.
     */
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

    /**
     * mapToDTO method, which is responsible for mapping entities to data transfer objects,
     * used mainly for getting specific parent
     *
     * @param parent the appointment entity, that will be mapped
     * @return the parent entity object after being built.
     */
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

    /**
     * mapToDTO method, which is responsible for mapping list of entities to data transfer objects,
     * used mainly for getting several parents.
     *
     * @param parents is the list of parents, that will be mapped.
     * @return list of parents entities.
     */
    @Override
    public Set<ParentRespDTO> mapToDTOs(Set<Parent> parents) {
        if (parents == null || parents.isEmpty())
            return null;
        Set<ParentRespDTO> parentsItr = new HashSet<>();
        parents.forEach(parent -> parentsItr.add(mapToDTO(parent)));
        return parentsItr;
    }
}
