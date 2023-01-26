package com.rest.api.data;


import com.github.javafaker.Faker;
import com.rest.api.entity.Post;
import com.rest.api.entity.User;
import com.rest.api.service.PostService;
import com.rest.api.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class SampleDataLoader implements CommandLineRunner {

    private final UserService userService;
    private final PostService postService;
    private final Faker faker = new Faker();

    public SampleDataLoader(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @Override
    public void run(String... args) throws Exception {
        List<User> users = IntStream.rangeClosed(1, 100)
                .mapToObj(i -> new User(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.random().nextInt(1,5)
                ))
                .collect(Collectors.toList());

        List<Post> posts = IntStream.rangeClosed(1, 100)
                .mapToObj(i -> new Post(
                        faker.pokemon().name(),
                        faker.pokemon().location()
                ))
                .collect(Collectors.toList());

        userService.saveListUsers(users);
        postService.saveListPosts(posts);
    }
}
