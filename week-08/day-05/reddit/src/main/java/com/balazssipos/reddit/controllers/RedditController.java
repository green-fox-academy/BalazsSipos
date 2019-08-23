package com.balazssipos.reddit.controllers;

import com.balazssipos.reddit.models.Post;
import com.balazssipos.reddit.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RedditController {
  @Qualifier("postRepository")
  @Autowired
  private PostRepository postRepository;

  @GetMapping("/")
  public String listPosts(Model model) {
    model.addAttribute("posts", this.postRepository.findAll());
    return "list-post";
  }

  @GetMapping("/submit")
  public String renderAddNewPost(Model model) {
    model.addAttribute("post", new Post());
    return "add-new-post";
  }

  @PostMapping("/submit")
  public String addNewPost(@ModelAttribute Post post) {
    System.out.println(post.toString());
    this.postRepository.save(post);
    return "redirect:/";
  }

  @GetMapping("/post")
  public String renderPost(Model model, @RequestParam("postid") String postId) {
    System.out.println("objectem: " + this.postRepository.findById(Integer.parseInt(postId)).toString());
    model.addAttribute("post", this.postRepository.findById(Integer.parseInt(postId)).get());
    return "show-post";
  }
}
