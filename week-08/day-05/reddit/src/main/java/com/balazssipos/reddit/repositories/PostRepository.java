package com.balazssipos.reddit.repositories;

import com.balazssipos.reddit.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {
  List<Post> findAll();
//  Post findById();
}
