package companies;

import java.math.BigDecimal;
import java.util.Objects;

public class SAS implements Company {
    private String siretNumber;
    private String name;
    private String headOfficeAddress;
    private static final BigDecimal taxRate = TaxRate.getTaxRateWithTwoDigitsOf(0.33D);

    private SAS(Builder builder) {
        siretNumber = builder.siretNumber;
        name = builder.name;
        headOfficeAddress = builder.headOfficeAddress;
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

    public String getHeadOfficeAddress() {
        return headOfficeAddress;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public static final class Builder {
        private String siretNumber;
        private String name;
        private String headOfficeAddress;

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

        public Builder withHeadOfficeAddress(String val) {
            headOfficeAddress = val;
            return this;
        }

        public SAS build() {
            Objects.requireNonNull(this.siretNumber, "The SIRET number is mandatory");
            Objects.requireNonNull(this.name, "The name is mandatory");
            Objects.requireNonNull(this.headOfficeAddress, "The head office address is mandatory");
            return new SAS(this);
        }
    }
}
