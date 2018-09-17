package formatter;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class TaxFormatter {

    public static BigDecimal format(BigDecimal companyTaxValue) {
        return companyTaxValue.setScale(2, RoundingMode.HALF_UP);
    }
}
