package companies;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.math.BigDecimal;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AutoEntrepreneur.class, name = "AUTOENTREPRENEUR"),
        @JsonSubTypes.Type(value = SAS.class, name = "SAS")
})
public interface Company {
    BigDecimal getTaxRate();
    String getSiretNumber();
}
