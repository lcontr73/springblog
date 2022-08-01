package com.example.codeup.springblog;

import com.example.codeup.springblog.model.User;
import com.example.codeup.springblog.repositories.PostRepository;
import com.example.codeup.springblog.repositories.UserRepository;
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
    public String create() {
        return "posts/create";
    }

//    @PostMapping(path = "/posts/create")
//
//    public String savePost(@RequestParam String title, @RequestParam String body) {
//        Post post = new Post(title, body);
//        postDao.save(post);
//        return "redirect:/posts";
//    }

    @PostMapping(path = "/posts/create")
    public String savePost(@RequestParam String title, @RequestParam String body) {
        User user = userDao.findById(2L).get();
        Post post = new Post(title, body);
        post.setUser(user); // if you don't have a constructor that also takes in the associated user
        postDao.save(post);
        return "redirect:/posts";
    }
}
