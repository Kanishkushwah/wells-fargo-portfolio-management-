package com.wellsfargo.portfolio.controller;

import com.wellsfargo.portfolio.dto.FinancialAdvisorDto;
import com.wellsfargo.portfolio.service.FinancialAdvisorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/advisors")
@RequiredArgsConstructor
public class FinancialAdvisorController {

    private final FinancialAdvisorService advisorService;

    @PostMapping
    public ResponseEntity<FinancialAdvisorDto> createAdvisor(@Valid @RequestBody FinancialAdvisorDto advisorDto) {
        FinancialAdvisorDto savedAdvisor = advisorService.createAdvisor(advisorDto);
        return new ResponseEntity<>(savedAdvisor, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FinancialAdvisorDto> getAdvisorById(@PathVariable Long id) {
        FinancialAdvisorDto advisorDto = advisorService.getAdvisorById(id);
        return ResponseEntity.ok(advisorDto);
    }

    @GetMapping
    public ResponseEntity<List<FinancialAdvisorDto>> getAllAdvisors() {
        return ResponseEntity.ok(advisorService.getAllAdvisors());
    }
}
