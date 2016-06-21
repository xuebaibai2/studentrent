package com.caydenli.web.service;

import com.caydenli.web.dao.PostsDAO;
import com.caydenli.web.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

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
}
