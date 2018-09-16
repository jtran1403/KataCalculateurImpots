package calculator;

import companies.AutoEntrepreneur;
import companies.Turnover;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.assertj.core.api.Assertions.assertThat;

public class TaxCalculatorTest {

    @Test
    public void should_calculate_the_tax_due_by_an_autoentrepreneur() {
        //Given
        TaxCalculator taxCalculator = new TaxCalculator();
        final AutoEntrepreneur autoEntrepreneur = AutoEntrepreneur.newBuilder().withSiretNumber("ABC123").withName("Start up 1").build();

        //When
        final BigDecimal taxValue = taxCalculator.calculateTaxes(autoEntrepreneur, Turnover.newBuilder().withValue(new BigDecimal(10000.00D)).build());

        //Then
        final BigDecimal expectedTaxValue = new BigDecimal(2500.00D).setScale(2, RoundingMode.CEILING);
        assertThat(taxValue).isEqualTo(expectedTaxValue);
    }
}