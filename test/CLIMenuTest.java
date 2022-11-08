import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

public class CLIMenuTest
{
    private static CLIMenu newCli;
    static LocalDateTime time;


    @BeforeAll
    public static void init()
    {
        CLIMenu newCli = new CLIMenu();
        time = LocalDateTime.of(2022,11,7,22,00);
    }

    @Test
    void addTodo_toDoListLengthGreaterThan0(){
        newCli.addTodo("Test", time, Category.Blue, Importance.High, Status.Started);
        Assertions.assertEquals(1, CLIMenu.todos.size());
    }

}
