package com.example.dao;

import com.example.model.Issue;

import java.util.List;

public interface IssueDao {
    public int insertIssue(Issue issue);

    public Issue selectIssue(int id);

    public int updateIssue(int id, Issue issue);

    public int deleteIssue(int id);

    public List<Issue> selectIssue(String keyword);
}
