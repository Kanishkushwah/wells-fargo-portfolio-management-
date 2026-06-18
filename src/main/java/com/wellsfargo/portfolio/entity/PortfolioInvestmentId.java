package com.wellsfargo.portfolio.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioInvestmentId implements Serializable {

    @Column(name = "portfolio_id")
    private Long portfolioId;

    @Column(name = "investment_id")
    private Long investmentId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PortfolioInvestmentId that = (PortfolioInvestmentId) o;
        return Objects.equals(portfolioId, that.portfolioId) &&
                Objects.equals(investmentId, that.investmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(portfolioId, investmentId);
    }
}
