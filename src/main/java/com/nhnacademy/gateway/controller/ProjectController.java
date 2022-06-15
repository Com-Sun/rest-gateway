package com.nhnacademy.gateway.controller;

import com.nhnacademy.gateway.domain.dto.project.request.ProjectCreateRequestDTO;
import com.nhnacademy.gateway.domain.dto.project.response.ProjectResponseDTO;
import com.nhnacademy.gateway.service.ProjectService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping(value = "projects")
    public ModelAndView createProject(@RequestBody ProjectCreateRequestDTO requestDTO) {

        return new ModelAndView("redirect:/projects");
    }

    @GetMapping(value = "projects")
    public ModelAndView readAllProject() {

        ModelAndView mav = new ModelAndView("projects/dooray");
        List<ProjectResponseDTO> projects = projectService.readAllProjects();
        mav.addObject("projects", projects);

        return mav;
    }

//    @GetMapping(value = "projects")
}
