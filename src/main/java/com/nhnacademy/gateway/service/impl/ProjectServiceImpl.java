package com.nhnacademy.gateway.service.impl;

import com.nhnacademy.gateway.adapter.ProjectAdapter;
import com.nhnacademy.gateway.domain.dto.project.request.ProjectCreateRequestDTO;
import com.nhnacademy.gateway.domain.dto.project.response.ProjectResponseDTO;
import com.nhnacademy.gateway.service.ProjectService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectAdapter projectAdapter;

    @Transactional
    @Override
    public ProjectResponseDTO createProject(ProjectCreateRequestDTO requestDTO) {
        return projectAdapter.createProject(requestDTO);
    }

    @Override
    public List<ProjectResponseDTO> readAllProjects() {
        return projectAdapter.readAllProjects();
    }

    @Override
    public ProjectResponseDTO readProject(Long projectNum) {
        return projectAdapter.readProject(projectNum);
    }
}
