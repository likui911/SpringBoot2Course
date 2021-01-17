package com.example.api;

import com.example.model.Comment;
import com.example.service.CommentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/comment")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public int addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }

    @PutMapping(path = "{id}")
    public int updateComment(@PathVariable int id, @RequestBody Comment comment) {
        return commentService.updateComment(id, comment);
    }

    @DeleteMapping(path = "{id}")
    public int deleteComment(@PathVariable int id) {
        return commentService.deleteComment(id);
    }
}
