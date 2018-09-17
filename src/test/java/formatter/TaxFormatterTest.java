package formatter;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.assertj.core.api.Assertions.assertThat;

public class TaxFormatterTest {

    @Test
    public void should_present_the_tax_value_with_two_digits_in_decimals() {
        // Given
        final BigDecimal companyTaxValue = new BigDecimal(3516.6674124D);
        final BigDecimal expectedFormattedCompanyTaxValue =
                new BigDecimal(3516.6674124D).setScale(2, RoundingMode.HALF_UP);

        //When
        final BigDecimal formattedCompanyTaxValue = TaxFormatter.format(companyTaxValue);

        //Then
        assertThat(formattedCompanyTaxValue).isEqualTo(expectedFormattedCompanyTaxValue);
    }
}