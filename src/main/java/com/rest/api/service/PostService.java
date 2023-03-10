package com.rest.api.service;

import com.rest.api.entity.Post;
import com.rest.api.entity.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.awt.print.Pageable;
import java.util.List;

public interface PostService {

    Page<Post> getAllPosts(Integer page, Integer pageSize, String sortBy, Sort.Direction direction);

    Post getPostById(Long id);

    Response<String> deletePostById(Long id);

    Post createOrUpdatePost(Post post);

    void saveListPosts(List<Post> posts);
}
