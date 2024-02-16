package com.amirlearn.amirlearn.repositories.site;

import com.amirlearn.amirlearn.entities.site.Slider;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SliderRepository extends PagingAndSortingRepository<Slider, Long>, JpaRepository<Slider, Long> {
    List<Slider> findAllByEnableIsTrue(Sort sort);

//    Optional<Slider> findById(Long id);
//
//    Slider save(Slider slider);
}
