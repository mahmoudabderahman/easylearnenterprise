package com.easylearn.easylearn.service;

import com.easylearn.easylearn.entity.Parent;
import com.easylearn.easylearn.model.ParentReqDTO;
import com.easylearn.easylearn.model.ParentRespDTO;
import com.easylearn.easylearn.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ParentService {
    private ParentRepository parentRepository;

    @Autowired
    public ParentService(ParentRepository parentRepository)
    {
        this.parentRepository = parentRepository;
    }

    public ResponseEntity<ParentRespDTO> createParent(ParentReqDTO request)
    {
        Parent parent = Parent.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        parent = parentRepository.save(parent);

        ParentRespDTO response = ParentRespDTO.builder()
                .id(parent.getId())
                .firstName(parent.getFirstName())
                .lastName(parent.getLastName())
                .password(parent.getPassword())
                .email(parent.getEmail())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
