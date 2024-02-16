package com.amirlearn.amirlearn.services.site;

import com.amirlearn.amirlearn.entities.site.Content;
import com.amirlearn.amirlearn.helper.exceptions.DataNotFoundException;
import com.amirlearn.amirlearn.repositories.site.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContentService {
    @Autowired
    private ContentRepository repository;

    public Content findByKey(String key){
        return repository.findFirstByKey(key);
    }

    public Content getById(long id){
        Optional<Content> data = repository.findById(id);
        if(data.isPresent()) return data.get();
        return null;
    }

    public Content add(Content Content){
        return repository.save(Content);
    }

    public Content update(Content data) throws DataNotFoundException {
        Content oldData = getById(data.getId());
        if(oldData == null) {
            throw new DataNotFoundException("Data with id "+ data.getId() + " - not found");
        }
        oldData.setValue(data.getValue());
        return repository.save(oldData);
    }

    public boolean deleteById(long id) throws DataNotFoundException{
        Content oldData = getById(id);
        if (oldData == null){
            throw new DataNotFoundException("Data with id "+ id + " - not found");
        }
        repository.deleteById(id);
        return true;
    }
}
