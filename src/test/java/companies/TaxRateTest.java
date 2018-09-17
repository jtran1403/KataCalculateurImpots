package companies;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.assertj.core.api.Assertions.assertThat;

public class TaxRateTest {

    @Test
    public void should_return_tax_rate_with_two_digits() {
        //Given
        final BigDecimal expectedTaxRate = new BigDecimal(0.25D).setScale(2, RoundingMode.HALF_UP);

        //When
        final BigDecimal taxRate = TaxRate.getTaxRateWithTwoDigitsOf(0.25D);

        //Then
        assertThat(taxRate).isEqualTo(expectedTaxRate);
    }
}