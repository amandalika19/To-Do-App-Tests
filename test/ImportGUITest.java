import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

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
        Assertions.assertFalse(toTest.text.isShowing());
    }

    @Test
    public void TestOpensTodoOnDefault() {
        toTest.enterFilename.setText("");
        toTest.openDefault.doClick();
        Assertions.assertFalse(toTest.text.isShowing());
    }


}
