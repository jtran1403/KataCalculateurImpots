package companies;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class AutoEntrepreneur implements Company {
    private String siretNumber;
    private String name;
    private static final BigDecimal taxRate = new BigDecimal(0.25D).setScale(2, RoundingMode.HALF_UP);

    private AutoEntrepreneur(Builder builder) {
        siretNumber = builder.siretNumber;
        name = builder.name;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getSiretNumber() {
        return siretNumber;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public static final class Builder {
        private String siretNumber;
        private String name;

        private Builder() {
        }

        public Builder withSiretNumber(String val) {
            siretNumber = val;
            return this;
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public AutoEntrepreneur build() {
            Objects.requireNonNull(this.siretNumber, "The SIRET number is mandatory");
            Objects.requireNonNull(this.name, "The name is mandatory");
            return new AutoEntrepreneur(this);
        }
    }
}
