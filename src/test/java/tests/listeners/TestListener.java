package tests.listeners;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenshotUtils;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Log4j2
public class TestListener implements ITestListener {

    public void onTestStart(ITestResult iTestResult) {
        log.info(String.format("=========================================== STARTING TEST %s with parameters %s ===========================================",
                iTestResult.getName(), Arrays.toString(iTestResult.getParameters())));
    }

    public void onTestSuccess(ITestResult iTestResult) {
        log.info(String.format("=========================================== FINISHED TEST %s Duration: %s ===========================================",
                iTestResult.getName(),
                getExecutionTime(iTestResult)));
    }

    public void onTestFailure(ITestResult iTestResult) {
        log.error(String.format("=========================================== FAILED TEST %s Duration: %s ===========================================",
                iTestResult.getName(), getExecutionTime(iTestResult)));
        log.error(ExceptionUtils.getStackTrace(iTestResult.getThrowable()));
        log.error("Screenshot is attached");
        ScreenshotUtils.takeScreenshot();
    }

    public void onTestSkipped(ITestResult iTestResult) {
        log.error(String.format("=========================================== SKIPPING TEST %s ===========================================",
                iTestResult.getName()));
        log.error("Screenshot is attached");
        ScreenshotUtils.takeScreenshot();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    private long getExecutionTime(ITestResult iTestResult) {
        return TimeUnit.MILLISECONDS.toSeconds(iTestResult.getEndMillis() - iTestResult.getStartMillis());
    }
}
