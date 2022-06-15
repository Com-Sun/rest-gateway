package com.nhnacademy.gateway.adapter;

import com.nhnacademy.gateway.domain.dto.project.request.ProjectCreateRequestDTO;
import com.nhnacademy.gateway.domain.dto.project.response.ProjectResponseDTO;
import java.util.List;

public interface ProjectAdapter {
    ProjectResponseDTO createProject(ProjectCreateRequestDTO requestDTO);
    List<ProjectResponseDTO> readAllProjects();

    ProjectResponseDTO readProject(Long projectNum);
}
