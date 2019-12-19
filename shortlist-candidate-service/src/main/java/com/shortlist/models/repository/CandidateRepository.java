package com.shortlist.models.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shortlist.models.Candidate;

public interface CandidateRepository extends MongoRepository<Candidate, String>{

	List<Candidate> findByName(String name);
}
