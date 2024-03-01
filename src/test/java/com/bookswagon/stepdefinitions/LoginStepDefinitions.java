package com.bookswagon.stepdefinitions;


import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.bookswagon.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions {
	private static final Logger logger = LogManager.getLogger(LoginStepDefinitions.class);
	int i=2;
	WebDriver driver;
	LoginPage loginPage;
	SharedSteps sp;

	public LoginStepDefinitions(SharedSteps sp) {
		this.sp=sp;
		this.loginPage=new LoginPage(sp.getDriver());

	}


	@Given("click on the URL of bookswagon website")
	public void click_on_the_url_of_bookswagon_website() {
		logger.info("click on the URL of bookswagon website");	
		loginPage.navigateToURL("https://www.bookswagon.com");
	}

	@Then("user clicks on myaccount option")
	public void user_clicks_on_myaccount_option() {
		logger.info("user clicks on myaccount option");
		loginPage.MyAccount();
	}
	@When("User enters credentials from Excel sheet")
	public void user_enters_credentials_from_excel_sheet() {
		
		
        String excelFilePath = "C:\\Practice Excerise\\RLL-Group-5-BooksWagon\\src\\test\\resources\\LoginData.xlsx";
        String sheetName = "TestData";

        int rowCount = getRowCount(excelFilePath, sheetName);

        for (int rowNumber = 2; rowNumber <= rowCount; rowNumber++) {
            String username = readFromExcel(excelFilePath, sheetName, rowNumber, "username");
            String password = readFromExcel(excelFilePath, sheetName, rowNumber, "password");

            loginPage.EntermobileNumber(username);
            loginPage.EnterPassword(password);
            
            // Add other steps or assertions as needed
        }
        

	}
	
	@When("User enters valid credentials from Excel sheet")
	public void user_enters_valid_credentials_from_excel_sheet() {
	    String excelFilePath = "C:\\Practice Excerise\\RLL-Group-5-BooksWagon\\src\\test\\resources\\LoginData.xlsx";
	    String sheetName = "TestData";

	    int rowCount = getRowCount(excelFilePath, sheetName);

	    // Assuming there is only one set of valid credentials in this example
	    int rowNumber = 2;

	    String username = readFromExcel(excelFilePath, sheetName, rowNumber, "username");
	    String password = readFromExcel(excelFilePath, sheetName, rowNumber, "password");

        loginPage.EntermobileNumber(username);
        loginPage.EnterPassword(password);
	}

	@When("User enters invalid credentials from Excel sheet")
	public void user_enters_invalid_credentials_from_excel_sheet() {
	    String excelFilePath = "C:\\Practice Excerise\\RLL-Group-5-BooksWagon\\src\\test\\resources\\LoginData.xlsx";
	    String sheetName = "TestData";

	    // Assuming there is only one set of invalid credentials in this example
	    int rowNumber = 3;

	    String username = readFromExcel(excelFilePath, sheetName, rowNumber, "username");
	    String password = readFromExcel(excelFilePath, sheetName, rowNumber, "password");

        loginPage.EntermobileNumber(username);
        loginPage.EnterPassword(password);
	}
	public  int getRowCount(String filePath, String sheetName) {
        try (FileInputStream file = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(file)) {

            Sheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new RuntimeException("Sheet '" + sheetName + "' not found in the Excel workbook.");
            }

            return sheet.getPhysicalNumberOfRows();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading from Excel file.", e);
        }
    }

	

	@When("the User press on the login button")
	public void the_user_press_on_the_login_button() throws InterruptedException {
		logger.info("the User press on the login button");
		loginPage.ClickOnLoginButton();
		Thread.sleep(2000);
	}

	
	
	
	@Then("the user should be successfully logged in")
	public void the_user_should_be_successfully_logged_in() {
		loginPage.successfulLogin();
		
	    
	}

	@Then("the user should see an error message for wrong password\\/wrong username")
	public void the_user_should_see_an_error_message_for_wrong_password_wrong_username() {
		logger.info("User should see an error message for wrong password/wrong username");
		
		loginPage.getWrongPasswordErrorMessage();
		   
	}
	
	private String readFromExcel(String filePath, String sheetName, int rowNumber, String columnName) {
	    try {
	        FileInputStream file = new FileInputStream(filePath);
	        Workbook workbook = WorkbookFactory.create(file);

	        // Verify that the sheet exists
	        Sheet sheet = workbook.getSheet(sheetName);
	        if (sheet == null) {
	            throw new RuntimeException("Sheet '" + sheetName + "' not found in the Excel workbook.");
	        }

	        Row row = sheet.getRow(rowNumber - 1);
	        if (row == null) {
	            throw new RuntimeException("Row " + rowNumber + " not found in the sheet.");
	        }

	        Cell cell = row.getCell(getColumnIndex(sheet, columnName));
	        return cell.toString();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return null;
	}


	    private int getColumnIndex(Sheet sheet, String columnName) {
	        Row headerRow = sheet.getRow(0);
	        for (Cell cell : headerRow) {
	            if (cell.getStringCellValue().equalsIgnoreCase(columnName)) {
	                return cell.getColumnIndex();
	            }
	        }
	        return -1; // return -1 if the column is not found
	    }

}
