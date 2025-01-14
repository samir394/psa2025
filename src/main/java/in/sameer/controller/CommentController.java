package in.sameer.controller;


import in.sameer.entity.Comment;
import in.sameer.entity.Post;
import in.sameer.repository.CommentRepository;
import in.sameer.repository.PostRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/api/v1/comments")
public class CommentController {
    private PostRepository postRepository;
    private CommentRepository commentRepository;

    public CommentController(PostRepository postRepository, CommentRepository commentRepository){
        this.postRepository=postRepository;

        this.commentRepository=commentRepository;
    }
    @PostMapping
    public String createComment(
            @RequestBody Comment comment,
            @RequestParam long postId
            ){
       Post post = postRepository.findById(postId).get();
        comment.setPost(post);

        commentRepository.save(comment);

        return "Comment created successfully";


    }

}
