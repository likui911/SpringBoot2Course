package com.example.service;

import com.example.dao.CommentDao;
import com.example.model.Comment;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final CommentDao commentDao;

    public CommentService(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    public int addComment(Comment comment) {
        return commentDao.insertComment(comment);
    }

    public int deleteComment(int id) {
        return commentDao.deleteComment(id);
    }

    public int updateComment(int id, Comment comment) {
        return commentDao.updateComment(id, comment);
    }

}
