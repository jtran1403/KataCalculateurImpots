package calculator;

import companies.AutoEntrepreneur;
import companies.Turnover;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxCalculator {

    public BigDecimal calculateTaxes(AutoEntrepreneur autoEntrepreneur, Turnover companyTurnover) {
        final BigDecimal turnover = companyTurnover.getValue();
        final BigDecimal companyTaxRate = autoEntrepreneur.getTaxRate();
        final BigDecimal taxValue = turnover.multiply(companyTaxRate);
        return taxValue.setScale(2, RoundingMode.CEILING);
    }
}
