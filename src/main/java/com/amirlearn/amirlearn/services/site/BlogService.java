package com.amirlearn.amirlearn.services.site;

import com.amirlearn.amirlearn.entities.site.Blog;
import com.amirlearn.amirlearn.helper.exceptions.DataNotFoundException;
import com.amirlearn.amirlearn.repositories.site.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    private BlogRepository repository;

    public List<Blog> search(String keyboard){
        return repository.findAllByTitleContainsOrDescriptionContains(keyboard);
    }

    public Blog getById(long id){
        Optional<Blog> data = repository.findById(id);
        if(data.isPresent()) return data.get();
        return null;
    }

    public Blog add(Blog Blog){
        return repository.save(Blog);
    }

    public Blog update(Blog data) throws DataNotFoundException {
        Blog oldData = getById(data.getId());
        if(oldData == null) {
            throw new DataNotFoundException("Data with id "+ data.getId() + " - not found");
        }
        oldData.setTitle(data.getTitle());
        oldData.setImage(data.getImage());
        oldData.setDescription(data.getDescription());
        oldData.setStatus(data.getStatus());
        return repository.save(oldData);
    }

    public boolean deleteById(long id) throws DataNotFoundException{
        Blog oldData = getById(id);
        if (oldData == null){
            throw new DataNotFoundException("Data with id "+ id + " - not found");
        }
        repository.deleteById(id);
        return true;
    }
}
