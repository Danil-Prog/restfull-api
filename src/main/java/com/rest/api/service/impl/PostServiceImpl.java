package com.rest.api.service.impl;


import com.rest.api.entity.Post;
import com.rest.api.entity.Response;
import com.rest.api.exception.BadRequestException;
import com.rest.api.repository.PostRepository;
import com.rest.api.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Page<Post> getAllPosts(Integer page, Integer pageSize, String sortBy, Sort.Direction direction) {
        Pageable paging = PageRequest.of(page, pageSize, Sort.by(direction, sortBy));
        return postRepository.findAll(paging);

    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Поста с id=%s не существует.", id)));
    }

    @Override
    public Response<String> deletePostById(Long id) {
        postRepository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Поста с id=%s не существует.", id)));

        postRepository.deleteById(id);
        return new Response<>("Пост был удален.");
    }

    @Override
    public Post createOrUpdatePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void saveListPosts(List<Post> posts) {
        postRepository.saveAll(posts);
    }
}
