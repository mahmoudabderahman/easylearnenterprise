/**
 * @Author: Mahmoud Abdelrahman
 * Parent Controller is a class, where all CRUD methods implemented.
 */
package com.easylearn.easylearn.controller;

import com.easylearn.easylearn.model.ParentReqDTO;
import com.easylearn.easylearn.model.ParentRespDTO;
import com.easylearn.easylearn.model.StudentRespDTO;
import com.easylearn.easylearn.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/v1/parents")
final class ParentController {
    private final ParentService parentService;

    /**
     * Main Constructor
     *
     * @param parentService is an instance from the ParentService class in Services package.
     */
    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    /**
     * createParent method, which is responsible for creating a new parent
     *
     * @param request is the content of the request passed to the POST method.
     * @return the body of the response.
     */
    @PostMapping
    public ResponseEntity<ParentRespDTO> createParent(@RequestBody ParentReqDTO request) {
        return parentService.createParent(request);
    }

    /**
     * findParentById method, which is responsible for getting a parent by its id
     *
     * @param parentId is the id of the parent, which will be returned back
     * @return the parent which was called.
     */
    @GetMapping(path = "/{parentId}")
    public ParentRespDTO findParentById(@PathVariable Long parentId) {
        return parentService.findParentById(parentId);
    }

    /**
     * findAllParents method, which is responsible for getting all parents.
     *
     * @return list of parents which were gotten from the service instance.
     */
    @GetMapping
    public ResponseEntity findAllParents() {
        return parentService.findAllParents();
    }


    /**
     * updateParent method, which is responsible for updating a specific parent
     *
     * @param parentId the id of the parent, which will be updated
     * @param request  is the content of the request passed to the PUT method.
     * @return the body of the response.
     */
    @PutMapping(path = "/{parentId}")
    public ParentRespDTO updateParent(@PathVariable Long parentId, @Valid @RequestBody ParentReqDTO request) {
        return parentService.updateParent(parentId, request);
    }

    /**
     * assignStudentsToParent method, which is responsible for
     * assigning students to a specific parent.
     *
     * @param parentId   is the id of the parent, to which the students will be passed.
     * @param studentIds the list of students, which will be passed to a parent.
     * @return the body of the response.
     */
    @PostMapping(path = "/{parentId}/students")
    public ParentRespDTO assignStudentsToParent(@PathVariable Long parentId, @RequestBody Set<Long> studentIds) {
        return parentService.assignStudentsToParent(parentId, studentIds);
    }

    /**
     * deleteParent method, which is responsible for deleting a specific parent
     *
     * @param parentId is the id of the parent, to be deleted.
     * @return the body of the response.
     */
    @DeleteMapping(path = "/{parentId}")
    public ResponseEntity deleteParent(@PathVariable Long parentId) {
        return parentService.deleteParent(parentId);
    }
}
