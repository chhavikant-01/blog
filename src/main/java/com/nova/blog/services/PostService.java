package com.nova.blog.services;

import com.nova.blog.domain.entities.Post;

import java.util.List;
import java.util.UUID;

public interface PostService {
    List<Post> getAllPosts(UUID categoryId, UUID tagId);
}
