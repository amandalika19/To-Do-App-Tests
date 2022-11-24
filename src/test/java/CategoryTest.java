import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CategoryTest {

    @Test
    public void CategoryEnumTest_WhenValidateRedEnumValue_returnExpectedValue() {
        assertEquals("\033[0;31m", Category.Red.getColour());
    }

    @Test
    public void CategoryEnumTest_WhenValidateOrangeEnumValue_returnExpectedValue() {
        assertEquals("\033[0;37m", Category.Orange.getColour());
    }

    @Test
    public void CategoryEnumTest_WhenValidateBlueEnumValue_returnExpectedValue() {
        assertEquals("\033[0;34m", Category.Blue.getColour());
    }

    @Test
    public void CategoryEnumTest_WhenValidatePurpleEnumValue_returnExpectedValue() {
        assertEquals("\033[0;35m", Category.Purple.getColour());
    }

    @Test
    public void CategoryEnumTest_WhenValidateYellowEnumValue_returnExpectedValue() {
        assertEquals("\033[0;33m", Category.Yellow.getColour());
    }

    @Test
    public void CategoryEnumTest_WhenValidateGreenEnumValue_returnExpectedValue() {
        assertEquals("\033[0;32m", Category.Green.getColour());
    }

    @ParameterizedTest
    @CsvSource({
            "Red",
            "Orange",
            "Blue",
            "Purple",
            "Yellow",
            "Green",
    })
    public void CategoryEnumTest_WhenValidateEnumValue_ReturnTrue(String enumValue) {
        assertTrue(
                Arrays.stream(Category.values())
                        .anyMatch(category -> category.name().equals(enumValue))
        );
    }

    @Test
    public void CategoryEnumTest_WhenValidateEnumValuesSize_ReturnExpectedSize() {
        assertEquals(6, Category.values().length);
    }
}
