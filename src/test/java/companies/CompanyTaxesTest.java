package companies;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CompanyTaxesTest {

    @Test
    public void should_test_equality() {
        EqualsVerifier.forClass(CompanyTaxes.class).verify();
    }

    @Test
    public void should_throw_exception_when_company_siret_number_is_missing() {
        assertThatThrownBy(() -> CompanyTaxes.newBuilder().withCompanyTaxValue(BigDecimal.ONE).build())
        .isInstanceOf(NullPointerException.class)
        .hasMessage("The company SIRET number is mandatory");
    }

    @Test
    public void should_throw_exception_when_company_tax_value_is_missing() {
        assertThatThrownBy(() -> CompanyTaxes.newBuilder().withCompanySiretNumber("SIRET").build())
                .isInstanceOf(NullPointerException.class)
                .hasMessage("The company tax value is mandatory");
    }
}