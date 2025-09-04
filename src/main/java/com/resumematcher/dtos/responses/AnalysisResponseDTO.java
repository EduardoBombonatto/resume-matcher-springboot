package com.resumematcher.dtos.responses;

public record AnalysisResponseDTO(Double matchPercentage, String jobKeywords, String resumeKeywords, String missingKeywords) {
}
