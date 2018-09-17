package companies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.math.BigDecimal;
import java.util.Objects;

@JsonDeserialize(builder = Turnover.Builder.class)
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

    @JsonIgnoreProperties(ignoreUnknown = true)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Turnover turnover = (Turnover) o;
        return Objects.equals(value, turnover.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Turnover{" +
                "value=" + value +
                '}';
    }
}
