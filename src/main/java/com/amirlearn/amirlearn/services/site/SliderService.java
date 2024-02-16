package com.amirlearn.amirlearn.services.site;

import com.amirlearn.amirlearn.entities.site.Slider;
import com.amirlearn.amirlearn.exceptions.DataNotFoundException;
import com.amirlearn.amirlearn.repositories.site.SliderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SliderService {
    @Autowired
    private SliderRepository repository;

    public List<Slider> findAllItemOrder(){
        return (List<Slider>) repository.findAllByEnableIsTrue(Sort.by("orderItem"));
    }

    public Slider getById(long id){
        Optional<Slider> data = repository.findById(id);
        if(data.isPresent()) return data.get();
        return null;
    }

    public Slider add(Slider slider){
        return repository.save(slider);
    }

    public Slider update(Slider data) throws DataNotFoundException {
        Slider oldData = getById(data.getId());
        if(oldData == null) {
            throw new DataNotFoundException("Data with id "+ data.getId() + " - not found");
        }
        oldData.setTitle(data.getTitle());
        oldData.setLink(data.getLink());
        oldData.setImage(data.getImage());
        oldData.setDescription(data.getDescription());
        oldData.setEnable(data.isEnable());
        oldData.setOrderItem(data.getOrderItem());
        return repository.save(oldData);
    }

    public boolean deleteById(long id) throws DataNotFoundException{
        Slider oldData = getById(id);
        if (oldData == null){
            throw new DataNotFoundException("Data with id "+ id + " - not found");
        }
        repository.deleteById(id);
        return true;
    }
}
