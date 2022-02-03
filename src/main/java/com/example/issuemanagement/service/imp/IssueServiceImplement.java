package com.example.issuemanagement.service.imp;

import com.example.issuemanagement.dto.IssueDto;
import com.example.issuemanagement.entity.Issue;
import com.example.issuemanagement.repository.IssueRepository;
import com.example.issuemanagement.service.IssueService;
import com.example.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class IssueServiceImplement implements IssueService {
    private final IssueRepository issueRepository;//final bir nesneye atamayı sadece constructorda yapabiliriz
    private final ModelMapper modelMapper;

    public IssueServiceImplement(IssueRepository issueRepository, ModelMapper modelMapper) {
        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public IssueDto save(IssueDto issue) {
        if (issue.getDate() == null)
            throw new IllegalArgumentException("Issue Date cannot be null");
        Issue issueEntity = modelMapper.map(issue, Issue.class);
        issueEntity = issueRepository.save(issueEntity);
        issue.setId(issueEntity.getId());
        return issue;
    }


    @Override
    public IssueDto getById(Long id) {
        Issue issue = issueRepository.getOne(id);
        return modelMapper.map(issue, IssueDto.class);
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {
        Page<Issue> data = issueRepository.findAll(pageable);
        TPage<IssueDto> response = new TPage<>();
        response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), IssueDto[].class)));
        return response;
    }

    @Override
    public Boolean delete(Long issueId) {
        issueRepository.deleteById(issueId);
        return true;
    }

    @Override
    public Issue update(Long id, IssueDto project) {
        return null;
    }
}
