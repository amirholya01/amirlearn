package com.amirlearn.amirlearn.repositories.site;

import com.amirlearn.amirlearn.entities.site.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends PagingAndSortingRepository<Content, Long>, JpaRepository<Content, Long> {
    Content findFirstByKey(String key);
}
