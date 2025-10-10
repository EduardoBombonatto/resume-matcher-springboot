package com.resumematcher.services.interfaces;

import com.resumematcher.dtos.requests.AnalysisRequestDTO;
import com.resumematcher.dtos.responses.AnalysisResponseDTO;

import java.util.List;

public interface AnalysisService {
    AnalysisResponseDTO analyse(Long id, AnalysisRequestDTO analysisRequestDTO);
    List<AnalysisResponseDTO> getAllAnalysis();
}
