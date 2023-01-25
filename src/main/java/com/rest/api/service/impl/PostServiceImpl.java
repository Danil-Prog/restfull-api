package com.rest.api.service.impl;


import com.rest.api.entity.Post;
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
    public List<Post> getAllPosts(Integer pageNo, Integer pageSize, String sortBy, Sort.Direction methodSort) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(methodSort, sortBy));

        Page<Post> pageResult = postRepository.findAll(paging);
        if (pageResult.hasContent()) {
            return pageResult.getContent();
        } else
            return new ArrayList<>();
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id).orElseThrow(() ->
                new BadRequestException("Такого поста не существует."));
    }

    @Override
    public String deletePostById(Long id) {
        postRepository.deleteById(id);
        return "Пост был удален.";
    }

    @Override
    public Post createOrUpdatePost(Post post) {
        return postRepository.save(post);
    }
}
