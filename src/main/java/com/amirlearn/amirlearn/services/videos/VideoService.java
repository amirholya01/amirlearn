package com.amirlearn.amirlearn.services.videos;


import com.amirlearn.amirlearn.entities.videos.Video;
import com.amirlearn.amirlearn.helper.exceptions.DataNotFoundException;
import com.amirlearn.amirlearn.repositories.videos.VideoRepository;
import com.amirlearn.amirlearn.repositories.videos.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService {
    @Autowired
    private VideoRepository repository;

    public List<Video> findAllItemOrder(long categoryId){
        return repository.findAllByCategory(categoryId);
    }

    public List<Video> search(String keyword){
        return repository.findAllByEnableIsTrueAndTitleContainsOrDescriptionContains(keyword);
    }
    public Video getById(long id){
        Optional<Video> data = repository.findById(id);
        if(data.isPresent()) return data.get();
        return null;
    }

    public Video add(Video Video){
        return repository.save(Video);
    }

    public Video update(Video data) throws DataNotFoundException {
        Video oldData = getById(data.getId());
        if(oldData == null) {
            throw new DataNotFoundException("Data with id "+ data.getId() + " - not found");
        }
        oldData.setTitle(data.getTitle());
        oldData.setDescription(data.getDescription());
        oldData.setImage(data.getImage());
        oldData.setUrl(data.getUrl());
        oldData.setEnable(data.isEnable());
//        oldData.setCategory(data.getCategory());

        return repository.save(oldData);
    }
    public Video increaseVisitCount(long id) throws DataNotFoundException{
        Video oldData = getById(id);
        if(oldData == null){
            throw new DataNotFoundException("Data with id "+ id + " - not found");
        }
        oldData.setVisitCount(oldData.getVisitCount());
        return repository.save(oldData);
    }

    public boolean deleteById(long id) throws DataNotFoundException{
        Video oldData = getById(id);
        if (oldData == null){
            throw new DataNotFoundException("Data with id "+ id + " - not found");
        }
        repository.deleteById(id);
        return true;
    }
}
