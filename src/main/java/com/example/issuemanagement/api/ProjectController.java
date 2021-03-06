package com.example.issuemanagement.api;

import com.example.issuemanagement.dto.ProjectDto;
import com.example.issuemanagement.service.imp.ProjectServiceImpl;
import com.example.issuemanagement.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
@Api(value = "Project APIs")
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
        @ApiOperation(value = "Get By Id Operation",response = ProjectDto.class)
    public ResponseEntity <ProjectDto> getById(@PathVariable(value = "id",required = true) Long id){
        ProjectDto projectDto =projectServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto);
    }

        @PostMapping
        @ApiOperation(value = "Create Operation",response = ProjectDto.class)
    public ResponseEntity<ProjectDto> createProject (@Valid @RequestBody ProjectDto project){
    return ResponseEntity.ok(projectServiceImpl.save(project));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation",response = ProjectDto.class)
    public ResponseEntity<ProjectDto> updateProject(@PathVariable(value = "id",required = true) Long id , @Valid @RequestBody ProjectDto project){
        //hem id hem dto almak gerekli

        return ResponseEntity.ok(projectServiceImpl.update(id,project));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation",response = Boolean.class)
    public ResponseEntity<Boolean>delete(@PathVariable(value = "id",required = true) Long id){

        return ResponseEntity.ok(projectServiceImpl.delete(id));

    }





}
