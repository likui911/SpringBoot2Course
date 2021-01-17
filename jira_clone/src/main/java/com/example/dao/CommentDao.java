package com.example.dao;

import com.example.model.Comment;

public interface CommentDao {

    public int insertComment(Comment comment);

    public int deleteComment(int id);

    public int updateComment(int id, Comment comment);
}
