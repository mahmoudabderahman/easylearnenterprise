package com.easylearn.easylearn.repository;

import com.easylearn.easylearn.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {
    User findByEmail(String username);
}
