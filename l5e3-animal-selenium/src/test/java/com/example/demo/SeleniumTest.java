package com.example.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8000/animal");

        WebElement animalText = driver.findElement(By.id("animalText"));
        WebElement adjective = driver.findElement(By.id("adjective"));
        animalText.sendKeys("parrot");
        adjective.sendKeys("green");

        for (int i=0; i<4; ++i){
            WebElement submit = driver.findElement(By.tagName("form"));
            submit.submit();
            Thread.sleep(100);
        }

        Thread.sleep(50000);
        driver.quit();
        
    }
}
