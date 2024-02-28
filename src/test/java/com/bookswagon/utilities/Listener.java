package com.bookswagon.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Listener implements ITestListener {
    public static WebDriver driver;
    private int i = 1;
    private ExtentReports extentReports;
    private ExtentTest extentTest;
    private AssertionError assertionError;
    String value=" ";
    String screenshotPath;
    
    public static void setDriver(WebDriver driver2) {
    	driver=driver2;
    }
    @Override
    public void onStart(ITestContext context) {
        // Initialize ExtentReports
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent-report.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
        extentReports.setSystemInfo("Host Name", System.getProperty("user.name"));
        extentReports.setSystemInfo("Browser", "Chrome");
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Log success status in ExtentReports
    	screenshotPath = takeScreenshot("Passed" + i++);
        System.out.println("Test passed");
    	extentTest = extentReports.createTest(result.getName());
        extentTest.log(Status.PASS, "Test Passed: " + result.getName());
    }
    

    @Override
    public void onTestFailure(ITestResult result) {
        if (driver != null) {
        	 screenshotPath = takeScreenshot("Failure" + i++);
             System.out.println("Test failure");
         // Attach screenshot to the report
            extentTest = extentReports.createTest(result.getName()); // Create a new test in the report
            extentTest.log(Status.FAIL, "Test Failed: " + result.getName());
            extentTest.addScreenCaptureFromPath(screenshotPath);
            
        } else {
            System.out.println("Driver is null. Cannot take screenshot.");
        }
        
       
    }

    public String takeScreenshot(String fileName) {
        if (driver == null) {
            System.out.println("Driver is null. Cannot take screenshot.");
            return "";
        }

        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
            String destinationPath = "screenshots/" + fileName + ".png";

            Files.createDirectories(Path.of("screenshots"));

            if (sourceFile.exists()) {
                Files.copy(sourceFile.toPath(), new File(destinationPath).toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Screenshot captured: " + destinationPath);
                return destinationPath; // Return the path of the captured screenshot
            } else {
                System.out.println("Source file not found. Cannot copy screenshot.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }

        return fileName;
    }
    
    public void take() {
    	if(value.equals("takeScreenshot")) {
    		

            
    	}
    }


}
