package com.example.indexer.service;

import com.example.indexer.document.User;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EsConnectionTest {
    
    @Autowired
    DocumentCreator creator;
    @Autowired
    DocumentFinder finder;

    @Test
    void 문서를_생성할_수_있다() {
        User user = User.builder()
                .userId(2L)
                .username("junghyunjin")
                .phoneNumber("010-1234-1234")
                .build();

        User createdUser = creator.createUser(user);
        System.out.println("createdUser = " + createdUser);
    }

    @Test
    void 문서를_조회할_수_있다() {
        List<User> users = finder.findUsers();

        for (User user : users) {
            System.out.println("user = " + user);
        }
    }

    @Test
    void 문서를_phoneNumber_로_조회할_수_있다() {
        List<User> users = finder.findAllUserByPhoneNumber("010-1234-1234");

        System.out.println("user.size: " + users.size());
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }
}