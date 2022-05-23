package com.example.indexer.service;

import com.example.indexer.document.User;
import com.example.indexer.document.UserDocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocumentCreator {

    private final UserDocumentRepository repository;

    public User createUser(User user) {
        return repository.save(user);
    }
}
