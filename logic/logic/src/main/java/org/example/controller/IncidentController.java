package org.example.controller;

import jakarta.validation.Valid;
import org.example.service.IncidentDetector;
import org.example.dto.IncidentRequest;
import org.example.dto.IncidentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class IncidentController {

    private final IncidentDetector incidentDetector;

    public IncidentController(IncidentDetector incidentDetector) {
        this.incidentDetector = incidentDetector;
    }

    @PostMapping("/incident/detect")
    public ResponseEntity<IncidentResponse> detectIncident(
            @Valid @RequestBody IncidentRequest request) {
        IncidentResponse response = incidentDetector.detect(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("{\"status\": \"OK\", \"service\": \"AIDRS\"}");
    }
}
