/**
 * @Author: Mahmoud Abdelrahman
 * Result Repository Interface is where storage, retrieval and search behavior is declared.
 */
package com.easylearn.easylearn.repository;

import com.easylearn.easylearn.entity.Result;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ResultRepository extends BaseRepository<Result, Long> {
    Result findByCourseIdAndStudentId(Long courseId, Long studentId);


}
