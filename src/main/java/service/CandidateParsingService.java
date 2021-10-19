package service;


import models.CandidateDto;

public interface CandidateParsingService {
    CandidateDto parseCandidate(String filePath);
}
