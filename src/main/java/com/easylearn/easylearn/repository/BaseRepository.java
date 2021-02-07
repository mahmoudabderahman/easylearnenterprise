/**
 * @Author: Mahmoud Abdelrahman
 * Base Repository Interface is where storage, retrieval and search behavior is declared.
 */
package com.easylearn.easylearn.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID>, JpaSpecificationExecutor<T> {
}
