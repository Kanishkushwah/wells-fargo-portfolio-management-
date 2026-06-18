package com.wellsfargo.portfolio.entity.nonlombok;

import jakarta.persistence.*;
import java.util.List;
import com.wellsfargo.portfolio.entity.Portfolio;

/**
 * Example of an entity WITHOUT Lombok, as requested by requirements.
 * This class includes standard getters, setters, and constructors.
 */
@Entity
@Table(name = "financial_advisors_non_lombok")
public class FinancialAdvisorNonLombok {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long advisorId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phone;

    @OneToMany(mappedBy = "financialAdvisor", cascade = CascadeType.ALL)
    private List<Portfolio> portfolios;

    public FinancialAdvisorNonLombok() {
    }

    public FinancialAdvisorNonLombok(Long advisorId, String firstName, String lastName, String email, String phone, List<Portfolio> portfolios) {
        this.advisorId = advisorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.portfolios = portfolios;
    }

    public Long getAdvisorId() {
        return advisorId;
    }

    public void setAdvisorId(Long advisorId) {
        this.advisorId = advisorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Portfolio> getPortfolios() {
        return portfolios;
    }

    public void setPortfolios(List<Portfolio> portfolios) {
        this.portfolios = portfolios;
    }
}
