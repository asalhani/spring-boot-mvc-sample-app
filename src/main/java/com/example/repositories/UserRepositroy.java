package com.example.repositories;

import com.example.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositroy extends CrudRepository<User, Long> {
}
