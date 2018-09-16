package companies;

import java.math.BigDecimal;
import java.util.Objects;

public class AutoEntrepreneur implements Company {
    private String siretNumber;
    private String name;
    private static final BigDecimal taxRate = BigDecimal.valueOf(0.25D);

    public String getSiretNumber() {
        return siretNumber;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private String siretNumber;
        private String name;

        private Builder() {
        }

        public Builder withSiretNumber(String siretNumber) {
            this.siretNumber = siretNumber;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public AutoEntrepreneur build() {
            Objects.requireNonNull(this.siretNumber, "The SIRET number is mandatory");
            Objects.requireNonNull(this.name, "The name is mandatory");
            AutoEntrepreneur autoEntrepreneur = new AutoEntrepreneur();
            autoEntrepreneur.siretNumber = this.siretNumber;
            autoEntrepreneur.name = this.name;
            return autoEntrepreneur;
        }
    }
}
