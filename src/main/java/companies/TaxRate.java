package companies;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class TaxRate {

    public static BigDecimal getTaxRateWithTwoDigitsOf(double rate) {
        return new BigDecimal(rate).setScale(2, RoundingMode.HALF_UP);
    }
}
