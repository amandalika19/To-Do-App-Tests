import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ImportanceTest {

    @Test
    public void ImportanceEnumTest_WhenBuildEnumWithLow_ReturnEnumLow() {
        assertEquals(Importance.valueOf("Low"), Importance.Low);
    }

    @Test
    public void ImportanceEnumTest_WhenBuildEnumWithNormal_ReturnEnumNormal() {
        assertEquals(Importance.valueOf("Normal"), Importance.Normal);
    }

    @Test
    public void ImportanceEnumTest_WhenBuildEnumWithHigh_ReturnEnumHigh() {
        assertEquals(Importance.valueOf("High"), Importance.High);
    }

    @ParameterizedTest
    @CsvSource({
            "Low",
            "Normal",
            "High"
    })
    public void ImportanceEnumTest_WhenValidateEnumValue_ReturnTrue(String enumValue) {
        assertTrue(
                Arrays.stream(Importance.values())
                        .anyMatch(importance -> importance.name().equals(enumValue))
        );
    }

    @Test
    public void ImportanceEnumTest_WhenValidateEnumValuesSize_ReturnExpectedSize() {
        assertEquals(3, Importance.values().length);
    }
}
