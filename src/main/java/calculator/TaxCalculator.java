package calculator;

import companies.CompanyData;
import companies.CompanyTaxes;
import formatter.TaxFormatter;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class TaxCalculator {

    public BigDecimal calculateCompanyTax(CompanyData companyData) {
        final BigDecimal turnover = companyData.getCompanyTurnover().getValue();
        final BigDecimal companyTaxRate = companyData.getCompany().getTaxRate();
        return turnover.multiply(companyTaxRate);
    }

    public List<CompanyTaxes> getFormattedCompanyTaxesFromList(List<CompanyData> companyList) {
        return companyList.stream()
                .map(this::getFormattedCompanyTaxes)
                .collect(Collectors.toList());
    }

    private CompanyTaxes getFormattedCompanyTaxes(CompanyData data) {
        return CompanyTaxes.newBuilder()
                .withCompanySiretNumber(data.getCompany().getSiretNumber())
                .withCompanyTaxValue(TaxFormatter.format(calculateCompanyTax(data)))
                .build();
    }
}
