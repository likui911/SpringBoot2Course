package com.example.service;

import com.example.dao.IssueDao;
import com.example.model.Issue;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueService {
    private final IssueDao issueDao;

    public IssueService(IssueDao issueDao) {
        this.issueDao = issueDao;
    }

    public int addIssue(Issue issue) {
        return issueDao.insertIssue(issue);
    }

    public int deleteIssue(int id) {
        return issueDao.deleteIssue(id);
    }

    public List<Issue> searchIssue(String search) {
        return issueDao.selectIssue(search);
    }

    public int updateIssue(int id, Issue issue) {
        return issueDao.updateIssue(id, issue);
    }

    public Issue getIssue(int id) {
        return issueDao.selectIssue(id);
    }
}
