package com.example.indexer.service;

import com.example.indexer.domain.User;
import com.example.indexer.domain.UserEsRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final UserEsRepository repository;

    public User createUser(User user) {
        return repository.save(user);
    }

    public User getUserById(String id) {
        return repository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    public List<User> getUsersByPhoneNumber(String phoneNumber) {
        return repository.findByPhoneNumber(phoneNumber);
    }
}
