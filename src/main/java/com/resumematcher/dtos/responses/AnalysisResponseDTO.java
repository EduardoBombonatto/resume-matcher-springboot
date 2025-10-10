package com.resumematcher.dtos.responses;

import java.util.List;

public record AnalysisResponseDTO(
        Double matchPercentage,
        List<String> jobKeywords,
        List<String> resumeKeywords,
        List<String> missingKeywords
) {
}
