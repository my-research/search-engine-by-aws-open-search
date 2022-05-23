package com.example.indexer.document;

import java.util.List;
import java.util.Optional;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserDocumentRepository extends ElasticsearchRepository<User, String> {
    Optional<User> findByUserId(Long userId);

    Optional<User> findByUsername(String username);

    List<User> findByPhoneNumber(String phoneNumber);

    List<User> findAll();
}
