import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddGUITest {

    @Test
    public void AddGUITest_TestFrameSettings_ReturnExpectedValues() {
        AddGUI addGUI = new AddGUI();

        assertEquals(650, addGUI.getSize().getWidth());
        assertEquals(350, addGUI.getSize().getHeight());
        assertEquals("Add New To Do", addGUI.getTitle());
        assertEquals(JFrame.DO_NOTHING_ON_CLOSE, addGUI.getDefaultCloseOperation());
        assertEquals(300, addGUI.getLocation().x);
        assertEquals(300, addGUI.getLocation().y);
    }

    @Test
    public void AddGUITest_TestJTextFieldSettings_ReturnExpectedValues() {
        AddGUI addGUI = new AddGUI();

        assertEquals(100, addGUI.enterName.getColumns());
        assertEquals(100, addGUI.enterName.getMinimumSize().width);
        assertEquals(20, addGUI.enterName.getMinimumSize().height);

        assertEquals(100, addGUI.enterDate.getColumns());
        assertEquals(100, addGUI.enterDate.getMinimumSize().width);
        assertEquals(20, addGUI.enterDate.getMinimumSize().height);
    }

    @Test
    public void AddGUITest_TestCategoryRadioButtons_ReturnExpectedValues() {
        AddGUI addGUI = new AddGUI();

        assertEquals("Red", addGUI.red.getText());
        assertEquals("Orange", addGUI.orange.getText());
        assertEquals("Blue", addGUI.blue.getText());
        assertEquals("Purple", addGUI.purple.getText());
        assertEquals("Yellow", addGUI.yellow.getText());
        assertEquals("Green", addGUI.green.getText());
        assertEquals(6, addGUI.catButtons.getButtonCount());
    }

    @Test
    public void AddGUITest_TestImportanceRadioButtons_ReturnExpectedValues() {
        AddGUI addGUI = new AddGUI();

        assertEquals("Low", addGUI.low.getText());
        assertEquals("Normal", addGUI.normal.getText());
        assertEquals("High", addGUI.high.getText());
        assertEquals(3, addGUI.impButtons.getButtonCount());
    }

    @Test
    public void AddGUITest_TestStatusRadioButtons_ReturnExpectedValues() {
        AddGUI addGUI = new AddGUI();

        assertEquals("Pending", addGUI.pending.getText());
        assertEquals("Started", addGUI.started.getText());
        assertEquals("Partial", addGUI.partial.getText());
        assertEquals("Completed", addGUI.completed.getText());
        assertEquals(4, addGUI.statButtons.getButtonCount());
    }

    @Test
    public void AddGUITest_TestMessageLabel_ReturnExpectedValues() {
        AddGUI addGUI = new AddGUI();

        assertEquals("  ", addGUI.text.getText());
        assertEquals(SwingConstants.CENTER, addGUI.text.getHorizontalAlignment());
        assertEquals("Tahoma", addGUI.text.getFont().getName());
        assertEquals(Font.PLAIN, addGUI.text.getFont().getStyle());
        assertEquals(13, addGUI.text.getFont().getSize());
    }

    @Test
    public void AddGUITest_TestButtons_ReturnExpectedValues() {
        AddGUI addGUI = new AddGUI();

        assertEquals("Add Todo", addGUI.addButton.getText());
        assertEquals(150, addGUI.addButton.getPreferredSize().getWidth());
        assertEquals(40, addGUI.addButton.getPreferredSize().getHeight());
        assertEquals("Tahoma", addGUI.addButton.getFont().getName());
        assertEquals(Font.PLAIN, addGUI.addButton.getFont().getStyle());
        assertEquals(14, addGUI.addButton.getFont().getSize());


        assertEquals("Cancel", addGUI.cancelButton.getText());
        assertEquals(150, addGUI.cancelButton.getPreferredSize().getWidth());
        assertEquals(40, addGUI.cancelButton.getPreferredSize().getHeight());
        assertEquals("Tahoma", addGUI.cancelButton.getFont().getName());
        assertEquals(Font.PLAIN, addGUI.cancelButton.getFont().getStyle());
        assertEquals(14, addGUI.cancelButton.getFont().getSize());
    }

    @Test
    public void actionPerformed_WhenTODOActionEventWithEmptyEnterName_ThenLoadTestWithErrorMessage() {
        AddGUI addGUI = new AddGUI();

        String commandName = "Add Todo";
        ActionEvent event = new ActionEvent(this, 120, commandName);
        addGUI.actionPerformed(event);
        assertEquals("Name cannot be left empty.", addGUI.text.getText());
    }

    @Test
    public void actionPerformed_WhenTODOActionEventWithEmptyEnterDate_ThenLoadTestWithErrorMessage() {
        AddGUI addGUI = new AddGUI();
        addGUI.enterName.setText(UUID.randomUUID().toString());

        String commandName = "Add Todo";
        ActionEvent event = new ActionEvent(this, 120, commandName);
        addGUI.actionPerformed(event);
        assertEquals("Date cannot be left empty.", addGUI.text.getText());
    }

    @Test
    public void actionPerformed_WhenTODOActionEventWithInvalidEnterDate_ThenLoadTestWithErrorMessage() {
        AddGUI addGUI = new AddGUI();
        addGUI.enterName.setText(UUID.randomUUID().toString());
        addGUI.enterDate.setText("2012:12:32");

        String commandName = "Add Todo";
        ActionEvent event = new ActionEvent(this, 120, commandName);
        addGUI.actionPerformed(event);
        assertEquals("Invalid format entered. Enter a due date for the todo in the format YYYY-MM-DDTHH:MM.", addGUI.text.getText());
    }

    @Test
    public void actionPerformed_WhenTODOActionEventWithCategoryNotSelected_ThenLoadTestWithErrorMessage() {
        AddGUI addGUI = new AddGUI();
        addGUI.enterName.setText(UUID.randomUUID().toString());
        addGUI.enterDate.setText(LocalDateTime.now().toString());

        String commandName = "Add Todo";
        ActionEvent event = new ActionEvent(this, 120, commandName);
        addGUI.actionPerformed(event);
        assertEquals("Category must be selected.", addGUI.text.getText());
    }

    @Test
    public void actionPerformed_WhenTODOActionEventWithImportanceNotSelected_ThenLoadTestWithErrorMessage() {
        AddGUI addGUI = new AddGUI();
        addGUI.enterName.setText(UUID.randomUUID().toString());
        addGUI.enterDate.setText(LocalDateTime.now().toString());
        addGUI.red.setSelected(true);

        String commandName = "Add Todo";
        ActionEvent event = new ActionEvent(this, 120, commandName);
        addGUI.actionPerformed(event);
        assertEquals("Importance must be selected.", addGUI.text.getText());
    }

    @Test
    public void actionPerformed_WhenTODOActionEventWithStatusNotSelected_ThenLoadTestWithErrorMessage() {
        AddGUI addGUI = new AddGUI();
        addGUI.enterName.setText(UUID.randomUUID().toString());
        addGUI.enterDate.setText(LocalDateTime.now().toString());
        addGUI.red.setSelected(true);
        addGUI.low.setSelected(true);

        String commandName = "Add Todo";
        ActionEvent event = new ActionEvent(this, 120, commandName);
        addGUI.actionPerformed(event);
        assertEquals("Status must be selected.", addGUI.text.getText());
    }

    @Test
    public void actionPerformed_WhenTODOActionEventWithRedLowPending_ThenPerformAction() {
        AddGUI addGUI = new AddGUI();
        addGUI.enterName.setText(UUID.randomUUID().toString());
        addGUI.enterDate.setText(LocalDateTime.now().toString());
        addGUI.red.setSelected(true);
        addGUI.low.setSelected(true);
        addGUI.pending.setSelected(true);
        CLIMenu cliMenu = new CLIMenu();

        String commandName = "Add Todo";
        ActionEvent event = new ActionEvent(this, 120, commandName);
        addGUI.actionPerformed(event);
    }

    @Test
    public void actionPerformed_WhenTODOActionEventWithOrangeNormalPartial_ThenPerformAction() {
        AddGUI addGUI = new AddGUI();
        addGUI.enterName.setText(UUID.randomUUID().toString());
        addGUI.enterDate.setText(LocalDateTime.now().toString());
        addGUI.orange.setSelected(true);
        addGUI.normal.setSelected(true);
        addGUI.partial.setSelected(true);
        CLIMenu cliMenu = new CLIMenu();

        String commandName = "Add Todo";
        ActionEvent event = new ActionEvent(this, 120, commandName);
        addGUI.actionPerformed(event);
    }

    @Test
    public void actionPerformed_WhenTODOActionEventWithBlueHighStarted_ThenPerformAction() {
        AddGUI addGUI = new AddGUI();
        addGUI.enterName.setText(UUID.randomUUID().toString());
        addGUI.enterDate.setText(LocalDateTime.now().toString());
        addGUI.blue.setSelected(true);
        addGUI.high.setSelected(true);
        addGUI.started.setSelected(true);
        CLIMenu cliMenu = new CLIMenu();

        String commandName = "Add Todo";
        ActionEvent event = new ActionEvent(this, 120, commandName);
        addGUI.actionPerformed(event);
    }

    @Test
    public void actionPerformed_WhenTODOActionEventWithPurpleHighCompleted_ThenPerformAction() {
        AddGUI addGUI = new AddGUI();
        addGUI.enterName.setText(UUID.randomUUID().toString());
        addGUI.enterDate.setText(LocalDateTime.now().toString());
        addGUI.purple.setSelected(true);
        addGUI.high.setSelected(true);
        addGUI.completed.setSelected(true);
        CLIMenu cliMenu = new CLIMenu();

        String commandName = "Add Todo";
        ActionEvent event = new ActionEvent(this, 120, commandName);
        addGUI.actionPerformed(event);
    }

    @Test
    public void actionPerformed_WhenTODOActionEventWithGreenHighCompleted_ThenPerformAction() {
        AddGUI addGUI = new AddGUI();
        addGUI.enterName.setText(UUID.randomUUID().toString());
        addGUI.enterDate.setText(LocalDateTime.now().toString());
        addGUI.green.setSelected(true);
        addGUI.high.setSelected(true);
        addGUI.completed.setSelected(true);
        CLIMenu cliMenu = new CLIMenu();

        String commandName = "Add Todo";
        ActionEvent event = new ActionEvent(this, 120, commandName);
        addGUI.actionPerformed(event);
    }

    @Test
    public void actionPerformed_WhenTODOActionEventWithYellowHighCompleted_ThenPerformAction() {
        AddGUI addGUI = new AddGUI();
        addGUI.enterName.setText(UUID.randomUUID().toString());
        addGUI.enterDate.setText(LocalDateTime.now().toString());
        addGUI.yellow.setSelected(true);
        addGUI.high.setSelected(true);
        addGUI.completed.setSelected(true);
        CLIMenu cliMenu = new CLIMenu();

        String commandName = "Add Todo";
        ActionEvent event = new ActionEvent(this, 120, commandName);
        addGUI.actionPerformed(event);
    }
}
