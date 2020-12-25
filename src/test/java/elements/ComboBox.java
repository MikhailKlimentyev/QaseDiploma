package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

@Log4j2
public class ComboBox extends Element {

    private String comboBoxPattern = "//*[contains(text(), '%s')]/following-sibling::*//input[@type='text']";

    public ComboBox(String label) {
        super(label);
        locator = By.xpath(String.format(comboBoxPattern, label));
    }

    @Override
    public void set(String text) {
        log.info(String.format("Entering text '%s' into ComboBox with label '%s'", text, label));
        super.enter(text);
    }
}
