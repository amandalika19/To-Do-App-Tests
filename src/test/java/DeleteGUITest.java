import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

public class DeleteGUITest
{
    DeleteGUI newDeleteGUI;
    static LocalDateTime time;
    Todo existingTodo;


    public DeleteGUITest() {
        CLIMenu menu = new CLIMenu();
        time = LocalDateTime.now();
        existingTodo = new Todo("testTodo", time, Category.Blue, Importance.Low, Status.Partial);
        newDeleteGUI = new DeleteGUI(existingTodo);
    }

    @Test
    public void DeleteGUI_DeleteConfirmationUICheck() {
        Assertions.assertTrue(newDeleteGUI.deleteButton.isShowing());
        Assertions.assertTrue(newDeleteGUI.cancelButton.isShowing());
    }

    @Test
    public void DeleteGUI_DeleteButtonClick() {
        Assertions.assertDoesNotThrow(()-> {
            newDeleteGUI.deleteButton.doClick();
        });
    }

    @Test
    public void DeleteGUI_CancelButtonClick() {
        Assertions.assertDoesNotThrow(() -> {
            newDeleteGUI.cancelButton.doClick();
        });
    }
}
