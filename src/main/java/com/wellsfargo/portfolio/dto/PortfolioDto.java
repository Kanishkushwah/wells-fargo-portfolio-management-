package com.wellsfargo.portfolio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PortfolioDto {

    private Long portfolioId;

    @NotBlank(message = "Portfolio name is mandatory")
    private String portfolioName;

    @NotNull(message = "Creation date is mandatory")
    private LocalDate creationDate;

    @NotNull(message = "Total value is mandatory")
    @PositiveOrZero(message = "Total value must be zero or positive")
    private BigDecimal totalValue;

    @NotNull(message = "Customer ID is mandatory")
    private Long customerId;

    @NotNull(message = "Financial Advisor ID is mandatory")
    private Long advisorId;
}
