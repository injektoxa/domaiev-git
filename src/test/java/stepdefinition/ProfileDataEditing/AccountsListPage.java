package stepdefinition.ProfileDataEditing;

import com.unitedsofthouse.ucucumberpackage.tools.Waiters;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.*;
import cucumber.api.java.en.*;
import helpers.CommonHelper;
import arp.CucumberArpReport;
import arp.ReportService;
import helpers.SystemHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.*;
import org.apache.commons.lang3.math.*;
import pages.base.PageInstance;
import pages.relime.ProfilePage;
import pages.relime.SettingsPage;

import java.util.Random;

/**
 * Created by kozlov on 5/24/2016.
 */
public class AccountsListPage extends PageInstance {
    @Autowired
    SettingsPage settingsPage;

    @Autowired
    ProfilePage profilePage;

    @When("^I selected menu \"([^\"]*)\" in dropdown 'Account' at block TTS")
    public void selectMenuAtTTS(String option) throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            if(option.equals("default"))
                option = SystemHelper.DEFAULTJIRAACCOUNT;
            Waiters.waitAppearanceOf(5, settingsPage.jiraAccountDropdownButton.getWrappedElement());
            settingsPage.jiraAccountDropdownButton.click();
            Waiters.waitAppearanceOf(5, settingsPage.jiraAccountDropdownElements.get(0).getWrappedElement());
            boolean elementFound = false;
            for (Label e : settingsPage.jiraAccountDropdownElements) {
                String s = e.getText();
                if(s.equals(option)) {
                    e.click();
                    Thread.sleep(500);
                    elementFound = true;
                    break;
                }
            }
            ReportService.ReportAction("TTS action was clicked.", elementFound);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I selected menu \"([^\"]*)\" in dropdown 'Account' at block VCS")
    public void selectMenuAtVCS(String option) throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            if(option.equals("default"))
                option = SystemHelper.DEFAULTGITACCOUNT;
            Waiters.waitAppearanceOf(5, settingsPage.VCSAccountDropdownButton.getWrappedElement());
            settingsPage.VCSAccountDropdownButton.click();
            Waiters.waitAppearanceOf(5, settingsPage.VCSAccountDropdownElements.get(0).getWrappedElement());
            boolean elementFound = false;
            for (Label e : settingsPage.VCSAccountDropdownElements) {
                String s = e.getText();
                if(s.equals(option)) {
                    e.click();
                    Thread.sleep(500);
                    elementFound = true;
                    break;
                }
            }
            ReportService.ReportAction("VCS action was clicked.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I populated all required fields for new credential")
    public void iPopulatedFieldsOnPage() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Thread.sleep(1000);
            Random r = new Random();
            String acc = "TestAcc" + r.nextInt();
            profilePage.createNewCredentialForm.findElement(By.xpath(profilePage.CREDENTIALS_FORM_ACCOUNT_FIELD)).sendKeys(acc);
            CommonHelper.testAccountName = acc;
            String usr = "TestUser" + r.nextInt();
            profilePage.createNewCredentialForm.findElement(By.xpath(profilePage.CREDENTIALS_FORM_NAME_FIELD)).sendKeys(usr);
            CommonHelper.testAccountUserName = usr;
            String pass = String.valueOf(r.nextInt());
            profilePage.createNewCredentialForm.findElement(By.xpath(profilePage.CREDENTIALS_FORM_PASSWORD_FIELD)).sendKeys(pass);
            CommonHelper.testAccountPassword = pass;
            ReportService.ReportAction("All required fields were filled with data.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I populated all required fields on pop-up 'Add account'")
    public void iPopulatedFieldsOnPopUp() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(5, settingsPage.formFields.get(0).getWrappedElement());
            Random r = new Random();
            for (Element e : settingsPage.formFields) {
                if(e.findElement(By.xpath(settingsPage.FormFieldName)).getText().contains("ACCOUNT NAME")){
                    String acc = "TestAcc" + r.nextInt();
                    CommonHelper.clickWithActions(e.findElement(By.xpath(settingsPage.AddAccountFormFieldInput)));
                    e.findElement(By.xpath(settingsPage.AddAccountFormFieldInput)).sendKeys(acc);
                    CommonHelper.testAccountName = acc;
                }
                else if(e.findElement(By.xpath(settingsPage.FormFieldName)).getText().contains("USER NAME")){
                    String usr = "TestUser" + r.nextInt();
                    CommonHelper.clickWithActions(e.findElement(By.xpath(settingsPage.AddAccountFormFieldInput)));
                    e.findElement(By.xpath(settingsPage.AddAccountFormFieldInput)).sendKeys(usr);
                    CommonHelper.testAccountUserName = usr;
                }
                else if(e.findElement(By.xpath(settingsPage.FormFieldName)).getText().contains("PASSWORD")){
                    String pass = String.valueOf(r.nextInt());
                    CommonHelper.clickWithActions(e.findElement(By.xpath(settingsPage.AddAccountFormFieldInput)));
                    e.findElement(By.xpath(settingsPage.AddAccountFormFieldInput)).sendKeys(pass);
                    CommonHelper.testAccountPassword = pass;
                }
            }
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I populated not all required fields for new credential")
    public void iPopulatedNotAllFieldsOnPopUp() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(5, settingsPage.formFields.get(0).getWrappedElement());
            Random r = new Random();
            String newAcc = "TestAcc" + r.nextInt();
            String newUser = "TestUser" + r.nextInt();
            String pass = String.valueOf(r.nextInt());
            boolean atLeastOneEmpty = false;
            if(r.nextBoolean()){
                profilePage.createNewCredentialForm.findElement(By.xpath(profilePage.CREDENTIALS_FORM_ACCOUNT_FIELD)).sendKeys(newAcc);
                CommonHelper.testAccountName = newAcc;
            }
            else {
                atLeastOneEmpty = true;
            }
            if(r.nextBoolean()){
                profilePage.createNewCredentialForm.findElement(By.xpath(profilePage.CREDENTIALS_FORM_NAME_FIELD)).sendKeys(newUser);
                CommonHelper.testAccountUserName = newUser;
            }
            else {
                atLeastOneEmpty = true;
            }
            if(atLeastOneEmpty&&r.nextBoolean()){
                profilePage.createNewCredentialForm.findElement(By.xpath(profilePage.CREDENTIALS_FORM_PASSWORD_FIELD)).sendKeys(pass);
                CommonHelper.testAccountPassword = pass;
            }
            ReportService.ReportAction("Some required fields were filled with data.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see pop up \"([^\"]*)\" was closed")
    public void popUpWindowWasClosed(String name) throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitDisappearsOf(2, settingsPage.formHeader.getWrappedElement(), 0);
            if(settingsPage.formHeader.isDisplayed()){//e!=null) {
                ReportService.ReportAction("\"" + name + "\" popup window was closed.", false);
            }
            else{
                ReportService.ReportAction("\"" + name + "\" popup window was closed.", true);
            }
        } catch (NoSuchElementException e){
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see pop up \"([^\"]*)\" was not closed")
    public void popUpWindowWasNotClosed(String name) throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(5, settingsPage.formHeader.getWrappedElement());
            WebElement e = settingsPage.formHeader.findElement(By.xpath("."));
            if(e!=null) {
                ReportService.ReportAction("\"" + name + "\" popup window was not closed.", true);
            }
        } catch (NoSuchElementException e){
            ReportService.ReportAction("\"" + name + "\" popup window was not closed.", false);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }


    @And("^I see account was added to the dropdown 'Account' on TTS block")
    public void iSeeAccountWasAddedToTTS() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            if(CommonHelper.testAccountName!=null) {
                Waiters.waitAppearanceOf(5, settingsPage.jiraAccountDropdownButton.getWrappedElement());
                settingsPage.jiraAccountDropdownButton.click();
                Waiters.waitAppearanceOf(5, settingsPage.jiraAccountDropdownElements.get(0).getWrappedElement());
                boolean elementFound = false;
                for (Label e : settingsPage.jiraAccountDropdownElements) {
                    String s = e.getText();
                    if (s.equals(CommonHelper.testAccountName)) {
                        elementFound = true;
                        break;
                    }
                }
                ReportService.ReportAction("Account was added to the dropdown 'Account' on TTS block.", elementFound);
            }
            else{
                ReportService.ReportAction("No account was added.", false);
            }
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see account was added to the dropdown 'Account' on VCS block")
    public void iSeeAccountWasAddedToVCS() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            if(CommonHelper.testAccountName!=null) {
                Waiters.waitAppearanceOf(5, settingsPage.VCSAccountDropdownButton.getWrappedElement());
                settingsPage.VCSAccountDropdownButton.click();
                Waiters.waitAppearanceOf(5, settingsPage.VCSAccountDropdownElements.get(0).getWrappedElement());
                boolean elementFound = false;
                for (Label e : settingsPage.VCSAccountDropdownElements) {
                    String s = e.getText();
                    if (s.equals(CommonHelper.testAccountName)) {
                        elementFound = true;
                        break;
                    }
                }
                ReportService.ReportAction("Account was added to the dropdown 'Account' on TTS block.", elementFound);
            }
            else{
                ReportService.ReportAction("No account was added.", false);
            }
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see my account in table 'Credentials'")
    public void iSeeCreatedAccountInTable() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean elementFound = false;
            if(profilePage.findRowInAccountPanel(CommonHelper.testAccountName, CommonHelper.testAccountUserName)!=null){
                elementFound = true;
            }
            ReportService.ReportAction("Created account is in the table.", elementFound);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see account is not in the table 'Credentials'")
    public void iSeeAccountNotAddedToTheTable() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean elementFound = false;
            if(profilePage.findRowInAccountPanel(CommonHelper.testAccountName, CommonHelper.testAccountUserName)!=null){
                elementFound = true;
            }
            ReportService.ReportAction("Created account is not in the table.", !elementFound);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I have more than \"10\" accounts")
    public void iHaveEnoughAccounts() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(5, profilePage.credentialsTableRows.get(0).getWrappedElement());
            ReportService.ReportAction("There is more than 10 accounts", profilePage.accountTablePages.get(2).getText().equals("2"));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I click on button \"([^\"]*)\" on pagination panel")
    public void iClickPaginationbutton(String name) throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(5, profilePage.credentialsTableRows.get(0).getWrappedElement());
            boolean buttonFound = false;
            if(name.equals("last")){
                for (int i = 0; i < profilePage.accountTablePages.size(); i++){
                    WebElement e = profilePage.accountTablePages.get(i);
                    if (e.getText().equals("&gt;")) {
                        WebElement last = profilePage.accountTablePages.get(i - 1);
                        buttonFound = true;
                        last.click();
                        Thread.sleep(500);
                        break;
                    }
                }
            }
            else{
                for (WebElement e : profilePage.accountTablePages) {
                    if(e.getText().equals(name)){
                        buttonFound = true;
                        e.click();
                        Thread.sleep(500);
                        break;
                    }
                }
            }
            ReportService.ReportAction("Clicked on button " + name + " on pagination panel", buttonFound);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I am on the \"([^\"]*)\" page on pagination panel")
    public void iAmOnTheRightPage(String page) throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(5, profilePage.credentialsTableRows.get(0).getWrappedElement());
            boolean buttonFound = false;
            if(page.equals("last")) {
                for (int i = 0; i < profilePage.accountTablePages.size(); i++){
                    WebElement e = profilePage.accountTablePages.get(i);
                    if (e.getText().equals("&gt;")) {
                        WebElement last = profilePage.accountTablePages.get(i - 1);
                        if(NumberUtils.isNumber(last.getText()) && last.getAttribute("class").contains("active")) {
                            buttonFound = true;
                            break;
                        }
                    }
                }
            }
            else if(NumberUtils.isNumber(page)){
                for (WebElement e : profilePage.accountTablePages) {
                    if(e.getText().equals(page)){
                        buttonFound = true;
                        break;
                    }
                }
            }
            else{
                Throwable t = new Throwable("You should provide a number or 'last' as a parameter");
                throw t;
            }
            ReportService.ReportAction("Created account is in the table.", buttonFound);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I click on Create button for Credentials on Profile page$")
    public void iClickOnAddButtonOnProfilePage() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(5, profilePage.createNewCredentialButton.getWrappedElement());
            profilePage.createNewCredentialButton.click();
            ReportService.ReportAction("Add button on Profile page was clicked.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I click button 'Edit' for created account in panel 'Your accounts' in page 'User Profile'")
    public void iClickButtonEditForCreatedAccount() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean elementFound = false;
            Label row = profilePage.findRowInAccountPanel(CommonHelper.testAccountName, CommonHelper.testAccountUserName);
            if(row!=null){
                elementFound = true;
                row.click();
            }
            ReportService.ReportAction("Created account is selected for editing.", elementFound);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I click button 'Delete' for created account in panel 'Credentials' in page 'User Profile'")
    public void iClickButtonDeleteForCreatedAccount() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean elementFound = false;
            Label row = profilePage.findRowInAccountPanel(CommonHelper.testAccountName, CommonHelper.testAccountUserName);
            if(row!=null){
                elementFound = true;
                row.findElement(By.xpath(profilePage.CREDENTIALS_ROW_DELETE)).click();
            }
            ReportService.ReportAction("Created account is in the table.", elementFound);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see a notification message \"([^\"]*)\" under \"([0-9])\" required fields on Profile page")
    public void iSeeNotificationMessagesUnderTheTree(String message, int quantity) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Thread.sleep(1000);
            int messages = 0;
            if (profilePage.profileFieldWarnings != null && profilePage.profileFieldWarnings.size() > 0) {
                if (!message.equals("")) {
                    for (Label e : profilePage.profileFieldWarnings) {
                        String s = e.getText();
                        if (e.isDisplayed() && e.getText().equals(message))
                            messages++;
                    }
                } else {
                    for (Label e : profilePage.profileFieldWarnings) {
                        if (e.isDisplayed())
                            messages++;
                    }
                }
            }
            ReportService.ReportAction(quantity + "'" + message + "' notifications are displayed.", messages == quantity);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }
}
