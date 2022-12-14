import org.junit.Assert;
import org.junit.Test;

public class manager_test {

    @Test
    public void sanity() {
        String url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
        Bank manager = new Bank();
        manager.driver.get(url);
        Assert.assertEquals(url, manager.driver.getCurrentUrl());
        manager.driver.quit();
    }

    @Test
    public void manager_login() throws InterruptedException {
        String expected = "4447012";
        String url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
        //selectors
        String bank_manager_login_selector = "body > div > div > div.ng-scope > div > div.borderM.box.padT20 > div:nth-child(3) > button";
        String add_customer_selector = "body > div > div > div.ng-scope > div > div.center > button:nth-child(1)";
        String first_name_selector = "body > div > div > div.ng-scope > div > div.ng-scope > div > div > form > div:nth-child(1) > input";
        String last_name_selector = "body > div > div > div.ng-scope > div > div.ng-scope > div > div > form > div:nth-child(2) > input";
        String code_name_selector = "body > div > div > div.ng-scope > div > div.ng-scope > div > div > form > div:nth-child(3) > input";
        String add_customer_Button_selector = "body > div > div > div.ng-scope > div > div.ng-scope > div > div > form > button";
        String old_customer_selector = "body > div > div > div.ng-scope > div > div.center > button:nth-child(3)";
        //inputs
        String first_name_input = "Omri";
        String last_name_input = "Eden";
        String code_name_input = "4447012";

        Bank manager = new Bank();
        manager.driver.get(url);
            manager.driver.manage().window().maximize();
        Thread.sleep(1000);
        manager.getElement(bank_manager_login_selector).click();
        Thread.sleep(1000);
        manager.getElement(add_customer_selector).click();
        Thread.sleep(1000);
        manager.getElement(first_name_selector).sendKeys(first_name_input);
        Thread.sleep(1000);
        manager.getElement(last_name_selector).sendKeys(last_name_input);
        Thread.sleep(1000);
        manager.getElement(code_name_selector).sendKeys(code_name_input);
        Thread.sleep(1000);
        manager.getElement(add_customer_Button_selector).click();
        Thread.sleep(1000);
        manager.driver.switchTo().alert().accept();
        Thread.sleep(1000);
        manager.getElement(old_customer_selector).click();
        Thread.sleep(1000);

        String acctualvalue = manager.getElement("body > div > div > div.ng-scope > div > div.ng-scope > div > div > table > tbody > tr:nth-child(6) > td:nth-child(3)").getText();
        Assert.assertEquals(expected, acctualvalue);
    }

    @Test
    public void new_account() throws InterruptedException {
        String expected1 = "Dollar";
        String expected2 = "1016";
        String url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
        //selectors
        String bank_manager_login_selector = "body > div > div > div.ng-scope > div > div.borderM.box.padT20 > div:nth-child(3) > button";
        String open_account_selector = "body > div > div > div.ng-scope > div > div.center > button:nth-child(2)";
        String customer_selector = "#userSelect";
        String currency_selector = "#currency";
        String process_button_selector = "body > div > div > div.ng-scope > div > div.ng-scope > div > div > form > button";
        String home_button_selector = "body > div > div > div.box.mainhdr > button.btn.home";
        String customer_login_button_selector = "body > div > div > div.ng-scope > div > div.borderM.box.padT20 > div:nth-child(1) > button";
        String your_name_selector = "#userSelect > option:nth-child(5)";
        String login_button_selector = "body > div > div > div.ng-scope > div > form > button";
        //user choice
        String customer_name_choice = "#userSelect > option:nth-child(5)";
        String currency_choice = "#currency > option:nth-child(2)";


        Bank manager = new Bank();
        manager.driver.get(url);
        manager.driver.manage().window().maximize();
        Thread.sleep(2000);
        manager.getElement(bank_manager_login_selector).click();
        Thread.sleep(2000);
        manager.getElement(open_account_selector).click();
        Thread.sleep(2000);
        manager.getElement(customer_selector).click();
        Thread.sleep(2000);
        manager.getElement(customer_name_choice).click();
        Thread.sleep(2000);
        manager.getElement(currency_choice).click();
        Thread.sleep(2000);
        manager.getElement(process_button_selector).click();
        Thread.sleep(2000);
        manager.driver.switchTo().alert().accept();
        Thread.sleep(2000);
        manager.getElement(home_button_selector).click();
        Thread.sleep(2000);
        manager.getElement(customer_login_button_selector).click();
        Thread.sleep(2000);
        manager.getElement(your_name_selector).click();
        Thread.sleep(2000);
        manager.getElement(login_button_selector).click();
        Thread.sleep(2000);
        String acctualvalue1 = manager.getElement("body > div > div > div.ng-scope > div > div:nth-child(3) > strong:nth-child(3)").getText();
        String acctualvalue2 = manager.getElement("#accountSelect > option:nth-child(4)").getText();
        Assert.assertEquals(expected1,acctualvalue1);
        Assert.assertEquals(expected2,acctualvalue2);
    }
}


