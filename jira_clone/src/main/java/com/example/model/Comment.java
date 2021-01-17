package com.example.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class Comment {
    @NotNull
    private Integer id;
    @NotBlank
    private String body;
    @NotNull
    private Date createdAt;
    @NotNull
    private Date updatedAt;
    @NotNull
    private Integer userId;
    @NotNull
    private Integer issueId;

    public Comment(Integer id, String body, Date createdAt, Date updatedAt, Integer userId, Integer issueId) {
        this.id = id;
        this.body = body;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.userId = userId;
        this.issueId = issueId;
    }

    public long getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getIssueId() {
        return issueId;
    }

}
