package com.asmeydan.relation.repository;

import com.asmeydan.relation.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    default List<Post> findByPersonId(int personId) {
        return null;
    }
}
