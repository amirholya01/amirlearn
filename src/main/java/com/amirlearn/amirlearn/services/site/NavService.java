package com.amirlearn.amirlearn.services.site;

import com.amirlearn.amirlearn.entities.site.Nav;
import com.amirlearn.amirlearn.entities.site.Nav;
import com.amirlearn.amirlearn.exceptions.DataNotFoundException;
import com.amirlearn.amirlearn.repositories.site.NavRepository;
import com.amirlearn.amirlearn.repositories.site.NavRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NavService {
    @Autowired
    private NavRepository repository;

    public List<Nav> findAllItemOrder(){
        return (List<Nav>) repository.findAllByEnableIsTrue(Sort.by("orderItem"));
    }

    public Nav getById(long id){
        Optional<Nav> data = repository.findById(id);
        if(data.isPresent()) return data.get();
        return null;
    }

    public Nav add(Nav Nav){
        return repository.save(Nav);
    }

    public Nav update(Nav data) throws DataNotFoundException {
        Nav oldData = getById(data.getId());
        if(oldData == null) {
            throw new DataNotFoundException("Data with id "+ data.getId() + " - not found");
        }
        oldData.setTitle(data.getTitle());
        oldData.setLink(data.getLink());
        oldData.setEnable(data.isEnable());
        oldData.setOrderItem(data.getOrderItem());
        return repository.save(oldData);
    }

    public boolean deleteById(long id) throws DataNotFoundException{
        Nav oldData = getById(id);
        if (oldData == null){
            throw new DataNotFoundException("Data with id "+ id + " - not found");
        }
        repository.deleteById(id);
        return true;
    }
}
