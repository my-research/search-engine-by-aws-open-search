package com.example.indexer.service;

import com.example.indexer.document.User;
import com.example.indexer.document.UserDocumentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocumentFinder {

    private final UserDocumentRepository repository;

    public List<User> findUsers() {
        return repository.findAll();
    }

    public User findUserByUserId(Long userId) {
        return repository.findByUserId(userId)
                .orElseThrow(IllegalArgumentException::new);
    }

    public User findUserByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(IllegalArgumentException::new);
    }

    public List<User> findAllUserByPhoneNumber(String phoneNumber) {
        return repository.findByPhoneNumber(phoneNumber);
    }
}
