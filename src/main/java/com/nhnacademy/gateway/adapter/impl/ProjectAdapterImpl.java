package com.nhnacademy.gateway.adapter.impl;

import com.nhnacademy.gateway.adapter.ProjectAdapter;
import com.nhnacademy.gateway.domain.dto.project.request.ProjectCreateRequestDTO;
import com.nhnacademy.gateway.domain.dto.project.response.ProjectResponseDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@RequiredArgsConstructor
@Component
public class ProjectAdapterImpl implements ProjectAdapter {

    private static final String BASE_URL = "http://localhost:8000";
    private final RestTemplate restTemplate;

    @Override
    public ProjectResponseDTO createProject(ProjectCreateRequestDTO requestDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<ProjectCreateRequestDTO> httpEntity = new HttpEntity<>(requestDTO, headers);
        ResponseEntity<ProjectResponseDTO>
            response = restTemplate.exchange(BASE_URL + "/projects",
            HttpMethod.POST,
            httpEntity,
            new ParameterizedTypeReference<ProjectResponseDTO>(){});
        return response.getBody();
    }

    @Override
    public List<ProjectResponseDTO> readAllProjects() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<List<ProjectResponseDTO>> httpEntity = new HttpEntity<>(headers);

        ResponseEntity<List<ProjectResponseDTO>> projects =restTemplate.exchange(BASE_URL + "/projects",
            HttpMethod.GET,
            httpEntity,
            new ParameterizedTypeReference<List<ProjectResponseDTO>>() {
            });

        return projects.getBody();
    }

    @Override
    public ProjectResponseDTO readProject(Long projectNum) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<ProjectResponseDTO> httpEntity = new HttpEntity<>(headers);

        ResponseEntity<ProjectResponseDTO> project = restTemplate.exchange(
            BASE_URL + "/projects/" + projectNum,
            HttpMethod.GET,
            httpEntity,
            new ParameterizedTypeReference<ProjectResponseDTO>() {
            });
        return project.getBody();
    }
}
