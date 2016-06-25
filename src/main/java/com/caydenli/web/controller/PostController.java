package com.caydenli.web.controller;

import com.caydenli.web.model.Account;
import com.caydenli.web.model.Post;
import com.caydenli.web.service.AccountsService;
import com.caydenli.web.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;
import java.sql.Timestamp;
import java.util.*;

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

        model.addAttribute("typeList", getRentType());

        model.addAttribute("post",new Post());
        return "/post/create";
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPost(@Valid Post post, BindingResult result, Principal principal){
        if (result.hasErrors()){
            return "/post/create";
        }
        post.setPostdate(new Timestamp(System.currentTimeMillis()));
        String username = principal.getName();
        Account author = accountsService.getUserByUsername(username);
        post.setUserId(author.getId());
        if(postsService.createPost(post)){
            return "redirect:/home";
        }else{
            return "/post/create";
        }
    }

    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public String readPost(Model model){
        List<Post> postList = postsService.getAllPost();
        model.addAttribute("postList", postList);
        return "/post/post";
    }

    @RequestMapping(value = "/mypost", method = RequestMethod.GET)
    public String readMyPost(Model model, Principal principal){
        List<Post> postList = postsService.getAllMyPost(principal.getName());
        model.addAttribute("postList", postList);
        return "/post/mypost";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updatePost(@PathVariable("id") String id, Model model, Principal principal){
        String username = principal.getName();
        Post post = postsService.getPostByIdandUserName(id,username);
        if (post == null){
            return "redirect:/home";
        }
        model.addAttribute("post", post);
        model.addAttribute("typeList", getRentType());
        return "/post/update";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updatePost(@Valid Post post, BindingResult result, Principal principal){
        if (result.hasErrors()){
            return "redirect:/post/update/"+post.getId();
        }
        post.setPostdate(new Timestamp(System.currentTimeMillis()));

        boolean updated = postsService.updatePost(post);
        if (updated){
            return "redirect:/post/post/"+post.getId();
        }else {
            return "redirect:/post/update/"+post.getId();
        }
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public String readPost(@PathVariable("id") String id, Model model, Principal principal){
        Post post = postsService.getPostById(id);
        if (post == null){
            return "redirect:/home";
        }
        model.addAttribute("post", post);
        model.addAttribute("newLineChar","\n");
        if (principal.getName().equals(post.getUser().getUsername())){
            model.addAttribute("isAuthor", true);
        }else {
            model.addAttribute("isAuthor", false);
        }
        return "/post/viewpost";
    }

    private List<String> getRentType(){
        return new ArrayList<String>(Arrays.asList("Looking for room", "Looking for flatmate"));
    }
}
