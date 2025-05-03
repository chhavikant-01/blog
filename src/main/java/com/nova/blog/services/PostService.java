package com.nova.blog.services;

import com.nova.blog.domain.CreatePostRequest;
import com.nova.blog.domain.UpdatePostRequest;
import com.nova.blog.domain.entities.Post;
import com.nova.blog.domain.entities.User;

import java.util.List;
import java.util.UUID;

public interface PostService {
    Post getPost(UUID id);
    List<Post> getAllPosts(UUID categoryId, UUID tagId);
    List<Post> getDraftPosts(User user);
    Post createPost(User user, CreatePostRequest createPostRequest);
    Post updatePost(UUID id, UpdatePostRequest updatePostRequest);
    void deletePost(UUID id);
    
}
