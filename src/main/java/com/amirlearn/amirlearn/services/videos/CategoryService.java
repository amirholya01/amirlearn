package com.amirlearn.amirlearn.services.videos;


import com.amirlearn.amirlearn.entities.videos.Category;
import com.amirlearn.amirlearn.helper.exceptions.DataNotFoundException;
import com.amirlearn.amirlearn.repositories.videos.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public List<Category> findAllItemOrder(){
        return (List<Category>) repository.findAllByEnableIsTrue(Sort.by("id"));
    }

    public Category getById(long id){
        Optional<Category> data = repository.findById(id);
        if(data.isPresent()) return data.get();
        return null;
    }

    public Category add(Category Category){
        return repository.save(Category);
    }

    public Category update(Category data) throws DataNotFoundException {
        Category oldData = getById(data.getId());
        if(oldData == null) {
            throw new DataNotFoundException("Data with id "+ data.getId() + " - not found");
        }
        oldData.setTitle(data.getTitle());
        oldData.setLink(data.getLink());
        oldData.setImage(data.getImage());

        oldData.setEnable(data.isEnable());
        oldData.setOrderItem(data.getOrderItem());
        return repository.save(oldData);
    }

    public boolean deleteById(long id) throws DataNotFoundException{
        Category oldData = getById(id);
        if (oldData == null){
            throw new DataNotFoundException("Data with id "+ id + " - not found");
        }
        repository.deleteById(id);
        return true;
    }
}
