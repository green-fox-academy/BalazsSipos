package com.balazssipos.reddit.services;

import com.balazssipos.reddit.models.Post;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.util.List;


@Service
public interface PostService {
    List<Post> getAllPost();
    Page<Post> getAllPostOrderedbyPopularityPaginated(int pageNumber);
    Post savePost(Post post);
    Post getPostbyId(int id);
    void changePopularity(String postId, String direction);
}
