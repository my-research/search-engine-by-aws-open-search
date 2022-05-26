package com.example.indexer.service;

import com.example.indexer.domain.User;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EsConnectionTest {

    @Autowired
    DocumentService service;

    @Test
    void 문서를_생성할_수_있다() {
        User user = User.builder()
                .userId(2L)
                .username("jangwonik")
                .phoneNumber("010-1234-12345")
                .build();

        User createdUser = service.createUser(user);
        System.out.println("createdUser = " + createdUser);
    }

    @Test
    void 문서를_phoneNumber_로_조회할_수_있다() {
        List<User> users = service.getUsersByPhoneNumber("010-1234-1234");

        System.out.println("user.size: " + users.size());
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }

    @Test
    void 단일_문서를_조회할_수_있다() {
        List<User> users = service.getUsersByPhoneNumber("010-1234-1234");

        User user = service.getUserById(users.get(0).getId());
        System.out.println("user = " + user);
    }

    @Test
    void 단일_문서를_갱신할_수_있다() {
        List<User> users = service.getUsersByPhoneNumber("010-1234-12345");

        User user = service.getUserById(users.get(0).getId());
        System.out.println("user = " + user);
        user.setUsername("kim-jung-kyu");

        service.createUser(user);

        List<User> users2 = service.getUsersByPhoneNumber("010-1234-12345");
        System.out.println("user = " + users2.get(0));
    }
}