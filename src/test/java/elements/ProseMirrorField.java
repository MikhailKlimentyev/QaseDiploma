package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

@Log4j2
public class ProseMirrorField extends Element {

    private String fieldPattern = "//*[contains(text(), '%s')]/following-sibling::*//*[@contenteditable='true']";

    public ProseMirrorField(String label) {
        super(label);
        locator = By.xpath(String.format(fieldPattern, label));
    }

    @Override
    public void write(String text) {
        log.info(String.format("Writing text '%s' into ProseMirrorField with label '%s'", text, label));
        super.write(text);
    }
}
