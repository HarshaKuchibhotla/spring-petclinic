package org.springframework.samples.petclinic;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyUiTest {

	@Test
	public void testHomePageLoads() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://localhost:8080");
		String title = driver.getTitle();
		assertTrue(title.contains("PetClinic"));
		driver.findElement(By.xpath("//*[@id='main-navbar']/ul/li[4]")).click();
		String errorHeader = driver.findElement(By.xpath("/html/body/div/div/h2")).getText();
		assertTrue(errorHeader.contains("Something happened..."));
		driver.quit();
	}

}
