import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


import java.awt.event.ActionEvent;


public class ImportGUITest {
    ImportGUI toTest;

    public ImportGUITest() {
        CLIMenu menu = new CLIMenu();
        toTest = new ImportGUI();
    }

    @Test
    public void TestUIIsRenderedProperly() {
        Assertions.assertTrue(toTest.enterFilename.isEnabled());
        Assertions.assertTrue(toTest.openFilename.isEnabled());
        Assertions.assertTrue(toTest.openDefault.isEnabled());
    }

    @Test
    public void TestDisplaysErrorMessageOnEmptyFileName() {
        toTest.enterFilename.setText("");
        toTest.openFilename.doClick();
        ActionEvent e = new ActionEvent(this, 100, "Open File");
        toTest.actionPerformed(e);
        Assertions.assertTrue(toTest.text.isShowing());
        Assertions.assertEquals(toTest.text.getText(), "File can't be found. Please make sure the file is in this programs folder.");
    }

    @Test
    public void TestDisplaysErrorMessageOnDifferentActionCommand() {
        toTest.enterFilename.setText("");
        toTest.openFilename.doClick();
        ActionEvent e = new ActionEvent(this, 100, "Not Open File");
        toTest.actionPerformed(e);
        Assertions.assertFalse(toTest.text.isShowing());
        Assertions.assertEquals(toTest.text.getText(), "File can't be found. Please make sure the file is in this programs folder.");
    }

    @Test
    public void TestOpensTodoPerformActionOnValidFile() {
        toTest.enterFilename.setText("default");
        toTest.openDefault.doClick();

        ActionEvent e = new ActionEvent(this, 100, "Open File");
        toTest.actionPerformed(e);
        Assertions.assertFalse(toTest.text.isShowing());
    }

}
