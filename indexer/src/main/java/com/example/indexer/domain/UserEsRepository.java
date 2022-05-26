package com.example.indexer.domain;

import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserEsRepository extends ElasticsearchRepository<User, String> {
    List<User> findByPhoneNumber(String phoneNumber);

    List<User> findAll();
}
