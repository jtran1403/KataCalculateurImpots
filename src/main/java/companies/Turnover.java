package companies;

import java.math.BigDecimal;
import java.util.Objects;

public class Turnover {
    private BigDecimal value;
    private static final String currency = "EURO(S)";

    public BigDecimal getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private BigDecimal value;

        private Builder() {
        }

        public Builder withValue(BigDecimal value) {
            this.value = value;
            return this;
        }

        public Turnover build() {
            Objects.requireNonNull(this.value, "The value is mandatory");
            Turnover turnover = new Turnover();
            turnover.value = this.value;
            return turnover;
        }
    }
}
