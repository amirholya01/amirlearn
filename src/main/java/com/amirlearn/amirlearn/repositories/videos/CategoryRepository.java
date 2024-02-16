package com.amirlearn.amirlearn.repositories.videos;

import com.amirlearn.amirlearn.entities.videos.Category;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
    List<Category> findAllByEnableIsTrue(Sort sort);
}
