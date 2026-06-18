package com.wellsfargo.portfolio.service;

import com.wellsfargo.portfolio.dto.FinancialAdvisorDto;
import com.wellsfargo.portfolio.entity.FinancialAdvisor;
import com.wellsfargo.portfolio.exception.ResourceNotFoundException;
import com.wellsfargo.portfolio.repository.FinancialAdvisorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FinancialAdvisorService {

    private final FinancialAdvisorRepository advisorRepository;

    public FinancialAdvisorDto createAdvisor(FinancialAdvisorDto advisorDto) {
        FinancialAdvisor advisor = mapToEntity(advisorDto);
        FinancialAdvisor savedAdvisor = advisorRepository.save(advisor);
        return mapToDto(savedAdvisor);
    }

    public FinancialAdvisorDto getAdvisorById(Long id) {
        FinancialAdvisor advisor = advisorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Financial Advisor not found with id: " + id));
        return mapToDto(advisor);
    }

    public List<FinancialAdvisorDto> getAllAdvisors() {
        return advisorRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private FinancialAdvisor mapToEntity(FinancialAdvisorDto dto) {
        FinancialAdvisor advisor = new FinancialAdvisor();
        advisor.setFirstName(dto.getFirstName());
        advisor.setLastName(dto.getLastName());
        advisor.setEmail(dto.getEmail());
        advisor.setPhone(dto.getPhone());
        return advisor;
    }

    private FinancialAdvisorDto mapToDto(FinancialAdvisor advisor) {
        FinancialAdvisorDto dto = new FinancialAdvisorDto();
        dto.setAdvisorId(advisor.getAdvisorId());
        dto.setFirstName(advisor.getFirstName());
        dto.setLastName(advisor.getLastName());
        dto.setEmail(advisor.getEmail());
        dto.setPhone(advisor.getPhone());
        return dto;
    }
}
