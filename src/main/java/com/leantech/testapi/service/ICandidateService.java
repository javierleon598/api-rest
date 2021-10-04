package com.leantech.testapi.service;

import java.util.List;

import com.leantech.testapi.entity.Candidate;

public interface ICandidateService {
    
    void saveCandidate(Candidate candidate);

    List<Candidate> getCandidates();

    void deleteCandidate(String id);

}
