package calculator;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import companies.*;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TaxCalculatorTest {

    private TaxCalculator taxCalculator;

    @Before
    public void setUp() throws Exception {
        taxCalculator = new TaxCalculator();
    }

    @Test
    public void should_calculate_the_tax_due_by_an_auto_entrepreneur() {
        //Given
        final BigDecimal turnoverValue = new BigDecimal(10000.00D);
        final CompanyData companyData = CompanyData.newBuilder()
                .withCompany(AutoEntrepreneur.newBuilder()
                        .withSiretNumber("ABC123")
                        .withName("Start up 1")
                        .build())
                .withCompanyTurnover(Turnover.newBuilder()
                        .withValue(turnoverValue)
                        .build())
                .build();
        final BigDecimal expectedAutoEntrepreneurTaxRate = new BigDecimal(0.25D).setScale(2, RoundingMode.HALF_UP);
        final BigDecimal expectedTaxValue = turnoverValue.multiply(expectedAutoEntrepreneurTaxRate);

        //When
        final BigDecimal taxValue = taxCalculator.calculateCompanyTax(companyData);

        //Then
        assertThat(taxValue).isEqualTo(expectedTaxValue);
    }

    @Test
    public void should_calculate_the_tax_due_by_a_sas() {
        //Given
        final BigDecimal turnoverValue = new BigDecimal(10000.17D);
        final CompanyData companyData = CompanyData.newBuilder()
                .withCompany(SAS.newBuilder()
                        .withSiretNumber("732 829 320 00074")
                        .withName("Paris SAS")
                        .withHeadOfficeAddress("25 rue victor Hugo")
                        .build())
                .withCompanyTurnover(Turnover.newBuilder()
                        .withValue(turnoverValue)
                        .build())
                .build();
        final BigDecimal expectedAutoEntrepreneurTaxRate = new BigDecimal(0.33D).setScale(2, RoundingMode.HALF_UP);
        final BigDecimal expectedTaxValue = turnoverValue.multiply(expectedAutoEntrepreneurTaxRate);

        //When
        final BigDecimal taxValue = taxCalculator.calculateCompanyTax(companyData);

        //Then
        assertThat(taxValue).isEqualTo(expectedTaxValue);
    }

    @Test
    public void should_get_company_taxes_of_all_companies_in_the_list() throws IOException {
        //Given
        final String companyListAsJson = IOUtils.toString(getClass().getResourceAsStream("/company-list.json"));
        final ObjectMapper objectMapper = new ObjectMapper();
        final List<CompanyData> companyList = objectMapper.readValue(companyListAsJson, new TypeReference<List<CompanyData>>() {});

        //When
        final List<CompanyTaxes> taxes = taxCalculator.getFormattedCompanyTaxesFromList(companyList);

        //Then
        assertThat(taxes).containsExactly(
                CompanyTaxes.newBuilder()
                        .withCompanySiretNumber("RCS PARIS 453 983 245")
                        .withCompanyTaxValue(new BigDecimal("3300000.00").setScale(2, RoundingMode.CEILING))
                        .build(),
                CompanyTaxes.newBuilder()
                        .withCompanySiretNumber("RC NANTES 234 987 456")
                        .withCompanyTaxValue(new BigDecimal("1650000.00").setScale(2, RoundingMode.CEILING))
                        .build(),
                CompanyTaxes.newBuilder()
                        .withCompanySiretNumber("732 829 320 00074")
                        .withCompanyTaxValue(new BigDecimal("5625.13").setScale(2, RoundingMode.CEILING))
                        .build()
        );
    }
}