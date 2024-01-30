package org.example.demo.services;

import org.example.demo.models.User;
import org.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User create(User user) {

        // Dodajemy kod do obsługi innych operacji przed zapisaniem użytkownika
        // ...

        return userRepository.save(user);
    }

    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password).orElse(null);
    }
}
