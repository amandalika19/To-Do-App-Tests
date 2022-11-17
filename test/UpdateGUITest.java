import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDateTime;

public class UpdateGUITest {
    UpdateGUI toTest;
    Todo todo;
    LocalDateTime now;

    public UpdateGUITest() {
        CLIMenu menu = new CLIMenu();
        now = LocalDateTime.now();
        todo = new Todo("testTodo", now, Category.Blue, Importance.Low, Status.Partial);
        toTest = new UpdateGUI(todo);
    }

    @Test
    public void TestUIElementsRendered() {
        Assertions.assertTrue(toTest.low.isShowing());
        Assertions.assertTrue(toTest.high.isShowing());
        Assertions.assertTrue(toTest.normal.isShowing());

        Assertions.assertTrue(toTest.red.isShowing());
        Assertions.assertTrue(toTest.blue.isShowing());
        Assertions.assertTrue(toTest.green.isShowing());
        Assertions.assertTrue(toTest.purple.isShowing());
        Assertions.assertTrue(toTest.yellow.isShowing());
        Assertions.assertTrue(toTest.orange.isShowing());
    }

    @ParameterizedTest
    @EnumSource(Category.class)
    public void TestCategorySelectedCorrectly(Category category) {
        todo.setCat(category);
        UpdateGUI gui = new UpdateGUI(todo);
        switch(category) {
            case Red -> {
                Assertions.assertTrue(gui.red.isSelected());
                break;
            }
            case Orange -> {
                Assertions.assertTrue(gui.orange.isSelected());
                break;
            }
            case Blue -> {
                Assertions.assertTrue(gui.blue.isSelected());
                break;
            }
            case Purple -> {
                Assertions.assertTrue(gui.purple.isSelected());
                break;
            }
            case Yellow -> {
                Assertions.assertTrue(gui.yellow.isSelected());
                break;
            }
            case Green -> {
                Assertions.assertTrue(gui.green.isSelected());
                break;
            }
        }
    }

    @ParameterizedTest
    @EnumSource(Importance.class)
    public void TestImportanceSelectedCorrectly(Importance importance) {
        todo.setImportance(importance);
        UpdateGUI gui = new UpdateGUI(todo);
        switch(importance) {
            case Low -> {
                Assertions.assertTrue(gui.low.isSelected());
                break;
            }
            case High -> {
                Assertions.assertTrue(gui.high.isSelected());
                break;
            }
            case Normal -> {
                Assertions.assertTrue(gui.normal.isSelected());
            }
        }
    }

    @ParameterizedTest
    @EnumSource(Status.class)
    public void TestStatusSelectedCorrectly(Status status) {
        todo.setStatus(status);
        UpdateGUI gui = new UpdateGUI(todo);
        switch(status) {
            case Pending -> {
                Assertions.assertTrue(gui.pending.isSelected());
                break;
            }
            case Started -> {
                Assertions.assertTrue(gui.started.isSelected());
                break;
            }
            case Partial -> {
                Assertions.assertTrue(gui.partial.isSelected());
                break;
            }
            case Completed -> {
                Assertions.assertTrue(gui.completed.isSelected());
                break;
            }
        }
    }

    @Test
    public void TestButtonGroupContents() {
        Assertions.assertEquals(toTest.catButtons.getButtonCount(), 6);
        Assertions.assertEquals(toTest.impButtons.getButtonCount(), 3);
        Assertions.assertEquals(toTest.statButtons.getButtonCount(), 4);
    }

    @Test
    public void TestUpdateGUIHasTodoFieldsSetCorrectly() {
        Assertions.assertEquals(toTest.enterName.getText(), todo.getText());
        Assertions.assertEquals(toTest.enterDate.getText(), todo.getDue().toString());
        Assertions.assertTrue(toTest.blue.isSelected());
        Assertions.assertTrue(toTest.low.isSelected());
        Assertions.assertTrue(toTest.partial.isSelected());
    }

    @Test
    public void TestUpdateChangesToTodo() {
        toTest.enterName.setText("This is the changed Text");
        toTest.normal.setSelected(true);
        toTest.green.setSelected(true);
        toTest.pending.setSelected(true);
        Assertions.assertDoesNotThrow(()-> {
            toTest.saveButton.doClick();
        });
    }

    @Test
    public void TestUpdateChangesAfterUpdateToDo() {
        toTest.enterName.setText("This is the changed Text");
        toTest.orange.setSelected(true);
        toTest.high.setSelected(true);
        toTest.completed.setSelected(true);
        Assertions.assertDoesNotThrow(()-> {
            toTest.saveButton.doClick();
        });
    }

    @Test
    public void TestUpdateChangesAfterUpdateToDoToDo() {
        toTest.enterName.setText("This is the changed Text");
        toTest.purple.setSelected(true);
        toTest.partial.setSelected(true);
        Assertions.assertDoesNotThrow(()-> {
            toTest.saveButton.doClick();
        });
    }

    @Test
    public void TestUpdateChangesWithEmptyTitle() {
        toTest.enterName.setText("");
        toTest.purple.setSelected(true);
        toTest.partial.setSelected(true);
        Assertions.assertDoesNotThrow(()-> {
            toTest.saveButton.doClick();
        });
        Assertions.assertEquals(toTest.text.getText(), "Name cannot be left empty.");
    }

    @Test
    public void TestUpdateChangesWithEmptyDate() {
        toTest.enterDate.setText("");
        toTest.purple.setSelected(true);
        toTest.partial.setSelected(true);
        Assertions.assertDoesNotThrow(()-> {
            toTest.saveButton.doClick();
        });
        Assertions.assertEquals(toTest.text.getText(), "Date cannot be left empty.");
    }

    @Test
    public void TestUpdateChangesWithInvalidDate() {
        toTest.enterDate.setText("Invalid Date");
        toTest.purple.setSelected(true);
        toTest.partial.setSelected(true);
        Assertions.assertDoesNotThrow(()-> {
            toTest.saveButton.doClick();
        });
        Assertions.assertEquals(toTest.text.getText(), "Invalid format entered. Enter a due date for the todo in the format YYYY-MM-DDTHH:MM.");
    }

    @Test
    public void TestUpdateChangesAfterUpdateToDoToDo1() {
        toTest.enterName.setText("This is the changed Text");
        toTest.yellow.setSelected(true);
        toTest.started.setSelected(true);
        Assertions.assertDoesNotThrow(()-> {
            toTest.saveButton.doClick();
        });
    }

    @Test
    public void TestCancelDismissesTheWindow() {
        Assertions.assertDoesNotThrow(()-> {
            toTest.cancelButton.doClick();
        });
    }
}
