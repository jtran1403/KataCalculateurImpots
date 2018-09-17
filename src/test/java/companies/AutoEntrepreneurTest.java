package companies;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class AutoEntrepreneurTest {

    @Test
    public void should_return_an_auto_entrepreneur() {
        final AutoEntrepreneur autoEntrepreneur = AutoEntrepreneur.newBuilder()
                .withSiretNumber("MONACOCONFO001")
                .withName("Monaco Free Lancer John")
                .build();

        assertThat(autoEntrepreneur).isNotNull();
        assertThat(autoEntrepreneur.getSiretNumber()).isEqualTo("MONACOCONFO001");
        assertThat(autoEntrepreneur.getName()).isEqualTo("Monaco Free Lancer John");
        assertThat(autoEntrepreneur.getTaxRate()).isEqualTo(BigDecimal.valueOf(0.25D));
    }

    @Test
    public void should_deserialize() throws IOException {
        //Given
        final ObjectMapper objectMapper = new ObjectMapper();
        final AutoEntrepreneur expectedAutoEntrepreneur = AutoEntrepreneur.newBuilder()
                .withSiretNumber("732 829 320 00074")
                .withName("Ma start up")
                .build();
        final String autoEntrepreneurAsString = "{\"siretNumber\": \"732 829 320 00074\", \"name\": \"Ma start up\", \"type\": \"AUTOENTREPRENEUR\"}";

        //When
        final AutoEntrepreneur autoEntrepreneur = objectMapper.readValue(autoEntrepreneurAsString, AutoEntrepreneur.class);

        //Then
        assertThat(autoEntrepreneur).isEqualTo(expectedAutoEntrepreneur);
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