import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StatusTest
{
    @Test
    public void StatusEnumTest_WhenBuildEnumWithPending_ReturnEnumPending() {
        assertEquals(Status.valueOf("Pending"), Status.Pending);
    }

    @Test
    public void StatusEnumTest_WhenBuildEnumWithStarted_ReturnEnumStarted() {
        assertEquals(Status.valueOf("Started"), Status.Started);
    }

    @Test
    public void StatusEnumTest_WhenBuildEnumWithPartial_ReturnEnumPartial() {
        assertEquals(Status.valueOf("Partial"), Status.Partial);
    }

    @Test
    public void StatusEnumTest_WhenBuildEnumWithCompleted_ReturnEnumCompleted() {
        assertEquals(Status.valueOf("Completed"), Status.Completed);
    }

    @ParameterizedTest
    @CsvSource({
            "Pending",
            "Started",
            "Partial",
            "Completed"
    })
    public void StatusEnumTest_WhenValidateEnumValue_ReturnTrue(String enumValue) {
        assertTrue(
                Arrays.stream(Status.values())
                        .anyMatch(status -> status.name().equals(enumValue))
        );
    }

    @Test
    public void StatusEnumTest_WhenValidateEnumValuesSize_ReturnExpectedSize() {
        assertEquals(4, Status.values().length);
    }
}
