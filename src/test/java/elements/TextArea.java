package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

@Log4j2
public class TextArea extends Element {

    public TextArea(By locator, String label) {
        super(locator, label);
    }

    @Override
    public void write(String text) {
        log.info(String.format("Writing text '%s' into TextArea with label '%s'", text, label));
        super.write(text);
    }
}
