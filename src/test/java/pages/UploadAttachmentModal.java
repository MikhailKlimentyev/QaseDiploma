package pages;

import org.openqa.selenium.By;
import pages.base.AbstractPage;

import java.io.File;

import static models.Constants.UPLOAD_ATTACHMENT_MODAL;

public class UploadAttachmentModal extends AbstractPage {

    public static final By UPLOAD_NEW_LABEL_LOCATOR = By.xpath("//*[contains(text(), 'Upload new')]");
    public static final By PLACE_TO_UPLOAD_FILE_LOCATOR = By.cssSelector("input[type='file']");

    public CreateTestCasePage uploadFile(String fileName) {
        File file = new File(String.format("src/test/resources/%s", fileName)).getAbsoluteFile();
        uploadFile(PLACE_TO_UPLOAD_FILE_LOCATOR, file);
        return new CreateTestCasePage();
    }

    @Override
    public UploadAttachmentModal isPageOpened() {
        isPageOpened(UPLOAD_NEW_LABEL_LOCATOR, UPLOAD_ATTACHMENT_MODAL);
        return this;
    }
}
