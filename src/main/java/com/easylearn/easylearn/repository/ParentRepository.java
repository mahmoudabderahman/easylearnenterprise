/**
 * @Author: Mahmoud Abdelrahman, Steve Titinang
 * Parent Repository Interface is where storage, retrieval and search behavior is declared.
 */
package com.easylearn.easylearn.repository;

import com.easylearn.easylearn.entity.Parent;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ParentRepository extends BaseRepository<Parent, Long> {
    Set<Parent> findAll(Sort sort);

}
