package com.resumematcher.services.implementation;

import com.resumematcher.dtos.requests.AnalysisRequestDTO;
import com.resumematcher.dtos.responses.AnalysisResponseDTO;
import com.resumematcher.exceptions.UserNotFoundException;
import com.resumematcher.models.Analysis;
import com.resumematcher.models.User;
import com.resumematcher.repositories.AnalysisRepository;
import com.resumematcher.repositories.UserRepository;
import com.resumematcher.services.interfaces.AnalysisService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AnalysisServiceImpl implements AnalysisService {
    private final RestTemplate restTemplate;
    private final AnalysisRepository analysisRepository;
    private final UserRepository userRepository;

    @Value("${api.analise.url}")
    private String apiUrl;

    public AnalysisServiceImpl(AnalysisRepository analiseRepository, UserRepository userRepository) {
        this.analysisRepository = analiseRepository;
        this.restTemplate = new RestTemplate();
        this.userRepository = userRepository;
    }

    @Override
    public AnalysisResponseDTO analyse(Long id, AnalysisRequestDTO analysisRequestDTO){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException();
        }
        User user = userRepository.findById(id).get();

        AnalysisResponseDTO responseFromApi = restTemplate.postForObject(apiUrl, analysisRequestDTO, AnalysisResponseDTO.class);

        Analysis analise = new Analysis();
        analise.setMatchPercentage(responseFromApi.matchPercentage());
        analise.setJobKeywords(responseFromApi.jobKeywords());
        analise.setResumeKeywords(responseFromApi.resumeKeywords());
        analise.setMissingKeywords(responseFromApi.missingKeywords());
        analise.setUser(user);

        analysisRepository.save(analise);
        return responseFromApi;
    }

}
