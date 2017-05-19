package ...

...
import static org.assertj.core.api.Assertions.assertThat;

public class TestClass {
    @Test
    public void testOnePlusOneEqualsTwo() {
        Assert.assertEquals(1, 1); // Default JUnit notation
        assertThat(1).isEqualTo(1); // AssertJ notation
    }
}