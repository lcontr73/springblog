package com.example.codeup.springblog;

import com.example.codeup.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {
    //Dependency injection
    private PostRepository postDao;

    // Constructor
    public PostController(PostRepository postDao) {
    this.postDao = postDao;
    }
    @GetMapping( "/posts")
    public String allPosts(Model vModel) {
        List<Post> posts = postDao.findAll();
        vModel.addAttribute("posts", posts);
        return "posts/index";
    }

//    @GetMapping("/posts/{id}")
//    public String post(@PathVariable long id, Model vModel) {
//        Post post = new Post(
//                1,
//                "This is my post #" +id,
//                "Here is my post"
//        );
//        vModel.addAttribute("post", post);
//        return "posts/show";
//    }

    @GetMapping("/posts/{id}")
    public String post(@PathVariable long id, Model vModel) {
        Post post = postDao.findById(id).get();
        vModel.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping(path = "/posts/create")
    public String create() {
        return "posts/create";
    }

    @PostMapping(path = "/posts/create")

    public String savePost(@RequestParam String title, @RequestParam String body) {
        Post post = new Post(title, body);
        postDao.save(post);
        return "redirect:/posts";
    }
}
