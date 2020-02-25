package eCorp.pages.transfer.self;

import eCorp.pages.transfer.TransferHome;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelfTransfer extends TransferHome {
    
    private @FindBy(xpath = "//div[@id='fromAccountSelector']") WebElement div_fromAccountSelector;
    
    public SelfTransfer clickAtSelector_fromAccount() {
        return new SelfTransfer();
    }
    
    
    
    
}
