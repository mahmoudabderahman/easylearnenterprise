package com.easylearn.easylearn.service;

import com.easylearn.easylearn.entity.Parent;
import com.easylearn.easylearn.mapper.ParentMapper;
import com.easylearn.easylearn.model.ParentReqDTO;
import com.easylearn.easylearn.model.ParentRespDTO;
import com.easylearn.easylearn.repository.ParentRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Log4j2
@Service
@Transactional
public class ParentService {
    private final ParentRepository parentRepository;
    private final ParentMapper parentMapper;
    @Autowired
    public ParentService(ParentRepository parentRepository, ParentMapper parentMapper)
    {
        this.parentRepository = parentRepository;
        this.parentMapper = parentMapper;
    }

    public ResponseEntity<ParentRespDTO> createParent(ParentReqDTO request)
    {
        log.trace(" *** START OF SAVING APPOINTMENT *** ");
        Parent parent = parentMapper.mapToEntity(request);
        parent = parentRepository.save(parent);
        ParentRespDTO response = parentMapper.mapToDTO(parent);
        log.trace(" *** END OF SAVING APPOINTMENT *** ");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
