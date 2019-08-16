package com.example.demo;

import com.example.model.User;
import com.example.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class UserCommandLineRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(UserCommandLineRunner.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        // save a couple of customers
        userRepository.save(new User("Ranga", "Admin"));
        userRepository.save(new User("Ravi", "User"));
        userRepository.save(new User("Satish", "Admin"));
        userRepository.save(new User("Raghu", "User"));

        for (User user: userRepository.findAll()){
            log.info(user.toString());
        }
        
    }
}
