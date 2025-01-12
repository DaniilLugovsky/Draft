package utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.util.UUID;

public class InvokedListener implements IInvokedMethodListener {

    public void afterInvocation(IInvokedMethod method, ITestResult result) {
        //System.out.println("This method is invoked after every config method - " + method.getTestMethod().getMethodName());

        if (result.getStatus() == ITestResult.FAILURE) {
            ITestContext iTestContext = result.getTestContext();
            WebDriver driver = (WebDriver) iTestContext.getAttribute("webdriver");

            try {
                Allure.addAttachment(UUID.randomUUID().toString(),
                        new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            } catch (NoSuchSessionException ex) {

            }
        }
    }
}
