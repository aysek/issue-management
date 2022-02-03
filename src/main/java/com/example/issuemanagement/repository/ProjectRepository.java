package com.example.issuemanagement.repository;

import com.example.issuemanagement.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ProjectRepository extends JpaRepository <Project,Long> {

    Project getAllByProjectCode(String projectCode);//parametre verdiğim proje kodu ile git bana o kayıtları getir
    Project getByProjectCodeAndIdNot(String projectCode , Long id);
    List<Project> getByProjectCodeContains(String projectCode);//projectCode u içeren
    Page<Project> findAll (Pageable pageable);//sayfalama yapabilmek için

    List<Project> findAll (Sort sort);


}
