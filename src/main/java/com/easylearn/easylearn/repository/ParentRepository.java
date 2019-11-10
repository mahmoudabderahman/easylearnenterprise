package com.easylearn.easylearn.repository;

import com.easylearn.easylearn.entity.Parent;

import java.util.Set;

public interface ParentRepository extends BaseRepository<Parent, Long> {
    Set<Parent> findAll();

}
