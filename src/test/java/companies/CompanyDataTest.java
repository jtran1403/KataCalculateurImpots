package companies;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CompanyDataTest {

    @Test
    public void should_test_equality() {
        EqualsVerifier.forClass(CompanyData.class).verify();
    }

    @Test
    public void should_throw_exception_when_company_is_missing() {
        assertThatThrownBy(() -> CompanyData.newBuilder()
                .withCompanyTurnover(Turnover.newBuilder().withValue(BigDecimal.ONE).build())
                .build())
                .hasMessage("The company is mandatory");
    }

    @Test
    public void should_throw_exception_when_company_turn_over_is_missing() {
        assertThatThrownBy(() -> CompanyData.newBuilder().withCompany(
                AutoEntrepreneur.newBuilder()
                        .withSiretNumber("MONACOCONFO001")
                        .withName("Monaco Free Lancer John")
                        .build())
                .build())
                .isInstanceOf(NullPointerException.class)
                .hasMessage("The company turnover is mandatory");
    }

}