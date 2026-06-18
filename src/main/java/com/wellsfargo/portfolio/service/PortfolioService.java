package com.wellsfargo.portfolio.service;

import com.wellsfargo.portfolio.dto.PortfolioDto;
import com.wellsfargo.portfolio.entity.Customer;
import com.wellsfargo.portfolio.entity.FinancialAdvisor;
import com.wellsfargo.portfolio.entity.Portfolio;
import com.wellsfargo.portfolio.exception.ResourceNotFoundException;
import com.wellsfargo.portfolio.repository.CustomerRepository;
import com.wellsfargo.portfolio.repository.FinancialAdvisorRepository;
import com.wellsfargo.portfolio.repository.PortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;
    private final CustomerRepository customerRepository;
    private final FinancialAdvisorRepository advisorRepository;

    public PortfolioDto createPortfolio(PortfolioDto portfolioDto) {
        Customer customer = customerRepository.findById(portfolioDto.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + portfolioDto.getCustomerId()));

        FinancialAdvisor advisor = advisorRepository.findById(portfolioDto.getAdvisorId())
                .orElseThrow(() -> new ResourceNotFoundException("Financial Advisor not found with id: " + portfolioDto.getAdvisorId()));

        Portfolio portfolio = new Portfolio();
        portfolio.setPortfolioName(portfolioDto.getPortfolioName());
        portfolio.setCreationDate(portfolioDto.getCreationDate());
        portfolio.setTotalValue(portfolioDto.getTotalValue());
        portfolio.setCustomer(customer);
        portfolio.setFinancialAdvisor(advisor);

        Portfolio savedPortfolio = portfolioRepository.save(portfolio);
        return mapToDto(savedPortfolio);
    }

    public PortfolioDto getPortfolioById(Long id) {
        Portfolio portfolio = portfolioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found with id: " + id));
        return mapToDto(portfolio);
    }

    public List<PortfolioDto> getAllPortfolios() {
        return portfolioRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private PortfolioDto mapToDto(Portfolio portfolio) {
        PortfolioDto dto = new PortfolioDto();
        dto.setPortfolioId(portfolio.getPortfolioId());
        dto.setPortfolioName(portfolio.getPortfolioName());
        dto.setCreationDate(portfolio.getCreationDate());
        dto.setTotalValue(portfolio.getTotalValue());
        dto.setCustomerId(portfolio.getCustomer().getCustomerId());
        dto.setAdvisorId(portfolio.getFinancialAdvisor().getAdvisorId());
        return dto;
    }
}
