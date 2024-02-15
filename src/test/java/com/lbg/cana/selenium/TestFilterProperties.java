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

public class TestFilterProperties {

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
	void filterPropTest() {

		this.driver.get("http://localhost:" + this.port);

		WebElement properties = this.driver.findElement(By.cssSelector("#navbarNav > ul > li:nth-child(4) > a"));
		properties.click();

		WebElement garden = this.driver.findElement(By.cssSelector(
				"#root > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div:nth-child(3) > select"));
		garden.click();

		WebElement gardenOptions = this.driver.findElement(By.cssSelector(
				"#root > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div:nth-child(3) > select > option:nth-child(3)"));
		gardenOptions.click();

		WebElement gardenSelected = this.driver.findElement(By.cssSelector(
				"#root > div > div > div > div:nth-child(3) > div > div.row.row-cols-4.g-4.mt-1 > div > div > div > div > ul > li:nth-child(4)"));
		Assertions.assertEquals("No", gardenSelected.getText());

	}
}
