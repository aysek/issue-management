package com.example.issuemanagement.api;

import com.example.issuemanagement.dto.ProjectDto;
import com.example.issuemanagement.service.imp.ProjectServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
public class ProjectController {
    /*
    Http Metodları
    Get
    Post
    Put
    Delete
     */
    private final ProjectServiceImpl projectServiceImpl;

    public ProjectController(ProjectServiceImpl projectServiceImpl){
        this.projectServiceImpl=projectServiceImpl;
    }

        @GetMapping("/{id}")
    public ResponseEntity <ProjectDto> getById(@PathVariable("id") Long id){
        ProjectDto projectDto =projectServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto);
    }

        @PostMapping
    public ResponseEntity<ProjectDto> createProject (@RequestBody ProjectDto project){
    return ResponseEntity.ok(projectServiceImpl.save(project));
    }



}
