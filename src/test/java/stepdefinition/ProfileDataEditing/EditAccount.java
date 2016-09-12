package stepdefinition.ProfileDataEditing;

import arp.CucumberArpReport;
import arp.ReportService;
import cucumber.api.java.en.When;
import helpers.CommonHelper;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import pages.base.PageInstance;
import pages.relime.ProfilePage;
import pages.relime.SettingsPage;

/**
 * Created by kozlov on 6/29/2016.
 */
public class EditAccount extends PageInstance {
    @Autowired
    SettingsPage settingsPage;

    @Autowired
    ProfilePage profilePage;

    @When("^I change textbox 'Account name' value to \"([^\"]*)\" in table 'Credentials'$")
    public void iChangeTextboxAccountNameValueToInPopupEditAccount(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            profilePage.editCredentialForm.findElement(By.xpath(profilePage.CREDENTIALS_FORM_ACCOUNT_FIELD)).clear();
            profilePage.editCredentialForm.findElement(By.xpath(profilePage.CREDENTIALS_FORM_ACCOUNT_FIELD)).sendKeys(arg0);
            CommonHelper.testAccountName = arg0;
            ReportService.ReportAction("Textbox 'Account name' value was changed in pop-up 'Edit account'.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I change textbox 'User name' value to \"([^\"]*)\" in table 'Credentials'$")
    public void iChangeTextboxUserNameValueToInPopupEditAccount(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            profilePage.editCredentialForm.findElement(By.xpath(profilePage.CREDENTIALS_FORM_NAME_FIELD)).clear();
            profilePage.editCredentialForm.findElement(By.xpath(profilePage.CREDENTIALS_FORM_NAME_FIELD)).sendKeys(arg0);
            CommonHelper.testAccountUserName = arg0;
            ReportService.ReportAction("Textbox 'User name' value was changed in pop-up 'Edit account'.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I change textbox 'Password' value to \"([^\"]*)\" in table 'Credentials'$")
    public void iChangeTextboxpasswordValueToInPopupEditAccount(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            profilePage.editCredentialForm.findElement(By.xpath(profilePage.CREDENTIALS_FORM_PASSWORD_FIELD)).clear();
            profilePage.editCredentialForm.findElement(By.xpath(profilePage.CREDENTIALS_FORM_PASSWORD_FIELD)).sendKeys(arg0);
            CommonHelper.testAccountPassword = arg0;
            ReportService.ReportAction("Textbox 'Password' value was changed in table 'Credantials'.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I click button 'Save' for edited account$")
    public void iClickButtonSaveForEditedAccount() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            profilePage.editCredentialForm.findElement(By.xpath(profilePage.CREDENTIALS_FORM_UPDATE)).click();
            Thread.sleep(1000);
            ReportService.ReportAction("Button 'Save' was clicked for edited account.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I click button 'Add' for new credential$")
    public void iClickButtonAddForNewCredential() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            profilePage.createNewCredentialForm.findElement(By.xpath(profilePage.CREDENTIALS_FORM_UPDATE)).click();
            Thread.sleep(1000);
            ReportService.ReportAction("Button 'Save' was clicked for edited account.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I click button 'Cancel' for new credential$")
    public void iClickButtonCancelForNewCredential() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            profilePage.createNewCredentialForm.findElement(By.xpath(profilePage.CREDENTIALS_FORM_CANCEL)).click();
            Thread.sleep(1000);
            ReportService.ReportAction("Button 'Save' was clicked for edited account.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }
}
