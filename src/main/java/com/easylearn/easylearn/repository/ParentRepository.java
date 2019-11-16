package com.easylearn.easylearn.repository;

import com.easylearn.easylearn.entity.Parent;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ParentRepository extends BaseRepository<Parent, Long> {
    Set<Parent> findAll();

}
