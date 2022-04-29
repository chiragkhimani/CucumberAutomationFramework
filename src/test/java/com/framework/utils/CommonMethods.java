package com.framework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
	
public class CommonMethods extends DriverUtils {
	
	public void takeScreenshot(String fileName) {
		TakesScreenshot ts = (TakesScreenshot) getWebDriver();

		try {
			File screenShot = ts.getScreenshotAs(OutputType.FILE);
			InputStream inputStream = new FileInputStream(screenShot);

			File outputFile = new File(fileName);
	Files
		.copy(inputStream, outputFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

			inputStream.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Unable to take screenshot");
		}
	}
	
	public void takeScreenshot2(String fileName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) getWebDriver();

			File screenShot = ts.getScreenshotAs(OutputType.FILE);
			InputStream inputStream = new FileInputStream(screenShot);

			File outputFile = new File(fileName);

			Files.copy(inputStream, outputFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

			inputStream.close();
			
	}

	public void acceptAlert() {
		getWebDriver().switchTo().alert().accept();
	}

	public void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public void selectByText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public List<WebElement> getSelectOptions(WebElement element) {
		Select select = new Select(element);
		return select.getOptions();
	}
	
	public void submitForm(WebElement webElement) {
		webElement.submit();
	}
	
	public void sendText(WebElement webElement, String text) {
		webElement.sendKeys(text);
	}
	
	public String getWebElementText(WebElement webElement) {
		return webElement.getText();
	}
	
	public WebElement getWebElement(By locator) {
		return getWebDriver().findElement(locator);
	}
	
	public WebElement getWebElementById(String id) {
		return getWebElement(By.id(id));
	}

	public WebElement getWebElementByXpath(String xpath) {
		return getWebElement(By.xpath(xpath));
	}

	public WebElement getWebElementByCssSelector(String cssSelector) {
		return getWebElement(By.cssSelector(cssSelector));
	}
	
	public List<WebElement> getWebElements(By locator) {
		return getWebDriver().findElements(locator);
	}
	
	public List<WebElement> getWebElementsById(String id) {
		return getWebElements(By.id(id));
	}

	public List<WebElement> getWebElementsByXpath(String xpath) {
		return getWebElements(By.xpath(xpath));
	}

	public List<WebElement> getWebElementsByCssSelector(String cssSelector) {
		return getWebElements(By.cssSelector(cssSelector));
	}
	
	public void waitForElementToPresent(WebElement element) {
		WebDriverWait wait = new WebDriverWait(getWebDriver(), 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	

	
}
