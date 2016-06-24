package com.caydenli.web.controller;

import com.caydenli.web.model.Account;
import com.caydenli.web.model.Post;
import com.caydenli.web.service.AccountsService;
import com.caydenli.web.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {

    PostsService postsService;
    AccountsService accountsService;

    @Autowired
    public void setPostsService(PostsService postsService) {
        this.postsService = postsService;
    }
    @Autowired
    public void setAccountsService(AccountsService accountsService){
        this.accountsService = accountsService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createPost(Model model){

        model.addAttribute("typeList", new ArrayList<String>(Arrays.asList("Looking for room", "Looking for flatmate")));

        model.addAttribute("post",new Post());
        return "/post/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPost(@Valid Post post, BindingResult result, Principal principal){
        if (result.hasErrors()){
            return "/post/create";
        }
        post.setPostdate(new Date());
        String username = principal.getName();
        Account author = accountsService.getUserByUsername(username);
        post.setUserId(author.getId());
//            post.setUserId(12);
        if(postsService.createPost(post)){
            return "redirect:/home";
        }else{
            return "/post/create";
        }


    }
}
