package com.rest.api.controller;


import com.rest.api.entity.Post;
import com.rest.api.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PostController {


    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPosts(@RequestParam(defaultValue = "0") Integer pageNo,
                                                  @RequestParam(defaultValue = "10") Integer pageSize,
                                                  @RequestParam(defaultValue = "id") String sortBy) {
        return new ResponseEntity<>(postService.getAllPosts(pageNo, pageSize, sortBy), HttpStatus.OK);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> createOrUpdatePost(@RequestBody Post post) {
        return new ResponseEntity<>(postService.createOrUpdatePost(post), HttpStatus.CREATED);
    }

    @PostMapping("/posts/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(postService.deletePostById(id), HttpStatus.OK);
    }
}
