package com.amirlearn.amirlearn.repositories.videos;

import com.amirlearn.amirlearn.entities.videos.Video;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends PagingAndSortingRepository<Video, Long>, JpaRepository<Video, Long> {
    @Query("from Video where category.id = :categoryId")
    List<Video> findAllByCategory(long categoryId);


    @Query("from Video where enable = true and  title like concat('%', :search, '%') or description like concat('%', :search, '%') ")
    List<Video> findAllByEnableIsTrueAndTitleContainsOrDescriptionContains(String search);

}
