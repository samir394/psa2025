package in.sameer.controller;


import in.sameer.entity.Post;
import in.sameer.repository.CommentRepository;
import in.sameer.repository.PostRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private PostRepository postRepository;
    private CommentRepository commentRep;

    private CommentRepository commentRepo;

    public PostController(PostRepository postRepository, CommentRepository commentRep) {
        this.postRepository = postRepository;
        this.commentRep = commentRep;
    }
    @PostMapping
    public String createPost(
            @RequestBody Post post
    ){
        postRepository.save(post);
        return null;

    }
}
