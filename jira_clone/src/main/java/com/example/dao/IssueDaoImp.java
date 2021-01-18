package com.example.dao;

import com.example.model.Comment;
import com.example.model.Issue;
import com.example.model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class IssueDaoImp implements IssueDao {
    private final JdbcTemplate jdbcTemplate;

    public IssueDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertIssue(Issue issue) {
        String sql = "INSERT INTO public.issue(\n" +
                "\ttitle, type, status, priority, \"listPosition\", description, \"descriptionText\", estimate, \"timeSpent\", \"timeRemaining\", \"createdAt\", \"updatedAt\", \"reporterId\", \"projectId\")\n" +
                "\tVALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        return jdbcTemplate.update(sql, issue.getTitle(), issue.getType(), issue.getStatus(), issue.getPriority(), issue.getListPosition(),
                issue.getDescription(), issue.getDescriptionText(), issue.getEstimate(), issue.getTimeSpent(), issue.getTimeRemaining(),
                new Date(), new Date(), issue.getReporterId(), issue.getProjectId());
    }

    @Override
    public Issue selectIssue(int id) {
        String issueSql = "select * from public.issue where id = ?;";
        RowMapper<Issue> issueMapper = new BeanPropertyRowMapper<>(Issue.class);
        Issue issue = jdbcTemplate.queryForObject(issueSql, issueMapper, id);

        String commentSql = "select * from public.comment where \"issueId\"=?;";
        List<Comment> comments = jdbcTemplate.query(commentSql, new BeanPropertyRowMapper<Comment>(Comment.class), id);
        issue.setComments(comments);

        String userSql = "select * from public.user where id in(select \"userId\" from public.issue_users_user where \"issueId\"=?);\n";
        List<User> users = jdbcTemplate.query(userSql, new BeanPropertyRowMapper<>(User.class), id);

        issue.setUserIds(users.stream().map(user -> user.getId()).collect(Collectors.toList()));
        issue.setUsers(users);
        return issue;
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
