package com.asmeydan.relation.service;

import com.asmeydan.relation.model.Person;
import com.asmeydan.relation.model.Post;

import java.util.List;

public interface IPostService {

    public List<Post> findAll();

    public Post findById(int id);

    public Post addPost(Post post);

    public Post updatePost(int id, Post post);

    public Void deletePost(int id);
}
