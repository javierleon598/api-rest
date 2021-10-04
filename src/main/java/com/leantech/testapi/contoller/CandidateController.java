package com.leantech.testapi.contoller;

import java.util.List;

import com.leantech.testapi.entity.Candidate;
import com.leantech.testapi.service.ICandidateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1")
public class CandidateController {

    @Autowired
    ICandidateService candidateService;

    @GetMapping("/candidate")
    public List<Candidate> getCandidates(){
        return candidateService.getCandidates();
    }

    @PostMapping("/candidate")
    public Candidate saveCandidates(@RequestBody Candidate candidate){
        candidateService.saveCandidate(candidate);
        return candidate;
    }
    	
	@PutMapping("/candidate")
	public Candidate modifyCandidate(@RequestBody Candidate candidate) {
		candidateService.saveCandidate(candidate);
		return candidate;
	} 
	
	@DeleteMapping("/candidate")
	public String deleteCandidate(@RequestParam("id") String id) {
		candidateService.deleteCandidate(id);
		return "Candidate Deleted";
	}
    
}
