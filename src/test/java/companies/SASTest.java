package companies;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SASTest {

    @Test
    public void should_return_a_SAS() {
        final SAS sas = SAS.newBuilder()
                .withSiretNumber("732 829 320 00074")
                .withName("Paris SAS")
                .withHeadOfficeAddress("25 rue victor Hugo")
                .build();

        assertThat(sas).isNotNull();
        assertThat(sas.getSiretNumber()).isEqualTo("732 829 320 00074");
        assertThat(sas.getName()).isEqualTo("Paris SAS");
        assertThat(sas.getHeadOfficeAddress()).isEqualTo("25 rue victor Hugo");
        assertThat(sas.getTaxRate()).isEqualTo(BigDecimal.valueOf(0.33D));
    }

    @Test
    public void should_deserialize() throws IOException {
        //Given
        final ObjectMapper objectMapper = new ObjectMapper();
        final SAS expectedSAS = SAS.newBuilder()
                .withSiretNumber("RC NANTES 234 987 456")
                .withName("Entreprise à Nantes")
                .withHeadOfficeAddress("25 avenue de nantes")
                .build();
        final String sasAsString = "{\n" +
                "      \"siretNumber\": \"RC NANTES 234 987 456\",\n" +
                "      \"name\": \"Entreprise à Nantes\",\n" +
                "      \"type\": \"SAS\",\n" +
                "      \"headOfficeAddress\": \"25 avenue de nantes\"\n" +
                "    }";

        //When
        final SAS sas = objectMapper.readValue(sasAsString, SAS.class);

        //Then
        assertThat(sas).isEqualTo(expectedSAS);
    }

    @Test
    public void should_throw_exception_if_the_siret_number_of_sas_is_missing() {
        assertThatThrownBy(() -> SAS.newBuilder()
                .withName("Paris SAS")
                .withHeadOfficeAddress("25 rue victor Hugo")
                .build())
                .isInstanceOf(NullPointerException.class)
                .hasMessage("The SIRET number is mandatory");
    }

    @Test
    public void should_throw_exception_if_the_name_of_sas_is_missing() {
        assertThatThrownBy(() -> SAS.newBuilder()
                .withSiretNumber("732 829 320 00074")
                .withHeadOfficeAddress("25 rue victor Hugo")
                .build())
                .isInstanceOf(NullPointerException.class)
                .hasMessage("The name is mandatory");
    }

    @Test
    public void should_throw_exception_if_the_head_office_address_of_sas_is_missing() {
        assertThatThrownBy(() -> SAS.newBuilder()
                .withSiretNumber("732 829 320 00074")
                .withName("Paris SAS")
                .build())
                .isInstanceOf(NullPointerException.class)
                .hasMessage("The head office address is mandatory");
    }
}