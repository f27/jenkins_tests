package tests;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleTests {
    @Test
    void successTest() {
       assertThat(true).isEqualTo(true);
    }

    @Test
    void negativeTest() {
        assertThat(false).isEqualTo(true);
    }


}
