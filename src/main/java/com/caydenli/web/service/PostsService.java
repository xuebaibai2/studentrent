package com.caydenli.web.service;

import com.caydenli.web.dao.PostsDAO;
import com.caydenli.web.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("postsService")
public class PostsService {
    private PostsDAO postsDao;

    @Autowired
    public void setPostsDAO(PostsDAO postsDao) {
        this.postsDao = postsDao;
    }

    @Secured({"ROLE_admin","ROLE_user"})
    public boolean createPost(Post post) {
        return postsDao.createPost(post);
    }

    public List<Post> getAllPost() {
        return postsDao.getAllPost();
    }

    public List<Post> getAllPost(String id) {
        return postsDao.getAllPost(id);
    }

    public List<Post> getAllMyPost(String name) {
        return postsDao.getAllMyPost(name);
    }

    public Post getPostById(String id) {
        List<Post> postList = postsDao.getPostByID(id);
        return postList.size() != 0 ? postList.get(0): null;
    }

    public Post getPostByIdandUserName(String id, String username) {
        List<Post> postList = postsDao.getPostByIdandUserName(id, username);
        return postList.size() != 0 ? postList.get(0): null;
    }

    public boolean updatePost(Post post) {
        return postsDao.updatePost(post);
    }
}
