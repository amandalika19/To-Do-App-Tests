import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CLIMenuTest
{
    private static CLIMenu newCli;
    static LocalDateTime time;

    Todo existingTodo;


    public CLIMenuTest()
    {
        newCli = new CLIMenu();
        time = LocalDateTime.now();
        existingTodo = new Todo("ToDo", time, Category.Red, Importance.Normal, Status.Pending);

    }

    @Test
    void addTodo_toDoListLengthGreaterThan0(){
        newCli.addTodo("ToDo", time, Category.Blue, Importance.High, Status.Started);
        newCli.addTodo("ToDo #2", time, Category.Yellow, Importance.Low, Status.Completed);
        assertEquals(2, CLIMenu.todos.size());
    }


    @Test
    void updateTodo_ComponentsUpdated(){
        String nonUpdatedTodo = existingTodo.toString();
        newCli.updateTodo(existingTodo, "Updated First Todo", time, Category.Red, Importance.Normal, Status.Partial);
        Assertions.assertNotEquals(existingTodo.toString(), nonUpdatedTodo);
    }

    @Test
    void deleteTodo_toDoListLengthEqualTo0(){
        newCli.deleteTodo(existingTodo);
        assertEquals(0, CLIMenu.todos.size());
    }


    @Test
    void importList(){
        String filename = "newToDoListFile";
        newCli.importList(filename);
        assertEquals(3, CLIMenu.todos.size());
    }

    @Test
    void importList_Exception(){
        String filename = "fail";
        assertFalse(newCli.importList(filename));
    }

    @Test
    void updateFile() {
        newCli.updateFile();
        assertEquals(0, CLIMenu.todos.size());
    }
}
