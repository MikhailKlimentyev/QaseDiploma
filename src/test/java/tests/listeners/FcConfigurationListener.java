package tests.listeners;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.IConfigurationListener;
import org.testng.ITestResult;
import utils.ScreenshotUtils;

@Log4j2
public class FcConfigurationListener implements IConfigurationListener {

    @Override
    public void onConfigurationSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onConfigurationFailure(ITestResult iTestResult) {
        log.error(String.format("Configuration method %s has failed with the exception %s",
                iTestResult.getMethod(), ExceptionUtils.getStackTrace(iTestResult.getThrowable())));
        log.error("Screenshot is attached");
        ScreenshotUtils.takeScreenshot();
    }

    @Override
    public void onConfigurationSkip(ITestResult iTestResult) {

    }
}
