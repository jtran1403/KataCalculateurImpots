package companies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.math.BigDecimal;
import java.util.Objects;

@JsonDeserialize(builder = AutoEntrepreneur.Builder.class)
public class AutoEntrepreneur implements Company {
    private String siretNumber;
    private String name;
    private static final BigDecimal taxRate = TaxRate.getTaxRateWithTwoDigitsOf(0.25D);
    private static final CompanyType type = CompanyType.AUTOENTREPRENEUR;

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

    public static CompanyType getType() {
        return type;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutoEntrepreneur that = (AutoEntrepreneur) o;
        return Objects.equals(siretNumber, that.siretNumber) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(siretNumber, name);
    }

    @Override
    public String toString() {
        return "AutoEntrepreneur{" +
                "siretNumber='" + siretNumber + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
