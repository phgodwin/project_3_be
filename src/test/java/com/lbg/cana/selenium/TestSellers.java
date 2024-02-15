package com.lbg.cana.selenium;

import static org.junit.jupiter.api.Assertions.fail;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@TestMethodOrder(OrderAnnotation.class)

@Sql(scripts = { "classpath:canaSchema.sql",
		"classpath:canaData.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

public class TestSellers {

	private RemoteWebDriver driver;

	@LocalServerPort
	private int port;

	@BeforeEach
	void init() {
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@Test
	@Order(2)
	void testCreate() {

		this.driver.get("http://localhost:" + this.port);

		WebElement sellers = this.driver.findElement(By.cssSelector("#navbarNav > ul > li:nth-child(3) > a"));
		sellers.click();

		WebElement newFirstName = this.driver.findElement(
				By.cssSelector("#root > div > div > div:nth-child(3) > form > div:nth-child(1) > input:nth-child(2)"));
		newFirstName.sendKeys("John");

		WebElement newLastName = this.driver.findElement(
				By.cssSelector("#root > div > div > div:nth-child(3) > form > div:nth-child(1) > input:nth-child(4)"));
		newLastName.sendKeys("Doe");

		WebElement newPostcode = this.driver.findElement(
				By.cssSelector("#root > div > div > div:nth-child(3) > form > div:nth-child(1) > input:nth-child(6)"));
		newPostcode.sendKeys("AB12 3CD");

		WebElement newPhoneNumber = this.driver.findElement(
				By.cssSelector("#root > div > div > div:nth-child(3) > form > div:nth-child(2) > input:nth-child(2)"));
		newPhoneNumber.sendKeys("01233456567");

		WebElement newEmail = this.driver.findElement(
				By.cssSelector("#root > div > div > div:nth-child(3) > form > div:nth-child(2) > input:nth-child(4)"));
		newEmail.sendKeys("Doe@domain.com");

		WebElement submit = this.driver
				.findElement(By.cssSelector("#root > div > div > div:nth-child(3) > form > div:nth-child(2) > button"));
		submit.click();

		WebElement createdFirstName = this.driver.findElement(
				By.cssSelector("#root > div > div > div.col-auto > table > tbody > tr:nth-child(3) > td:nth-child(1)"));
		Assertions.assertEquals("John", createdFirstName.getText());

		WebElement createdLastName = this.driver.findElement(
				By.cssSelector("#root > div > div > div.col-auto > table > tbody > tr:nth-child(3) > td:nth-child(2)"));
		Assertions.assertEquals("Doe", createdLastName.getText());

		WebElement createdPostCode = this.driver.findElement(
				By.cssSelector("#root > div > div > div.col-auto > table > tbody > tr:nth-child(3) > td:nth-child(3)"));
		Assertions.assertEquals("AB12 3CD", createdPostCode.getText());

		WebElement createdEmail = this.driver.findElement(
				By.cssSelector("#root > div > div > div.col-auto > table > tbody > tr:nth-child(3) > td:nth-child(5)"));
		Assertions.assertEquals("Doe@domain.com", createdEmail.getText());

		WebElement createdPhoneNumber = this.driver.findElement(
				By.cssSelector("#root > div > div > div.col-auto > table > tbody > tr:nth-child(3) > td:nth-child(4)"));
		Assertions.assertEquals("01233456567", createdPhoneNumber.getText());
	}

	@Test
	@Order(1)
	void testGetSeller() {
		this.driver.get("http://localhost:" + this.port);

		WebElement sellers = this.driver.findElement(By.cssSelector("#navbarNav > ul > li:nth-child(3) > a"));
		sellers.click();

		WebElement createdFirstName = this.driver
				.findElement(By.cssSelector("#root > div > div > div.col-auto > table > tbody > tr > td:nth-child(1)"));
		Assertions.assertEquals("Mary", createdFirstName.getText());

		WebElement createdLastName = this.driver
				.findElement(By.cssSelector("#root > div > div > div.col-auto > table > tbody > tr > td:nth-child(2)"));
		Assertions.assertEquals("Davis", createdLastName.getText());

		WebElement createdPostCode = this.driver
				.findElement(By.cssSelector("#root > div > div > div.col-auto > table > tbody > tr > td:nth-child(3)"));
		Assertions.assertEquals("GL11 9AD", createdPostCode.getText());

		WebElement createdEmail = this.driver
				.findElement(By.cssSelector("#root > div > div > div.col-auto > table > tbody > tr > td:nth-child(5)"));
		Assertions.assertEquals("mary@gmail.com", createdEmail.getText());

		WebElement createdPhoneNumber = this.driver
				.findElement(By.cssSelector("#root > div > div > div.col-auto > table > tbody > tr > td:nth-child(4)"));
		Assertions.assertEquals("0345673", createdPhoneNumber.getText());
	}

	@Test
	@Order(3)
	void testDeleteSeller() throws InterruptedException {

		this.driver.get("http://localhost:" + this.port);

		WebElement sellers = this.driver.findElement(By.cssSelector("#navbarNav > ul > li:nth-child(3) > a"));
		sellers.click();

		WebElement sellerDelete = this.driver.findElement(By.cssSelector(
				"#root > div > div > div.col-auto > table > tbody > tr:nth-child(2) > td:nth-child(6) > button"));
		this.driver.executeScript("arguments[0].scrollIntoView(true);", sellerDelete);
		sellerDelete.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until((ExpectedConditions.invisibilityOfElementLocated(
				By.cssSelector("#root > div > div > div.col-auto > table > tbody > tr:nth-child(2)"))));
		try {
			this.driver
					.findElement(By.cssSelector("#root > div > div > div.col-auto > table > tbody > tr:nth-child(2)"));
			fail("Delete has failed");

		} catch (NoSuchElementException ex) {

		}

	}

//	@AfterEach
//	void tearDown() {
//		this.driver.quit();
//	}
}
