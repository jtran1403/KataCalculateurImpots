package calculator;

import companies.Company;
import companies.Turnover;

import java.math.BigDecimal;

public class TaxCalculator {

    public BigDecimal calculateTaxes(Company company, Turnover companyTurnover) {
        final BigDecimal turnover = companyTurnover.getValue();
        final BigDecimal companyTaxRate = company.getTaxRate();
        return turnover.multiply(companyTaxRate);
    }
}
