package com.easylearn.easylearn.repository;


import com.easylearn.easylearn.entity.Document;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface DocumentRepository extends BaseRepository<Document, Long> {
    Set<Document> findAll();
}
