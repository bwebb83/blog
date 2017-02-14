//package com.codeup.services;
//
//import com.codeup.models.Post;
//import com.codeup.repositories.Posts;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
//
///**
// * Created by Brian on 2/9/17.
// */
//@Service("postSvc")
//public class PostSvc {
//
//    @Autowired
//    Posts Post;
//
//    private List<Post> posts = new ArrayList<>();
//
//    public PostSvc(){
//        createPosts();
//
//    }
//
//    public Post findOnePost(int id){
//        return posts.get(id-1);
//    }
//
//    public List<Post> findAllPosts(){
//        return posts;
//    }
//
//    public Post save(Post post){
//        post.setId((long)posts.size()+1);
//        posts.add(post);
//        return post;
//    }
//
//    private void createPosts(){
//        for(int i = 0; i<50; i++){
//            save(new Post("title" + (i+1), "Body" + (i+2)));
//        }
//    }
//}
