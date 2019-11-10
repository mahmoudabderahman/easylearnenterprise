package com.easylearn.easylearn.controller;

import com.easylearn.easylearn.model.ParentReqDTO;
import com.easylearn.easylearn.model.ParentRespDTO;
import com.easylearn.easylearn.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/parents")
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
    public ParentRespDTO findParentById(@PathVariable Long parentId)
    {
        return parentService.findParentById(parentId);
    }

    @GetMapping
    public ResponseEntity findAllParents() {
        return parentService.findAllParents();
    }

    /**
     * API to update a specific workout
     *
     * @param parentId used to get the parentId
     * @param request   used to get the request body
     * @return ParentRespDTO
     */
    @PutMapping(path = "/{parentId}")
    public ParentRespDTO updateParent(@PathVariable Long parentId, @Valid @RequestBody ParentReqDTO request) {
        return parentService.updateParent(parentId, request);
    }

    @DeleteMapping(path = "/{parentId}")
    public ResponseEntity deleteParent(@PathVariable Long parentId)
    {
        return parentService.deleteParent(parentId);
    }
}
