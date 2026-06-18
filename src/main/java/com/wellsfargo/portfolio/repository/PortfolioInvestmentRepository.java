package com.wellsfargo.portfolio.repository;

import com.wellsfargo.portfolio.entity.PortfolioInvestment;
import com.wellsfargo.portfolio.entity.PortfolioInvestmentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioInvestmentRepository extends JpaRepository<PortfolioInvestment, PortfolioInvestmentId> {
}
