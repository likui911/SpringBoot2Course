package com.example.dao;

import com.example.model.Comment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class CommentDaoImp implements CommentDao {
    private final JdbcTemplate jdbcTemplate;

    public CommentDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertComment(Comment comment) {
        String sql = "INSERT INTO public.comment(body, \"createdAt\", \"updatedAt\", \"userId\", \"issueId\") " +
                "VALUES (?, ?, ?, ?, ?);";
        return jdbcTemplate.update(sql, comment.getBody(), new Date(), new Date(),
                comment.getUserId(), comment.getIssueId());
    }

    @Override
    public int deleteComment(int id) {
        String sql = "delete from comment where id = ?;";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int updateComment(int id, Comment comment) {
        String sql = "UPDATE comment SET body=?, \"updatedAt\"=? WHERE id=?;";
        return jdbcTemplate.update(sql, comment.getBody(), new Date(), id);
    }


}
