package com.lbg.cana.selenium;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@TestMethodOrder(OrderAnnotation.class)

@Sql(scripts = { "classpath:canaSchema.sql",
		"classpath:canaData.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class TestProperties {

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
	@Order(1)
	void editPropTest() {

		this.driver.get("http://localhost:" + this.port);

		WebElement properties = this.driver.findElement(By.cssSelector("#navbarNav > ul > li:nth-child(4) > a"));
		properties.click();

		WebElement edit = this.driver.findElement(By.cssSelector(
				"#root > div > div > div > div:nth-child(3) > div > div.row.row-cols-4.g-4.mt-1 > div > div > div > div > button.btn.btn-primary"));
		this.driver.executeScript("arguments[0].scrollIntoView(true);", edit);
//		edit.click();
		this.driver.executeScript("arguments[0].click();", edit);
		WebElement price = this.driver.findElement(By.cssSelector("#price"));
		price.sendKeys("400000");

		WebElement submit = this.driver
				.findElement(By.cssSelector("#root > div > form > div > div:nth-child(2) > button"));
		submit.click();

		WebElement checkPrice = this.driver.findElement(By.cssSelector(
				"#root > div > div > div > div:nth-child(3) > div > div.row.row-cols-4.g-4.mt-1 > div > div > div > h5"));
		Assertions.assertEquals("Price: £400000", checkPrice.getText());
	}

	@Test
	@Order(2)
	void editFieldsTest() {

		this.driver.get("http://localhost:" + this.port);

		WebElement properties = this.driver.findElement(By.cssSelector("#navbarNav > ul > li:nth-child(4) > a"));
		properties.click();

		WebElement edit = this.driver.findElement(By.cssSelector(
				"#root > div > div > div > div:nth-child(3) > div > div.row.row-cols-4.g-4.mt-1 > div > div > div > div > button.btn.btn-primary"));
		this.driver.executeScript("arguments[0].scrollIntoView(true);", edit);
//		edit.click();
		this.driver.executeScript("arguments[0].click();", edit);
		WebElement price = this.driver.findElement(By.cssSelector("#price"));
		price.sendKeys("400000");

		WebElement submit = this.driver
				.findElement(By.cssSelector("#root > div > form > div > div:nth-child(2) > button"));
		submit.click();

		WebElement checkPrice = this.driver.findElement(By.cssSelector(
				"#root > div > div > div > div:nth-child(3) > div > div.row.row-cols-4.g-4.mt-1 > div > div > div > h5"));
		Assertions.assertEquals("Price: £400000", checkPrice.getText());

		WebElement checkLocation = this.driver.findElement(By.cssSelector(
				"#root > div > div > div > div:nth-child(3) > div > div.row.row-cols-4.g-4.mt-1 > div > div > div > div > ul > li:nth-child(1)"));
		Assertions.assertEquals("Location: Tenby", checkLocation.getText());
	}

}
