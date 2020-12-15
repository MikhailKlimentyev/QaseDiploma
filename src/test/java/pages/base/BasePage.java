package pages.base;

import lombok.extern.log4j.Log4j2;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.open;

@Log4j2
public abstract class BasePage extends AbstractPage {

    public static final String START_URL = PropertyReader.getProperty("StartUrl");
    public static final String BASE_URL = PropertyReader.getProperty("BaseUrl");

    public abstract AbstractPage openPage();

    public void openPage(String pageName, String url) {
        log.info(String.format("Opening %s by %s url", pageName, url));
        open(url);
    }
}
