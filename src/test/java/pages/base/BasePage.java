package pages.base;

import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.open;

@Log4j2
public abstract class BasePage extends AbstractPage {

    public abstract AbstractPage openPage();

    public void openPage(String pageName, String url) {
        log.info(String.format("Opening %s by %s url", pageName, url));
        open(url);
    }
}
