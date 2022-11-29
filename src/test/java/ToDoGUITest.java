import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class ToDoGUITest
{
    TodoGUI toTest;

    public ToDoGUITest() {
        CLIMenu menu = new CLIMenu();
        toTest = new TodoGUI();
    }
    @Test
    public void ToDoGUITest_TestFrameSettings_ReturnExpectedValues() {
        Assertions.assertEquals(700, toTest.getSize().getWidth());
        Assertions.assertEquals(300, toTest.getSize().getHeight());
        Assertions.assertEquals("To Do List Application", toTest.getTitle());
        Assertions.assertEquals(3, toTest.getDefaultCloseOperation());
        Assertions.assertEquals(300, toTest.getLocation().x);
        Assertions.assertEquals(300, toTest.getLocation().y);
    }

    @Test
    public void TestUIIsRenderedProperly()
    {
        Assertions.assertTrue(toTest.addButton.isEnabled());
        Assertions.assertTrue(toTest.updateButton.isEnabled());
        Assertions.assertTrue(toTest.deleteButton.isEnabled());
        Assertions.assertTrue(toTest.newListButton.isEnabled());
    }

    @Test
    public void actionPerformed_WhenAddToDo_GUIDisposed()
    {
        String commandName = "Add To-do";
        ActionEvent event = new ActionEvent(this, 120, commandName);
        toTest.actionPerformed(event);
        Assertions.assertEquals(false, toTest.isVisible());
    }

    @Test
    public void actionPerformed_WhenUpdateToDo_NoCurrentToDo()
    {
        String commandName = "Update To-do";
        ActionEvent event = new ActionEvent(this, 120, commandName);
        toTest.actionPerformed(event);
        Assertions.assertEquals("Please select a todo to update.", toTest.text.getText());
    }

    @Test
    public void actionPerformed_WhenDeleteToDo_NoCurrentToDo()
    {
        String commandName = "Delete To-do";
        ActionEvent event = new ActionEvent(this, 120, commandName);
        toTest.actionPerformed(event);
        Assertions.assertEquals("Please select a todo to delete.", toTest.text.getText());
    }

    @Test
    public void actionPerformed_WhenImportToDo_GUIDisposed()
    {
        String commandName = "Open Another List";
        ActionEvent event = new ActionEvent(this, 120, commandName);
        toTest.actionPerformed(event);
        Assertions.assertEquals(false, toTest.isVisible());
    }

    @Test
    public void actionPerformed_WhenUpdateToDo_GUIDisposed()
    {
        LocalDateTime time = LocalDateTime.of(2022,10,11,22,00);
        toTest.currentTodo = new Todo("Test", time, Category.Blue, Importance.High, Status.Started);
        String commandName = "Update To-do";
        ActionEvent event = new ActionEvent(this, 120, commandName);
        toTest.actionPerformed(event);
        Assertions.assertEquals(false, toTest.isVisible());
    }

    @Test
    public void actionPerformed_WhenDeleteToDo_GUIDisposed()
    {
        LocalDateTime time = LocalDateTime.of(2022,10,11,22,00);
        toTest.currentTodo = new Todo("Test", time, Category.Blue, Importance.High, Status.Started);
        String commandName = "Delete To-do";
        ActionEvent event = new ActionEvent(this, 120, commandName);
        toTest.actionPerformed(event);
        Assertions.assertEquals(false, toTest.isVisible());
    }

    @Test
    public void valueChanged_NullPointerExceptionWhenSourceObjectIsWrong()
    {
        LocalDateTime time = LocalDateTime.of(2022,10,11,22,00);
        Todo test = new Todo("Test", time, Category.Blue, Importance.High, Status.Started);
        ListSelectionEvent e = new ListSelectionEvent(test, 0, 0, true);
        Exception exception = assertThrows(NullPointerException.class, ()-> {toTest.valueChanged(e);});
        Assertions.assertTrue(exception.getMessage().contains("Cannot invoke"));
    }


}
