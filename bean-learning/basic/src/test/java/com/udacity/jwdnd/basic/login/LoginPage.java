package com.udacity.jwdnd.basic.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "inputUsername")
    private WebElement inputUsername;

    @FindBy(id = "inputPassword")
    private WebElement inputPassword;

    @FindBy(id = "submit-button")
    private WebElement submitButton;

    @FindBy(id = "signup-link")
    private WebElement link;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void setInputUsername(String username) {
        this.inputUsername.sendKeys(username);
    }

    public void setInputPassword(String password) {
        this.inputPassword.sendKeys(password);
    }

    public void  setLink(String linkText) {
        this.link.sendKeys(linkText);
    }

    public void clickSubmitButton() {
        this.submitButton.click();
    }
    public String getInputUsername() {
        return this.inputUsername.getText();
    }

    public String getInputPassword() {
        return this.inputPassword.getText();
    }

    public String  getLink() {
        return this.link.getText();
    }

    public void login(String username, String password) {
        this.setInputPassword(password);
        this.setInputUsername(username);
        this.clickSubmitButton();
    }
}
