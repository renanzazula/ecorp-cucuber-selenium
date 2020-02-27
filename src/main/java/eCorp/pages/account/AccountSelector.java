package eCorp.pages.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSelector extends AccountPage {

    private @FindBy(xpath = "//div[@id='fromAccountSelector']") WebElement fromAccountSelector;
    private @FindBy(xpath = "//div[@id='']") WebElement fromAccountOption;
    private @FindBy(xpath = "//div[@id='toAccountSelector']") WebElement toAccountSelector;
    private @FindBy(xpath = "//div[@id='']") WebElement toAccountOption;

    public AccountSelector clickAtSelector_fromAccount() {
        waitAndClickElement(fromAccountSelector);
        return new AccountSelector();
    }

    public AccountSelector selected_fromAccountOption(String fromAccount) {
        // find account and click
        // clickOnTextFromDropdownList();  
        return new AccountSelector();
    }

    public AccountSelector clickAtSelector_ToAccount() {
        waitAndClickElement(toAccountSelector);
        return new AccountSelector();
    }

    public AccountSelector selected_toAccountOption(String toAccount) {
        // find account and click
        return new AccountSelector();
    }

}
