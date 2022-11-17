import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

public class MainTest {
    @Test
    public void testMain()  {
        System.out.println("main");
        String[] args = null;
        Main.main(args);
    }
}