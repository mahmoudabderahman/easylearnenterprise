package com.easylearn.easylearn.controller;

import com.easylearn.easylearn.entity.User;
import com.easylearn.easylearn.repository.UserRepository;
import com.easylearn.easylearn.service.ParentService;
import com.easylearn.easylearn.service.SecurityService;
import com.easylearn.easylearn.service.StudentService;
import com.easylearn.easylearn.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityService securityService;

    /*
    @GetMapping
    public Set<ResponseEntity> findAllUsers() {
        users.addAll(teacherService.findAllTeachers().getBody());
        users.addAll(studentService.findAllStudents().getBody());
        users.addAll(parentService.findAllParents().getBody());
        return users;
    }
    */

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap modelMap)
    {
        boolean loginResponse = securityService.login(email, password);
        if (loginResponse) {
            return "You have access";
        }
        else
        {
            modelMap.addAttribute("msg", "Invalid user name or password. Please try again.");
        }
        return "login";
    }
//    @GetMapping(produces = "application/json")
//    @RequestMapping({ "/validateLogin" })
//    public User validateLogin() {
//        return new User("User successfully authenticated");
//    }
}
