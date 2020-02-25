package eCorp.pages.transfer;

import eCorp.pages.home.DashBoard;
import eCorp.pages.transfer.inquiry.TransferInquiry;
import eCorp.pages.transfer.international.InternationalTransfer;
import eCorp.pages.transfer.local.LocalTransfer;
import eCorp.pages.transfer.ncb.NcbTransfer;
import eCorp.pages.transfer.quick.QuickPayTransfer;
import eCorp.pages.transfer.self.SelfTransfer;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TransferHome extends DashBoard {

    private @FindBy(xpath = "//div[@id='transfersSelf']") WebElement selfTransfers;
    private @FindBy(xpath = "//div[@id='transfersNcb']") WebElement ncbTransfer;
    private @FindBy(xpath = "//div[@id='transfersLocal']") WebElement localTransfers;
    private @FindBy(xpath = "//div[@id='transfersInternational']") WebElement internationalsTransfers;
    private @FindBy(xpath = "//div[@id='transfersQp']") WebElement quickPayTransfers;
    private @FindBy(xpath = "//div[@id='transfersInquiry']") WebElement transfersInquiry;

    public SelfTransfer clickAtOptionTransfersSelf() {
        waitAndClickElement(selfTransfers);
        return new SelfTransfer();
    }

    public NcbTransfer clickAtOptionNcbTransfer() {
        waitAndClickElement(ncbTransfer);
        return new NcbTransfer();
    }

    public LocalTransfer clickAtOptionLocalTransfers() {
        waitAndClickElement(localTransfers);
        return new LocalTransfer();
    }

    public InternationalTransfer clickAtOptionInternationalTransfers() {
        waitAndClickElement(internationalsTransfers);
        return new InternationalTransfer();
    }

    public QuickPayTransfer clickAtOptionQuickPayTransfers() {
        waitAndClickElement(quickPayTransfers);
        return new QuickPayTransfer();
    }

    public TransferInquiry clickAtOptionTransfersInquiry() {
        waitAndClickElement(transfersInquiry);
        return new TransferInquiry();
    }
}
