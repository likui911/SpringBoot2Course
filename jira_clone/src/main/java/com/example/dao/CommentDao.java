package com.example.dao;

import com.example.model.Comment;

public interface CommentDao {

    int insertComment(Comment comment);

    int deleteComment(int id);

    int updateComment(int id, Comment comment);
}
