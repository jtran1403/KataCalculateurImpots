package companies;

import java.math.BigDecimal;
import java.util.Objects;

public class Turnover {
    private BigDecimal value;

    private Turnover(Builder builder) {
        value = builder.value;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public BigDecimal getValue() {
        return value;
    }

    public static final class Builder {
        private BigDecimal value;

        private Builder() {
        }

        public Builder withValue(BigDecimal val) {
            value = val;
            return this;
        }

        public Turnover build() {
            Objects.requireNonNull(this.value, "The value is mandatory");
            return new Turnover(this);
        }
    }
}
