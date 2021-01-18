package com.example.dao;

import com.example.model.Issue;

import java.util.List;

public interface IssueDao {
    int insertIssue(Issue issue);

    Issue selectIssue(int id);

    int updateIssue(int id, Issue issue);

    int deleteIssue(int id);

    List<Issue> selectIssue(String keyword);
}
