package eCorp.environment.desktop.pages.pos.posStatements;

import eCorp.environment.desktop.pages.pos.PosHome;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class POSStatements extends PosHome {

   private @FindBy(xpath = "//div[@data-value='00110753000104']") WebElement account;
   private @FindBy(xpath = "// button[@id='accountSelectorMultiple_done']") WebElement doneButton;

    public POSStatements select_account() {
        waitAndClickElement(account);
        return new POSStatements();
    }

    public POSStatements clickAtButton_done() {
        waitAndClickElement(doneButton);   
        return new POSStatements();
    }
    
    // all filter 
    // accountSelectorMultiple
    // done button 
    // retailerId
    // terminalId
    // cardType
    // periodCombo
    // dateFrom
    // reconciliationDateTo
    // settled
    // sortBy
    // amountFrom
    // amountTo
    // sequenceNumber
    // authorizationNumber
    
    // search button 
    // searchFilter
    
    // table list 
        // tableContent
        // table colluns 
        // - Term. Id
        // - Sequence
        // - Authoriz.
        // - Card Type
        // - Card Number
        // - Tx date
        // - Recon. Date
        // - Rec. Time
        // - Fees
        // - Amount
    
    // export list buttons
    // genericPd4mlLinkfalse
    // genericXlsLinkfalse
    // genericMailLinkfalse
    // genericPd4HtmlLinkfalse
    
}
