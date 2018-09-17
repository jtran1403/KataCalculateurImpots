package companies;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class SAS implements Company {
    private String siretNumber;
    private String name;
    private String headOfficeAddress;
    //TODO: Implement Rate class
    private static final BigDecimal taxRate = new BigDecimal(0.33D).setScale(2, RoundingMode.HALF_UP);

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

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private String siretNumber;
        private String name;
        private String headOfficeAddress;

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

        public Builder withHeadOfficeAddress(String headOfficeAddress) {
            this.headOfficeAddress = headOfficeAddress;
            return this;
        }

        public SAS build() {
            Objects.requireNonNull(this.siretNumber, "The SIRET number is mandatory");
            Objects.requireNonNull(this.name, "The name is mandatory");
            Objects.requireNonNull(this.headOfficeAddress, "The head office address is mandatory");
            SAS sAS = new SAS();
            sAS.name = this.name;
            sAS.siretNumber = this.siretNumber;
            sAS.headOfficeAddress = this.headOfficeAddress;
            return sAS;
        }
    }
}
