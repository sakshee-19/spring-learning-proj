package com.udacity.jwdnd.basic.chat;

import com.udacity.jwdnd.basic.db.ChatMessage;
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

    @FindBy(className = "chatMessages")
    private WebElement chatMessages;

    @FindBy(className = "chatMessageUsername")
    private WebElement chatMessageUsername;

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

    public void sendChatMessage(String msg, String type) {
        this.setMessageText(msg);
        this.setMessageType(type);
        this.submitForm();
    }

    public ChatMessage getChatMessage() {
        ChatMessage cm = new ChatMessage();
        cm.setMessageText(chatMessages.getText());
        cm.setUsername(chatMessageUsername.getText());
        return cm;
    }
}
