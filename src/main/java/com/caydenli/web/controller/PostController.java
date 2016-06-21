package com.caydenli.web.controller;

import com.caydenli.web.model.Post;
import com.caydenli.web.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/post")
public class PostController {

    PostsService postsService;

    @Autowired
    public void setPostsService(PostsService postsService) {
        this.postsService = postsService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String creatPost(Model model){
        model.addAttribute("post",new Post());
        return "/post/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPost(@Valid Post post, BindingResult result){
        if (result.hasErrors()){
            return "/post/create";
        }
        post.setPostdate(new Date());

        if(postsService.createPost(post)){
            return "redirect:/home";
        }else{
            return "/post/create";
        }


    }
}
