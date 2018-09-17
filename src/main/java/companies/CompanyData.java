package companies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Objects;

@JsonDeserialize(builder = CompanyData.Builder.class)
public final class CompanyData {
    private final Company company;
    private final Turnover companyTurnover;

    private CompanyData(Builder builder) {
        company = builder.company;
        companyTurnover = builder.companyTurnover;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Company getCompany() {
        return company;
    }

    public Turnover getCompanyTurnover() {
        return companyTurnover;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Company company;
        private Turnover companyTurnover;

        private Builder() {
        }

        public Builder withCompany(Company val) {
            company = val;
            return this;
        }

        public Builder withCompanyTurnover(Turnover val) {
            companyTurnover = val;
            return this;
        }

        public CompanyData build() {
            Objects.requireNonNull(this.company,"The company is mandatory");
            Objects.requireNonNull(this.companyTurnover,"The company turnover is mandatory");
            return new CompanyData(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyData that = (CompanyData) o;
        return Objects.equals(company, that.company) &&
                Objects.equals(companyTurnover, that.companyTurnover);
    }

    @Override
    public int hashCode() {

        return Objects.hash(company, companyTurnover);
    }

    @Override
    public String toString() {
        return "CompanyData{" +
                "company=" + company +
                ", companyTurnover=" + companyTurnover +
                '}';
    }
}
