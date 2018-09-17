package companies;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.assertj.core.api.Assertions.assertThat;

public class CompanyTest {

    @Test
    public void should_recognize_an_auto_entrepreneur_as_a_company() {
        final Company company = AutoEntrepreneur.newBuilder()
                .withSiretNumber("MONACOCONFO001")
                .withName("Monaco Free Lancer John")
                .build();

        assertThat(company).isNotNull();
        assertThat(company.getTaxRate()).isEqualTo(new BigDecimal(0.25D).setScale(2, RoundingMode.HALF_UP));
    }
    @Test
    public void should_recognize_a_SAS_as_a_company() {
        final Company company = SAS.newBuilder()
                .withSiretNumber("732 829 320 00074")
                .withName("Paris SAS")
                .withHeadOfficeAddress("25 rue victor Hugo")
                .build();

        assertThat(company).isNotNull();
        assertThat(company.getTaxRate()).isEqualTo(new BigDecimal(0.33D).setScale(2, RoundingMode.HALF_UP));
    }
}