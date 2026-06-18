package com.wellsfargo.portfolio.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "investments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Investment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long investmentId;

    @Column(nullable = false)
    private String investmentName;

    @Column(nullable = false)
    private String investmentType;

    @Column(nullable = false, unique = true)
    private String tickerSymbol;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal currentPrice;

    @OneToMany(mappedBy = "investment", cascade = CascadeType.ALL)
    private List<PortfolioInvestment> portfolioInvestments;

    @OneToMany(mappedBy = "investment", cascade = CascadeType.ALL)
    private List<Transaction> transactions;
}
