/**
 * @Author: Mahmoud Abdelrahman, Steve Titinang
 * Document Repository Interface is where storage, retrieval and search behavior is declared.
 */
package com.easylearn.easylearn.repository;


import com.easylearn.easylearn.entity.Document;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Repository
@Transactional
public interface DocumentRepository extends BaseRepository<Document, Long> {
    Document findByNameOfFile(String fileName);

    Set<Document> findAllByCourseId(Long courseId);
}
