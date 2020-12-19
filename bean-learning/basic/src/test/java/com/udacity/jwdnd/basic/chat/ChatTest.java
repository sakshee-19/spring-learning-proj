package com.udacity.jwdnd.basic.chat;

import com.udacity.jwdnd.basic.login.LoginPage;
import com.udacity.jwdnd.basic.signup.SignUpPage;
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
public class ChatTest {
    @LocalServerPort
    private Integer port;

    private static WebDriver driver;

    private ChatPage chatPage;

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeEach
    public void setUp(){
        driver.get("http://localhost:" + port );
        chatPage = new ChatPage(driver);
    }

    @AfterAll
    public static void afterAll(){
        driver.quit();
    }

    @Test
    public void testSubmitFunction() {
//        int chatMessages =
        driver.get("http://localhost:" + port+"/signup");
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.signUp("saku", "saku", "sakshee", "jain");

        driver.get("http://localhost:" + port+"/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("saku", "saku");


        driver.get("http://localhost:" + port+"/chat");
        chatPage.sendChatMessage("Hello", "SHOUT");

        System.out.println(chatPage.getChatMessage().getMessageText());
        System.out.println(chatPage.getChatMessage().getUsername());

    }
}
