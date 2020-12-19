package com.udacity.jwdnd.basic.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class lLoginTest {

    @LocalServerPort
    private Integer port;

    private WebDriver webDriver;

    private LoginPage loginPage;

    @BeforeAll
    public void beforeAll() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    @BeforeEach
    public void setUp() {
        webDriver.get("http://localhost:" + port + "/login");
        loginPage = new LoginPage(webDriver);
    }

    @AfterAll
    public void afterAll(){
        webDriver.quit();
    }
}
