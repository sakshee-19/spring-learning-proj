package com.udacity.jwdnd.basic.signup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SignUpTest {

    @LocalServerPort
    private Integer port;

    private static WebDriver webDriver;

    private SignUpPage signUpPage;

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    @BeforeEach
    public void setUp() {
        webDriver.get("http://localhost:" + port + "/signup");
        signUpPage = new SignUpPage(webDriver);
    }

    @AfterAll
    public static void endTest() {
        webDriver.quit();
    }

    @Test
    public void testSuccess() {
        signUpPage.setInputFirstName("sakshee");
        signUpPage.setInputLastName("jain");
        signUpPage.setInputUsername("s");
        signUpPage.setInputPassword("s");

        signUpPage.clickSubmitButton();

       try {
           System.out.println(signUpPage.getSuccessMsg());

           System.out.println(signUpPage.getErrorMsg());
       } catch (Exception e) {
           System.out.println(e);
       }
    }

}
