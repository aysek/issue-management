package com.example.issuemanagement.api;


import com.example.issuemanagement.dto.IssueDto;
import com.example.issuemanagement.entity.Issue;
import com.example.issuemanagement.service.imp.IssueServiceImplement;
import com.example.issuemanagement.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
public class IssueController {

        /*
        Http Metodları
        Get
        Post
        Put
        Delete
         */
        private final IssueServiceImplement issueServiceImplement;
        public IssueController(IssueServiceImplement issueServiceImplement){
            this.issueServiceImplement=issueServiceImplement;
        }

        @GetMapping("/{id}")
        public ResponseEntity<IssueDto> getById(@PathVariable(value = "id",required = true) Long id){
            IssueDto projectDto =issueServiceImplement.getById(id);
            return ResponseEntity.ok(projectDto);
        }

        @PostMapping
        public ResponseEntity<IssueDto> createProject (@Valid @RequestBody IssueDto issueDto){
            return ResponseEntity.ok(issueServiceImplement.save(issueDto));
        }

        @PutMapping("/{id}")
        public ResponseEntity<Issue> updateProject(@PathVariable(value = "id",required = true) Long id , @Valid @RequestBody IssueDto issueDto){
            //hem id hem dto almak gerekli
            return ResponseEntity.ok(issueServiceImplement.update(id,issueDto));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Boolean>delete(@PathVariable(value = "id",required = true) Long id){
            return ResponseEntity.ok(issueServiceImplement.delete(id));
        }

}
