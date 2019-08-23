package com.balazssipos.reddit.services;

import com.balazssipos.reddit.models.Post;
import com.balazssipos.reddit.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Qualifier("postRepository")
    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getAllPost() {
        return this.postRepository.findAll();
    }

    @Override
    public Page<Post> getAllPostOrderedbyPopularityPaginated(int pageNumber) {
        Pageable sortedByPopularity = PageRequest.of(pageNumber-1, 3, Sort.by("popularity").descending());
        Page<Post> page = this.postRepository.findAll(sortedByPopularity);

        return page;
    }

    @Override
    public Post savePost(Post post) {
        return this.postRepository.save(post);
    }

    @Override
    public Post getPostbyId(int id) {
        Optional<Post> post = this.postRepository.findById(id);
        return post.isPresent() ? post.get() : null;
//        return this.postRepository.findById();
    }

    @Override
    public void changePopularity(String postId, String direction) {
        Post post = this.getPostbyId(Integer.parseInt(postId));
        if(direction.equals("plus")) {
            post.setPopularity(post.getPopularity() + 1);
        } else if(direction.equals("minus")) {
            post.setPopularity(post.getPopularity() - 1);
        }
        this.savePost(post);
//        return post;
    }
}
