package com.balazssipos.reddit.repositories;

import com.balazssipos.reddit.models.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends PagingAndSortingRepository<Post, Integer> {
  List<Post> findAll();
//  List<Post> findAll(Pageable pageable);
}
