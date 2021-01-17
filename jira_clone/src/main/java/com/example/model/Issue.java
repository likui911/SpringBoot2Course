package com.example.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class Issue {
    @NotNull
    private Integer id;
    @NotBlank
    private String title;
    @NotBlank
    private String type;
    @NotNull
    private String status;
    @NotBlank
    private String priority;
    @NotNull
    private double listPosition;
    private String description;
    private String descriptionText;
    private Integer estimate;
    private Integer timeSpent;
    private Integer timeRemaining;
    private Date createdAt;
    private Date updatedAt;
    @NotNull
    private Integer reporterId;
    private Integer projectId;
    private List<User> users;
    private List<Integer> userIds;
    private List<Comment> comments;

    public Issue(@NotNull Integer id, @NotBlank String title, @NotBlank String type, @NotNull String status, @NotBlank String priority, @NotNull double listPosition, String description, String descriptionText, Integer estimate, Integer timeSpent, Integer timeRemaining, Date createdAt, Date updatedAt, @NotNull Integer reporterId, Integer projectId) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.status = status;
        this.priority = priority;
        this.listPosition = listPosition;
        this.description = description;
        this.descriptionText = descriptionText;
        this.estimate = estimate;
        this.timeSpent = timeSpent;
        this.timeRemaining = timeRemaining;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.reporterId = reporterId;
        this.projectId = projectId;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Integer> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Double getListPosition() {
        return listPosition;
    }

    public void setListPosition(Double listPosition) {
        this.listPosition = listPosition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionText() {
        return descriptionText;
    }

    public void setDescriptionText(String descriptionText) {
        this.descriptionText = descriptionText;
    }

    public Integer getEstimate() {
        return estimate;
    }

    public void setEstimate(Integer estimate) {
        this.estimate = estimate;
    }

    public Integer getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(Integer timeSpent) {
        this.timeSpent = timeSpent;
    }

    public Integer getTimeRemaining() {
        return timeRemaining;
    }

    public void setTimeRemaining(Integer timeRemaining) {
        this.timeRemaining = timeRemaining;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getReporterId() {
        return reporterId;
    }

    public void setReporterId(Integer reporterId) {
        this.reporterId = reporterId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
}
