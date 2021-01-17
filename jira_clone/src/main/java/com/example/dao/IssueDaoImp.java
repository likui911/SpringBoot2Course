package com.example.dao;

import com.example.model.Issue;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IssueDaoImp implements IssueDao {
    private final JdbcTemplate jdbcTemplate;

    public IssueDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertIssue(Issue issue) {
        return 0;
    }

    @Override
    public Issue selectIssue(int id) {
        return null;
    }

    @Override
    public int updateIssue(int id, Issue issue) {
        return 0;
    }

    @Override
    public int deleteIssue(int id) {
        return 0;
    }

    @Override
    public List<Issue> selectIssue(String keyword) {
        return null;
    }
}
