package com.leantech.testapi.service.impl;

import java.util.List;

import com.leantech.testapi.entity.Candidate;
import com.leantech.testapi.repository.CandidateRepository;
import com.leantech.testapi.service.ICandidateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService implements ICandidateService {
    
    @Autowired
    CandidateRepository candidateRepository;

    @Override
    public void saveCandidate(Candidate candidate){
        candidateRepository.save(candidate);
    }

    @Override
    public List<Candidate> getCandidates(){
        return (List<Candidate>) candidateRepository.findAll();
    }

    @Override
    public void deleteCandidate(String id){
        candidateRepository.deleteById(Integer.parseInt(id));
    }

}
