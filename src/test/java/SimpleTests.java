import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTests {
    @Test
    void firstTest() {
        assertEquals(true, true);
    }

    @Test
    void negativeTest() {
        assertEquals(true, false);
    }
}
