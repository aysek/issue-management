package com.example.issuemanagement.api;

import com.example.issuemanagement.dto.ProjectDto;
import com.example.issuemanagement.service.imp.ProjectServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private final ProjectServiceImpl projectServiceImp;



        @GetMapping()
    public ResponseEntity <ProjectDto> getById(){


    return null;
}
}
