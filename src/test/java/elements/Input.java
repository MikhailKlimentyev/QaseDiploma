package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

@Log4j2
public class Input extends Element {

    public Input(By locator, String label) {
        super(locator, label);
    }

    @Override
    public void write(String text) {
        log.info(String.format("Writing text '%s' into Input with label '%s'", text, label));
        super.write(text);
    }
}
