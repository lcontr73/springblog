package com.example.codeup.springblog.controller;

import com.example.codeup.springblog.model.Post;
import com.example.codeup.springblog.model.User;
import com.example.codeup.springblog.repositories.PostRepository;
import com.example.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class PostController {
    //Dependency injection
    private PostRepository postDao;

    private UserRepository userDao;


    // Constructor
    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }


    @GetMapping("/posts")
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
    public String create(Model vModel) {
        vModel.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping(path = "/posts/create")
    public String savePost(@ModelAttribute Post post) {
        User user = userDao.findById(2L).get();
        post.setUser(user);
        postDao.save(post);
        return "redirect:/posts";
    }


    @GetMapping(path = "/posts/{id}/edit")
    public String edit(@PathVariable long id, Model vModel) {
        Post post = postDao.findById(id).get();
        vModel.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping(path = "/posts/{id}/edit")
    public String saveEdit(@ModelAttribute Post post) {
        User user = userDao.findById(2L).get();
        post.setUser(user);
        postDao.save(post);
        return "redirect:/posts";
    }


}
