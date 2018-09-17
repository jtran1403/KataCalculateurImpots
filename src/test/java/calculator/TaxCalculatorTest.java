package calculator;

import companies.AutoEntrepreneur;
import companies.Company;
import companies.SAS;
import companies.Turnover;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
        final Company autoEntrepreneur = AutoEntrepreneur.newBuilder()
                .withSiretNumber("ABC123")
                .withName("Start up 1").build();
        final BigDecimal turnoverValue = new BigDecimal(10000.00D);
        final Turnover autoEntrepreneurTurnover = Turnover.newBuilder()
                .withValue(turnoverValue)
                .build();
        final BigDecimal expectedAutoEntrepreneurTaxRate = new BigDecimal(0.25D).setScale(2, RoundingMode.HALF_UP);
        final BigDecimal expectedTaxValue = turnoverValue.multiply(expectedAutoEntrepreneurTaxRate);

        //When
        final BigDecimal taxValue = taxCalculator.calculateTaxes(autoEntrepreneur, autoEntrepreneurTurnover);

        //Then
        assertThat(taxValue).isEqualTo(expectedTaxValue);
    }

    @Test
    public void should_calculate_the_tax_due_by_a_sas() {
        //Given
        final Company sas = SAS.newBuilder()
                .withSiretNumber("732 829 320 00074")
                .withName("Paris SAS")
                .withHeadOfficeAddress("25 rue victor Hugo")
                .build();
        final BigDecimal turnoverValue = new BigDecimal(10000.17D);
        final Turnover sasTurnover = Turnover.newBuilder().withValue(turnoverValue).build();
        final BigDecimal expectedAutoEntrepreneurTaxRate = new BigDecimal(0.33D).setScale(2, RoundingMode.HALF_UP);
        final BigDecimal expectedTaxValue = turnoverValue.multiply(expectedAutoEntrepreneurTaxRate);

        //When
        final BigDecimal taxValue = taxCalculator.calculateTaxes(sas, sasTurnover);

        //Then
        assertThat(taxValue).isEqualTo(expectedTaxValue);
    }
}