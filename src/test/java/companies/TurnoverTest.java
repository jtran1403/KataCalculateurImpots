package companies;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TurnoverTest {

    @Test
    public void should_return_the_turn_over_of_a_company_in_euros() {
        final Turnover turnover = Turnover.newBuilder().withValue(BigDecimal.valueOf(new Double("10000.99"))).build();

        assertThat(turnover.getValue()).isEqualTo(BigDecimal.valueOf(new Double("10000.99")));
        assertThat(turnover.getCurrency()).isEqualTo("EURO(S)");
    }

    @Test
    public void should_throw_exception_when_value_of_turnover_is_missing() {
        assertThatThrownBy(() -> Turnover.newBuilder().build())
                .isInstanceOf(NullPointerException.class)
                .hasMessage("The value is mandatory");
    }

}