package com.easylearn.easylearn.repository;

import com.easylearn.easylearn.entity.User;
import org.springframework.data.domain.Sort;

import java.util.Set;

public interface UserRepository extends BaseRepository<User, Long> {
    Set<User> findAll(Sort sort);

}
