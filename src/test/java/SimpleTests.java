import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleTests {
    @Test
    void firstTest() {
       assertThat(true).isEqualTo(true);
    }

    @Test
    void negativeTest() {
        assertThat(true).isEqualTo(false);
    }
}
