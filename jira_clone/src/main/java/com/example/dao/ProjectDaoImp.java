package com.example.dao;

import com.example.model.Issue;
import com.example.model.Project;
import com.example.model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectDaoImp implements ProjectDao {
    private final JdbcTemplate jdbcTemplate;

    public ProjectDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Project selectProject() {
        String pro_sql = "select * from public.project limit 1;";
        RowMapper<Project> proMapper = new BeanPropertyRowMapper<Project>(Project.class);
        Project proj = jdbcTemplate.queryForObject(pro_sql, proMapper);
        System.out.println(proj.getId());

        String iss_sql = "select * from issue where \"projectId\"=?;";
        RowMapper<Issue> issMapper = new BeanPropertyRowMapper<Issue>(Issue.class);
        List<Issue> issues = jdbcTemplate.query(iss_sql, issMapper, proj.getId());
        proj.setIssues(issues);

        String user_sql = "select * from public.user where \"projectId\"=?;";
        RowMapper<User> userMapper = new BeanPropertyRowMapper<User>(User.class);
        List<User> users = jdbcTemplate.query(user_sql, userMapper, proj.getId());
        proj.setUsers(users);

        return proj;
    }
}
