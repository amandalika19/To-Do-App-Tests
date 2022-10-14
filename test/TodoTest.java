import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

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
    void TestSetDue()
    {
        long timestamp = System.currentTimeMillis() ;
        LocalDateTime time = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp),
                        TimeZone.getDefault().toZoneId());
        setup.setDue(time);
        Assertions.assertEquals(time, setup.getDue());
    }


    @Test
    void TestGetCat()
    {
        Assertions.assertEquals(Category.Blue, setup.getCat());
    }

    @Test
    void TestSetCat()
    {
        setup.setCat(Category.Red);
        Assertions.assertEquals(Category.Red, setup.getCat());
    }

    @Test
    void TestGetStatus()
    {
        Assertions.assertEquals(Status.Started, setup.getStatus());
    }

    @Test
    void TestSetStatus(){
        setup.setStatus(Status.Completed);
        Assertions.assertEquals(Status.Completed, setup.getStatus());

    }

    @Test
    void TestGetImportance()
    {
        Assertions.assertEquals(Importance.High, setup.getImportance());
    }

    @Test
    void TestSetImportance(){
        setup.setImportance(Importance.Low);
        Assertions.assertEquals(Importance.Low, setup.getImportance());
    }
}
