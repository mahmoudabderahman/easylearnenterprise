package com.easylearn.easylearn.controller;

import com.easylearn.easylearn.model.ParentReqDTO;
import com.easylearn.easylearn.model.ParentRespDTO;
import com.easylearn.easylearn.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/parents/")
public class ParentController {
    private ParentService parentService;

    @Autowired
    public ParentController(ParentService parentService)
    {
        this.parentService = parentService;
    }

    @PostMapping
    public ResponseEntity<ParentRespDTO> createParent(@RequestBody ParentReqDTO request)
    {
        return parentService.createParent(request);
    }

    @GetMapping(path = "/{parentId}")
    public ResponseEntity<ParentRespDTO> findParentById(@PathVariable Long parentId)
    {
        return null;
    }

    @GetMapping
    public ResponseEntity<ParentRespDTO> findAllParents() {return null;}

    @DeleteMapping(path = "/{parentId}")
    public void deleteParent(@PathVariable Long parentId)
    {

    }
}
