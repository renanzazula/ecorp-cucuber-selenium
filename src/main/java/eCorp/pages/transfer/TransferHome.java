package eCorp.pages.transfer;

import eCorp.pages.home.DashBoard;
import eCorp.pages.transfer.self.SelfTransfer;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TransferHome extends DashBoard {

    private @FindBy(xpath = "//button[@id='transfersSelf']") WebElement transfersSelf;
    private @FindBy(xpath = "//button[@id='transfersNcb']") WebElement transfersNcb;
    private @FindBy(xpath = "//button[@id='transfersLocal']") WebElement transfersLocal;
    private @FindBy(xpath = "//button[@id='transfersInternational']") WebElement transfersInternational;
    private @FindBy(xpath = "//button[@id='transfersQp']") WebElement transfersQp;
    private @FindBy(xpath = "//button[@id='transfersInquiry']") WebElement transfersInquiry;

    public SelfTransfer getTransfersSelf() {
        waitAndClickElement(transfersSelf);
        return new SelfTransfer();
    }

    public void getTransfersNcb() {
        
    }

    public void getTransfersLocal() {
        
    }

    public void getTransfersInternational() {
        
    }

    public void getTransfersQp() {
        
    }

    public void getTransfersInquiry() {
        
    }
}
