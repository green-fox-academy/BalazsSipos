package com.balazssipos.reddit.controllers;

import com.balazssipos.reddit.models.Post;
import com.balazssipos.reddit.repositories.PostRepository;
import com.balazssipos.reddit.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RedditController {


  @Autowired
  private PostService postService;

  @GetMapping("/")
  public String listPosts(Model model, @RequestParam(value = "page-number", required = false) String pageNumber) {
    if(pageNumber != null) {
      model.addAttribute("posts", this.postService.getAllPostOrderedbyPopularityPaginated(Integer.parseInt(pageNumber)));
    } else {
      model.addAttribute("posts", this.postService.getAllPost());
    }
    return "list-post";
  }

  @GetMapping("/submit")
  public String renderAddNewPost(Model model) {
    model.addAttribute("post", new Post());
    return "add-new-post";
  }

  @PostMapping("/submit")
  public String addNewPost(@ModelAttribute Post post) {
//    System.out.println(post.toString());
    this.postService.savePost(post);
    return "redirect:/?page-number=1";
  }

  @GetMapping("/post")
  public String renderPost(Model model, @RequestParam("postid") String postId) {
    model.addAttribute("post", this.postService.getPostbyId(Integer.parseInt(postId)));
    return "show-post";
  }

  @GetMapping("/popchange")
  public String changePopularity(@RequestParam("postid") String postId, @RequestParam("direction") String direction, @RequestParam("page-number") String pageNumber) {
    //Post post = this.postService.getPostbyId(Integer.parseInt(postId));
    this.postService.changePopularity(postId, direction);
    //this.postService.savePost(post);
    return "redirect:/?page-number=" + (Integer.parseInt(pageNumber) + 1);
  }
}
