package com.asmeydan.relation.service;

import com.asmeydan.relation.model.Person;
import com.asmeydan.relation.model.Post;
import com.asmeydan.relation.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostService implements IPostService{

    PostRepository postRepository;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(int id) {
        return postRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Post bulunamadi")
        );
    }

    @Override
    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(int id, Post post) {
        Post existingPost = postRepository.findById(id).orElseThrow(()-> new RuntimeException("Post bulunamadi"));
        existingPost.setContent(post.getContent());
        return postRepository.save(existingPost);
    }

    @Override
    public Void deletePost(int id) {
        postRepository.deleteById(id);
        return null;
    }
}
