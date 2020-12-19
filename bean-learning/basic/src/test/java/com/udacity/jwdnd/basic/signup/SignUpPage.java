package com.udacity.jwdnd.basic.signup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

    @FindBy(id = "inputFirstName")
    private WebElement inputFirstName;

    @FindBy(id = "inputLastName")
    private WebElement inputLastName;

    @FindBy(id = "inputUsername")
    private WebElement inputUsername;

    @FindBy(id = "inputPassword")
    private WebElement inputPassword;

    @FindBy(id = "submit-button")
    private WebElement submitButton;

    @FindBy(id = "success-msg")
    private WebElement successMsg;

    @FindBy(id = "error-msg")
    private WebElement errorMsg;

    public SignUpPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public String getInputFirstName() {
        return inputFirstName.getText();
    }

    public void setInputFirstName(String inputFirstName) {
        this.inputFirstName.sendKeys(inputFirstName);
    }

    public String getInputLastName() {
        return inputLastName.getText();
    }

    public void setInputLastName(String inputLastName) {
        this.inputLastName.sendKeys(inputLastName);
    }

    public String getInputUsername() {
        return inputUsername.getText();
    }

    public void setInputUsername(String inputUsername) {
        this.inputUsername.sendKeys(inputUsername);
    }

    public String getInputPassword() {
        return inputPassword.getText();
    }

    public void setInputPassword(String inputPassword) {
        this.inputPassword.sendKeys(inputPassword);
    }

    public void clickSubmitButton() {
        this.submitButton.submit();
    }

    public String getSuccessMsg() {
        return successMsg.getText();
    }

    public void setSuccessMsg(String successMsg) {
        this.successMsg.sendKeys(successMsg);
    }

    public String getErrorMsg() {
        return errorMsg.getText();
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg.sendKeys(errorMsg);
    }

    public void signUp(String username, String password, String firstname, String lastname) {
        this.setInputUsername(username);
        this.setInputPassword(password);
        this.setInputLastName(lastname);
        this.setInputFirstName(firstname);

        this.clickSubmitButton();
    }
}
