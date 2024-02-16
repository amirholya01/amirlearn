package com.amirlearn.amirlearn.repositories.users;

import com.amirlearn.amirlearn.entities.users.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    User findFirstByUsernameAndPassword(String username, String password);
}
