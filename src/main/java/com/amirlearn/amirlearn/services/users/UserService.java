package com.amirlearn.amirlearn.services.users;


import com.amirlearn.amirlearn.entities.users.User;
import com.amirlearn.amirlearn.helper.exceptions.DataNotFoundException;
import com.amirlearn.amirlearn.repositories.users.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User auth(String username, String password){
        //TODO: hash password
        return repository.findFirstByUsernameAndPassword(username, password);
    }
    public User getById(long id){
        Optional<User> data = repository.findById(id);
        if(data.isPresent()) return data.get();
        return null;
    }


    public User add(User User){
        return repository.save(User);
    }

    public User update(User data) throws DataNotFoundException{
        User oldData = getById(data.getId());
        if(oldData == null) {
            throw new DataNotFoundException("Data with id "+ data.getId() + " - not found");
        }
        oldData.setEmail(data.getEmail());
        oldData.setEnable(data.isEnable());
        return repository.save(oldData);
    }

    public boolean deleteById(long id) throws DataNotFoundException{
        User oldData = getById(id);
        if(oldData == null) {
            throw new DataNotFoundException("Data with id "+ id + " - not found");
        }
        repository.deleteById(id);
        return true;
    }

    public User changePassword(long id, String oldPassword, String newPassword) throws Exception {
        //TODO: hash password

        User user = getById(id);
        if(user == null){
            throw  new DataNotFoundException("User not found");
        }
        if(!user.getPassword().equals(oldPassword))
            throw new Exception("Invalided old password");
        user.setPassword(newPassword);
        return repository.save(user);
    }
}
