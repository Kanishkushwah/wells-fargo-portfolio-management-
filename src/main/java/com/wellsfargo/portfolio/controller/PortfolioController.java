package com.wellsfargo.portfolio.controller;

import com.wellsfargo.portfolio.dto.PortfolioDto;
import com.wellsfargo.portfolio.service.PortfolioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolios")
@RequiredArgsConstructor
public class PortfolioController {

    private final PortfolioService portfolioService;

    @PostMapping
    public ResponseEntity<PortfolioDto> createPortfolio(@Valid @RequestBody PortfolioDto portfolioDto) {
        PortfolioDto savedPortfolio = portfolioService.createPortfolio(portfolioDto);
        return new ResponseEntity<>(savedPortfolio, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PortfolioDto> getPortfolioById(@PathVariable Long id) {
        PortfolioDto portfolioDto = portfolioService.getPortfolioById(id);
        return ResponseEntity.ok(portfolioDto);
    }

    @GetMapping
    public ResponseEntity<List<PortfolioDto>> getAllPortfolios() {
        return ResponseEntity.ok(portfolioService.getAllPortfolios());
    }
}
