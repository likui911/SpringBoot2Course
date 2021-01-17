package com.example.service;

import com.example.dao.ProjectDao;
import com.example.model.Project;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    private final ProjectDao projectDao;

    public ProjectService(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public Project getProject() {
        return projectDao.selectProject();
    }
}
