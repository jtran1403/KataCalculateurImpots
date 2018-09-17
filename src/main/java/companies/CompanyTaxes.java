package companies;


import java.math.BigDecimal;
import java.util.Objects;

public final class CompanyTaxes {

    private final String companySiretNumber;
    private final BigDecimal companyTaxValue;

    private CompanyTaxes(Builder builder) {
        companySiretNumber = builder.companySiretNumber;
        companyTaxValue = builder.companyTaxValue;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getCompanySiretNumber() {
        return companySiretNumber;
    }

    public BigDecimal getCompanyTaxValuee() {
        return companyTaxValue;
    }

    public static final class Builder {
        private String companySiretNumber;
        private BigDecimal companyTaxValue;

        private Builder() {
        }

        public Builder withCompanySiretNumber(String val) {
            companySiretNumber = val;
            return this;
        }

        public Builder withCompanyTaxValue(BigDecimal val) {
            companyTaxValue = val;
            return this;
        }

        public CompanyTaxes build() {
            Objects.requireNonNull(this.companySiretNumber, "The company SIRET number is mandatory");
            Objects.requireNonNull(this.companyTaxValue, "The company tax value is mandatory");
            return new CompanyTaxes(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyTaxes that = (CompanyTaxes) o;
        return Objects.equals(companySiretNumber, that.companySiretNumber) &&
                Objects.equals(companyTaxValue, that.companyTaxValue);
    }

    @Override
    public int hashCode() {

        return Objects.hash(companySiretNumber, companyTaxValue);
    }

    @Override
    public String toString() {
        return "CompanyTaxes{" +
                "companySiretNumber='" + companySiretNumber + '\'' +
                ", companyTaxValue=" + companyTaxValue +
                '}';
    }
}
