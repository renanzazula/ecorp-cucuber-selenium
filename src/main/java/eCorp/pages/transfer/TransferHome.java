package eCorp.pages.transfer;

import eCorp.pages.home.DashBoard;
import eCorp.pages.transfer.self.SelfTransfer;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TransferHome extends DashBoard {


    private @FindBy(xpath = "//div[@id='transfersSelf']") WebElement button_transfersSelf;
    
//    private @FindBy(xpath = "//button[@id='transfersNcb']") WebElement button_transfersNcb;
//    private @FindBy(xpath = "//button[@id='transfersLocal']") WebElement button_transfersLocal;
//    private @FindBy(xpath = "//button[@id='transfersInternational']") WebElement button_transfersInternational;
//    private @FindBy(xpath = "//button[@id='transfersQp']") WebElement button_transfersQp;
//    private @FindBy(xpath = "//button[@id='transfersInquiry']") WebElement button_transfersInquiry;

    public SelfTransfer clickAtOptionTransfersSelf() {
        waitAndClickElement(button_transfersSelf);
        return new SelfTransfer();
    }

    public void clickAtOptionTransfersNcb() {
        
    }

    public void clickAtOptionTransfersLocal() {
        
    }

    public void clickAtOptionTransfersInternational() {
        
    }

    public void clickAtOptionTransfersQp() {
        
    }

    public void clickAtOptionTransfersInquiry() {
        
    }
}
