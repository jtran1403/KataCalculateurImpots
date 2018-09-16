package companies;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class CompanyTest {

    @Test
    public void should_recognize_an_auto_entrepreneur_as_a_company() {
        final Company company = AutoEntrepreneur.newBuilder()
                .withSiretNumber("MONACOCONFO001")
                .withName("Monaco Free Lancer John")
                .build();

        assertThat(company).isNotNull();
        assertThat(company.getTaxRate()).isEqualTo(BigDecimal.valueOf(0.25D));
    }
}