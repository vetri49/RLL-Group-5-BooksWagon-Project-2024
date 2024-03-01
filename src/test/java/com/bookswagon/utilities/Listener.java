package com.bookswagon.utilities;

import java.io.File;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class Listener implements ITestListener {
    public static WebDriver driver;
    int i=100;
    private ExtentReports extentReports;
    private ExtentTest extentTest;
    String name;
    String screenshotPath;
    
       public static void setDriver(WebDriver driver2) {
    	driver=driver2;
    }
    
       @Override
       public void onTestSkipped(ITestResult result) {
   	   
   	   extentTest = extentReports.createTest(result.getName()); 
          extentTest.log(Status.SKIP, "Test skipped: " + result.getName());
   		driver.quit();
   		
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
    	name=result.getName()+i++;
    	extentTest=extentReports.createTest(name);
        extentTest.log(Status.PASS, "Test Passed: " + name+i++);
        driver.quit();
    }
    

    @Override
    public void onTestFailure(ITestResult result) {
    	if (driver != null) {
    		 
               
                screenshotPath = takeScreenshot(name+"_"+i++);
                System.out.println("Test failure");
               
                name=result.getName()+i++;
            	extentTest=extentReports.createTest(name);
                extentTest.log(Status.FAIL, "Test Failed: " + name);
                extentTest.addScreenCaptureFromPath(screenshotPath);
               driver.quit();
    	}else {
    		System.out.println("Driver is null could not take screenshot");
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
    
    
    	
    }



