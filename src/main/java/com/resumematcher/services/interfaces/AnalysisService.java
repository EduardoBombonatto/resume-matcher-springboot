package com.resumematcher.services.interfaces;

import com.resumematcher.dtos.requests.AnalysisRequestDTO;
import com.resumematcher.dtos.responses.AnalysisResponseDTO;

public interface AnalysisService {
    AnalysisResponseDTO analyse(AnalysisRequestDTO analysisRequestDTO);
}
