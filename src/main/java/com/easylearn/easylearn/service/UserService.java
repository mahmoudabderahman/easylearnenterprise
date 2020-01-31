package com.easylearn.easylearn.service;

import com.easylearn.easylearn.entity.Parent;
import com.easylearn.easylearn.entity.User;
import com.easylearn.easylearn.jwt.JwtUserDetails;
import com.easylearn.easylearn.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Log4j2
@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private BCryptPasswordEncoder encoder;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.encoder  = new BCryptPasswordEncoder();
    }

    public Set<JwtUserDetails> getJwtUsers() {
        Set<JwtUserDetails> jwtUsers = new HashSet<>();

        Set<User> users = userRepository.findAll(Sort.by("lastName"));
        for (User user : users) {
            jwtUsers.add(new JwtUserDetails(user.getId(), user.getUsername(), encoder.encode(user.getPassword()), "ROLE_USER_2"));
        }
        return jwtUsers;
    }
}
