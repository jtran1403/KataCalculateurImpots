package companies;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class AutoEntrepreneurTest {

    @Test
    public void should_return_an_auto_entrepreneur() {
        final AutoEntrepreneur autoEntrepreneur = AutoEntrepreneur.newBuilder()
                .withSiretNumber("MONACOCONFO001")
                .withName("Monaco Free Lancer John")
                .build();

        assertThat(autoEntrepreneur.getSiretNumber()).isEqualTo("MONACOCONFO001");
        assertThat(autoEntrepreneur.getName()).isEqualTo("Monaco Free Lancer John");
    }

    @Test
    public void should_throw_exception_if_the_siret_number_of_auto_entrepreneur_is_missing() {
        assertThatThrownBy(() -> AutoEntrepreneur.newBuilder().withName("Monaco Free Lancer John").build())
                .isInstanceOf(NullPointerException.class)
                .hasMessage("The SIRET number is mandatory");
    }

    @Test
    public void should_throw_exception_if_the_name_of_auto_entrepreneur_is_missing() {
        assertThatThrownBy(() -> AutoEntrepreneur.newBuilder().withSiretNumber("MONACOCONFO001").build())
                .isInstanceOf(NullPointerException.class)
                .hasMessage("The name is mandatory");
    }
}