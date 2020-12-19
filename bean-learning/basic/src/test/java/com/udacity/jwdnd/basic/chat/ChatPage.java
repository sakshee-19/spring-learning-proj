package com.udacity.jwdnd.basic.chat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChatPage {
    @FindBy(id = "messageText")
    private WebElement messageText;

    @FindBy(id = "messageType")
    private WebElement messageType;

    @FindBy(tagName = "form")
    private WebElement userProfileForm;

    public ChatPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void submitForm() {
        userProfileForm.submit();
    }

    public void setMessageText(String message) {
        messageText.sendKeys(message);
    }

    public void setMessageType(String type) {
        messageType.sendKeys(type);
    }

    public String getMessageText(){
        return messageText.getText();
    }

    public String getMessageType(){
        return messageType.getText();
    }
}
