package com.nhnacademy.gateway.service;

import com.nhnacademy.gateway.domain.dto.project.request.ProjectCreateRequestDTO;
import com.nhnacademy.gateway.domain.dto.project.response.ProjectResponseDTO;
import java.util.List;

public interface ProjectService {

    ProjectResponseDTO createProject(ProjectCreateRequestDTO requestDTO);
    List<ProjectResponseDTO> readAllProjects();

    ProjectResponseDTO readProject(Long projectNum);
}
