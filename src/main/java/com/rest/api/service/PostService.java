package com.rest.api.service;

import com.rest.api.entity.Post;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.awt.print.Pageable;
import java.util.List;

public interface PostService {

    List<Post> getAllPosts(Integer pageNo, Integer pageSize, String sortBy);

    Post getPostById(Long id);

    String deletePostById(Long id);

    Post createOrUpdatePost(Post post);
}
