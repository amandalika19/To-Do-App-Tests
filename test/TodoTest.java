import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class TodoTest
{
    private static Todo setup;

    @BeforeAll
    public static void init()
    {
        LocalDateTime time = LocalDateTime.of(2022,10,11,22,00);
        setup = new Todo("Test", time, Category.Blue, Importance.High, Status.Started);
    }

    @Test
    void TestGetString()
    {
        Assertions.assertEquals("Test", setup.getText());
    }

    @Test
    void TestGetDue()
    {
        LocalDateTime time = setup.getDue();
        Assertions.assertEquals(2022, time.getYear());
        Assertions.assertEquals(10, time.getMonthValue());
        Assertions.assertEquals(11, time.getDayOfMonth());
        Assertions.assertEquals(22, time.getHour());
        Assertions.assertEquals(00, time.getMinute());
    }

    @Test
    void TestGetCat()
    {
        Assertions.assertEquals(Category.Blue, setup.getCat());
    }

    @Test
    void TestGetStatus()
    {
        Assertions.assertEquals(Status.Started, setup.getStatus());
    }

    @Test
    void TestGetImportance()
    {
        Assertions.assertEquals(Importance.High, setup.getImportance());
    }
}
