package com.resumematcher.controllers;

import com.resumematcher.dtos.requests.AnalysisRequestDTO;
import com.resumematcher.dtos.responses.AnalysisResponseDTO;
import com.resumematcher.services.interfaces.AnalysisService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/analysis")
public class AnalysisController {
    private final AnalysisService analysisService;

    public AnalysisController(AnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    @PostMapping(value = "/{userId}")
    public ResponseEntity<AnalysisResponseDTO> analyzeUser(@PathVariable Long userId, @RequestBody AnalysisRequestDTO request) {
        AnalysisResponseDTO response = analysisService.analyse(userId, request);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @GetMapping
    public ResponseEntity<List<AnalysisResponseDTO>> getAllAnalysis(){
        List<AnalysisResponseDTO> response = analysisService.getAllAnalysis();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
