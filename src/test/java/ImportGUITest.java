import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

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
    public void TestShowsErrorMessageOnEmptyFileName() {
        toTest.enterFilename.setText("");
        toTest.openFilename.doClick();
        ActionEvent e = new ActionEvent(this, 100, "Open File");
        toTest.actionPerformed(e);
        Assertions.assertTrue(toTest.text.isShowing());
        Assertions.assertEquals(toTest.text.getText(), "File can't be found. Please make sure the file is in this programs folder.");
    }

//    @Test
//    public void TestOpensTodoOnDefault() {
//        toTest.enterFilename.setText("");
//        toTest.openDefault.doClick();
//
//        Assertions.assertFalse(toTest.text.isShowing());
//    }

    @Test
    public void TestOpensTodoOnDefault1() {

        toTest.enterFilename.setText("");
        toTest.openDefault.doClick();

        try (MockedStatic<CLIMenu> utilities = Mockito.mockStatic(CLIMenu.class)) {
            utilities.when(() -> {
              CLIMenu.importList("default.txt");
            }).thenReturn(true);
        }

        Assertions.assertFalse(CLIMenu.importList("default.txt"));
        Assertions.assertFalse(toTest.text.isShowing());
    }

}
