package eCorp.environment.mobile.pages.transfer.self;

import eCorp.environment.mobile.pages.transfer.TransferHome;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelfTransfer extends TransferHome {
    
    private @FindBy(xpath = "//input[@id='amountInput']") WebElement amount;
    private @FindBy(xpath = "//input[@id='instructions']") WebElement instructions;
    private @FindBy(xpath = "//button[@id='proceedOwnTransferButton']") WebElement proceedButton;
    private @FindBy(xpath = "//button[@id='yetAnotherOwnTransferButton']") WebElement addButton;
    
    public SelfTransfer setAmount(String amount){
        sendKeysToWebElement(this.amount, amount);
        return new SelfTransfer();
    }

    public SelfTransfer setInstructions(String instructions){
        sendKeysToWebElement(this.instructions, instructions);
        return new SelfTransfer();
    }

    public SelfTransfer clickAtButtonProceed() {
        waitAndClickElement(proceedButton);
        return new SelfTransfer();
    }

    public SelfTransfer clickAtButtonAdd() {
        waitAndClickElement(addButton);
        return new SelfTransfer();
    }
}
