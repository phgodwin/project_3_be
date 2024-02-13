package com.lbg.cana.selenium;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.boot.test.web.server.LocalServerPort;

public class TestBuyers {

	@LocalServerPort
	private int port;

	private RemoteWebDriver driver;

	@BeforeEach
	void init() {
		this.driver = new ChromeDriver();
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@Test
	@Order(2)
	void testCreate() {
		this.driver.get("http://localhost:3000/buyers");

		WebElement newFirstName = this.driver
				.findElement(By.cssSelector("#root > div > div > div > form > div:nth-child(1) > input:nth-child(2)"));
		newFirstName.sendKeys("John");

		WebElement newLastName = this.driver
				.findElement(By.cssSelector("#root > div > div > div > form > div:nth-child(1) > input:nth-child(4)"));
		newLastName.sendKeys("Doe");

		WebElement newPostcode = this.driver
				.findElement(By.cssSelector("#root > div > div > div > form > div:nth-child(1) > input:nth-child(6)"));
		newPostcode.sendKeys("AB12 3CD");

		WebElement newPhoneNumber = this.driver
				.findElement(By.cssSelector("#root > div > div > div > form > div:nth-child(2) > input:nth-child(2)"));
		newPhoneNumber.sendKeys("01233456567");

		WebElement newEmailAddress = this.driver
				.findElement(By.cssSelector("#root > div > div > div > form > div:nth-child(2) > input:nth-child(4)"));
		newEmailAddress.sendKeys("Doe@domain.com");

		WebElement submit = this.driver
				.findElement(By.cssSelector("#root > div > div > div > form > div:nth-child(2) > button"));
		submit.click();

	}

}
