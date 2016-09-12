package stepdefinition;

import com.unitedsofthouse.ucucumberpackage.tools.Waiters;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.*;
import cucumber.api.java.en.*;
import helpers.CommonHelper;
import helpers.SystemHelper;
import arp.CucumberArpReport;
import arp.ReportService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import pages.base.PageInstance;
import pages.relime.*;

import java.util.Random;

public class CommonStepDefinition extends PageInstance {

    @Autowired
    DashboardPage dashboardPage;

    @Autowired
    EditorPage editorPage;

    @Autowired
    ProfilePage profilePage;

    @Autowired
    SettingsPage settingsPage;

    @Autowired
    StatisticsPage statisticsPage;

    @Given("^I am logged in as Product Owner$")
    public void iAmLoggedInAsProductOwner() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean flag = true;
            ReportService.ReportAction("User was logged in.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    /*default = defaultProject
    sDefault = defaultSmokeProject
    rDefaultOne = defaultRegressionProjectOne
    rDefaultTwo = defaultRegressionProjectTwo*/
    @And("^I select project \"([^\"]*)\"$")
    public void iSelectProjectByURL(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            if(arg0.equals("default"))
                arg0 = SystemHelper.DEFAULTPROJECT;
            if(arg0.equals("sDefault"))
                arg0 = SystemHelper.DEFAULTSMOKEPROJECT;
            if(arg0.equals("rDefaultOne"))
                arg0 = SystemHelper.DEFAULTREGRESSIONPROJECTONE;
            if(arg0.equals("rDefaultTwo"))
                arg0 = SystemHelper.DEFAULTREGRESSIONPROJECTTWO;
            driver.navigate().to(SystemHelper.DOMAIN + arg0 + "/editor");
            ngDriver.waitForAngularRequestsToFinish();
            Thread.sleep(4000);
            CommonHelper.testProjectKey = arg0;
            ReportService.ReportAction("Project was selected.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I select feature \"([^\"]*)\" in the tree$")
    public void iSelectFeatureInTheTree(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            editorPage.selectTreeElementByName(arg0);
            Thread.sleep(1000);
            ReportService.ReportAction("'" + arg0 + "' feature was selected.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I click on button \"([^\"]*)\" on page")
    public void clickButton(String name) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Thread.sleep(1000);
            editorPage.clickButton(name);
            ReportService.ReportAction("Button '" + name + "' was clicked.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I navigate to page 'Profile'")
    public void navigateToProfilePage() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Thread.sleep(1000);
            profilePage.profileDropdownButton.click();
            boolean elementFound = false;
            for (WebElement e : profilePage.profileDropdownElements) {
                if (e.getText().equals("User Profile")) {
                    e.click();
                    elementFound = true;
                    break;
                }
            }
            Thread.sleep(4000);
            //ngDriver.waitForAngularRequestsToFinish();
            ReportService.ReportAction("Navigated to page 'Profile'", elementFound);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see a notification message \"([^\"]*)\" under \"([0-9])\" required fields on pop-up \"([^\"]*)\"")
    public void iSeeNotificationMessages(String message, int quantity, String form) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Thread.sleep(1000);
            int messages = 0;
            if (dashboardPage.formFieldWarnings != null && dashboardPage.formFieldWarnings.size() > 0) {
                if (!message.equals("")) {
                    for (Label e : dashboardPage.formFieldWarnings) {
                        if (e.isDisplayed() && e.getText().equals(message))
                            messages++;
                    }
                } else {
                    for (Label e : dashboardPage.formFieldWarnings) {
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

    @And("^I see a notification message \"([^\"]*)\" under \"([0-9])\" required fields on Editor page")
    public void iSeeNotificationMessagesUnderTheTree(String message, int quantity) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Thread.sleep(1000);
            int messages = 0;
            if (dashboardPage.EditorFieldWarnings != null && dashboardPage.EditorFieldWarnings.size() > 0) {
                if (!message.equals("")) {
                    for (Label e : dashboardPage.EditorFieldWarnings) {
                        String s = e.getText();
                        if (e.isDisplayed() && e.getText().equals(message))
                            messages++;
                    }
                } else {
                    for (Label e : dashboardPage.EditorFieldWarnings) {
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

    @And("^I am signed in")
    public void iAmSignedIn() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            if(editorPage.signInButton.isDisplayed()) {
                editorPage.signInButton.click();
                Waiters.waitAppearanceOf(5, editorPage.signInDialog.getWrappedElement());
                editorPage.signInDialogEmailField.sendKeys(SystemHelper.USERNAME);
                editorPage.signInDialogPasswordField.sendKeys(SystemHelper.PASSWORD);
                editorPage.signInDialogSignInButton.click();
                Waiters.waitAppearanceOf(10, profilePage.profileUserInfo.getWrappedElement());
            }
            ReportService.ReportAction("Signed in successfully.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Given("^I am in page \"([^\"]*)\"$")
    public void iAmInPage(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            switch (arg0) {
                case "Default":
                    try {
                        Thread.sleep(1000);
                        if (!dashboardPage.pageHeader.isDisplayed()) {
                            driver.navigate().to(SystemHelper.URL);
                            ngDriver.waitForAngularRequestsToFinish();
                            Waiters.waitAppearanceOf(CommonHelper.delay, dashboardPage.pageHeader.getWrappedElement());
                            if (dashboardPage.signInButton.isDisplayed())
                                ReportService.ReportAction("User navigated to 'Dashboard' page.", true);
                            else
                                ReportService.ReportAction("User couldn't navigate to 'Dashboard' page.", false);
                        }
                    } catch (Exception ex) {
                        ReportService.ReportAction("User couldn't navigate to 'Dashboard' page. Inner exception: " + ex.getMessage(), false);
                    }
                    break;
                case "Dashboard":
                    try {
                        if (!dashboardPage.addNewProjectButton.isDisplayed()) {
                            driver.navigate().to(SystemHelper.DOMAIN + "dashboard");
                            ngDriver.waitForAngularRequestsToFinish();
                            Waiters.waitAppearanceOf(CommonHelper.delay, dashboardPage.addNewProjectButton.getWrappedElement());
                            if (dashboardPage.addNewProjectButton.isDisplayed())
                                ReportService.ReportAction("User navigated to 'Dashboard' page.", true);
                            else
                                ReportService.ReportAction("User couldn't navigate to 'Dashboard' page.", false);
                        }
                    } catch (Exception ex) {
                        ReportService.ReportAction("User couldn't navigate to 'Dashboard' page. Inner exception: " + ex.getMessage(), false);
                    }
                    break;
                case "Statistics Page":
                    try {
                        if (!statisticsPage.generalProjectStatisticsLabel.isDisplayed()) {
                            driver.navigate().to(SystemHelper.DOMAIN + CommonHelper.testProjectKey + "/activity");
                            ngDriver.waitForAngularRequestsToFinish();
                            Waiters.waitAppearanceOf(CommonHelper.delay, statisticsPage.generalProjectStatisticsLabel.getWrappedElement());
                            if (statisticsPage.generalProjectStatisticsLabel.isDisplayed())
                                ReportService.ReportAction("User navigated to 'Statistics' page.", true);
                            else
                                ReportService.ReportAction("User couldn't navigate to 'Statistics' page.", false);
                        }
                    } catch (Exception ex) {
                        ReportService.ReportAction("User couldn't navigate to 'Statistics' page. Inner exception: " + ex.getMessage(), false);
                    }
                    break;
                case "Editor":
                    try {
                        if (!editorPage.addNewFolderButton.isDisplayed()) {
                            driver.navigate().to(SystemHelper.DOMAIN + CommonHelper.testProjectKey + "/editor");
                            ngDriver.waitForAngularRequestsToFinish();
                            Waiters.waitAppearanceOf(CommonHelper.delay, editorPage.addNewFolderButton.getWrappedElement());
                            if (editorPage.addNewFolderButton.isDisplayed())
                                ReportService.ReportAction("User navigated to 'Editor' page.", true);
                            else
                                ReportService.ReportAction("User couldn't navigate to 'Editor' page.", false);
                        }
                    } catch (Exception ex) {
                        ReportService.ReportAction("User couldn't navigate to 'Editor' page. Inner exception: " + ex.getMessage(), false);
                    }
                    break;
                case "Project Settings":
                    try {
                        if (!settingsPage.NameField.isDisplayed()) {
                            driver.navigate().to(SystemHelper.DOMAIN + CommonHelper.testProjectKey + "/settings");
                            ngDriver.waitForAngularRequestsToFinish();
                            String s = settingsPage.NameField.getText();
                            Waiters.waitAppearanceOf(5, settingsPage.NameField.getWrappedElement());
                            if (settingsPage.NameField.isDisplayed())
                                ReportService.ReportAction("User navigated to 'Settings' page.", true);
                            else
                                ReportService.ReportAction("User couldn't navigate to 'Settings' page.", false);
                        }
                    } catch (Exception ex) {
                        ReportService.ReportAction("User couldn't navigate to 'Settings' page. Inner exception: " + ex.getMessage(), false);
                    }
                    break;
                case "Feature Management":
                    try {
                        if (!editorPage.saveChangesToGit.isDisplayed()) {
                            driver.navigate().to(SystemHelper.DOMAIN + CommonHelper.testProjectKey + "/management");
                            ngDriver.waitForAngularRequestsToFinish();
                            Waiters.waitAppearanceOf(CommonHelper.delay, editorPage.saveChangesToGit.getWrappedElement());
                            if (editorPage.saveChangesToGit.isDisplayed())
                                ReportService.ReportAction("User navigated to 'Editor' page.", true);
                            else
                                ReportService.ReportAction("User couldn't navigate to 'Editor' page.", false);
                        }
                    } catch (Exception ex) {
                        ReportService.ReportAction("User couldn't navigate to 'Dashboard' page. Inner exception: " + ex.getMessage(), false);
                    }
                    break;
                default:
                    ReportService.ReportAction("No page found - '" + arg0 + "'.", false);
                    break;
            }

        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see pop up \"([^\"]*)\" is opened")
    public void popUpWindowIsOpened(String name) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(15, settingsPage.formHeader.getWrappedElement());
            boolean popupAppeared = settingsPage.formHeader.isDisplayed();
            boolean popupNameMatches = true;
            if (!name.equals("")) {
                popupNameMatches = settingsPage.formHeader.getText().toLowerCase().equals(name.toLowerCase());
            }
            ReportService.ReportAction(name + " popup window is opened.", popupAppeared && popupNameMatches);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see pop up message equals \"([^\"]*)\"")
    public void popUpMessageEquals(String message) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(3, settingsPage.formHeader.getWrappedElement());
            boolean popupAppeared = settingsPage.formHeader.isDisplayed();
            boolean popupNameMatches = settingsPage.formMessage.getText().toLowerCase().equals(message.toLowerCase());
            ReportService.ReportAction("Popup message equals'" + message + "'.", popupAppeared && popupNameMatches);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I type \"([^\"]*)\" into textbox \"([^\"]*)\" in pop-up \"([^\"]*)\"")
    public void iTypeTextIntoTextboxInPoUp(String value, String field, String popup) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Thread.sleep(500);
            if(value.equals("quote"))
                value = "\"";
            boolean elementFound = false;
            for (PlaceHolder e : dashboardPage.formFields) {
                if (e.findElement(By.xpath(dashboardPage.FormFieldName)).getText().toLowerCase().contains(field.toLowerCase())) {
                    e.findElement(By.xpath(dashboardPage.AddProjectFormFieldInput)).clear();
                    e.findElement(By.xpath(dashboardPage.AddProjectFormFieldInput)).sendKeys(value);
                    elementFound = true;
                    break;
                }
            }
            ReportService.ReportAction("Textbox '" + field + "' value was changed to '" + value + "' in pop-up '" + popup + "'.", elementFound);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I select item \"([^\"]*)\" in drop-down \"([^\"]*)\" in pop-up \"([^\"]*)\"")
    public void iSelectValueInDropdownInPoUp(String value, String field, String popup) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Thread.sleep(500);
            boolean elementFound = false;
            for (PlaceHolder e : dashboardPage.formFields) {
                if (e.findElement(By.xpath(dashboardPage.FormFieldName)).getText().toLowerCase().contains(field.toLowerCase())) {
                    e.findElement(By.xpath(dashboardPage.AddProjectFormFieldInput)).click();
                    for (WebElement listElement : e.findElements(By.xpath(dashboardPage.FormFieldDropdownElements))) {
                        String s = listElement.getText();
                        if (s.equals(value)) {
                            listElement.click();
                            elementFound = true;
                            break;
                        }
                    }
                }
            }
            ReportService.ReportAction("Dropdown '" + field + "' item '" + value + "' was selected in pop-up '" + popup + "'.", elementFound);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I click on button \"([^\"]*)\" on pop-up \"([^\"]*)\"")
    public void iClickButtonOnPopUp(String button, String popup) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Thread.sleep(1000);


            boolean buttonClicked = false;
            for (Button e : settingsPage.FormButtons) {
                String s = e.getText();
                if (s.toLowerCase().equals(button.toLowerCase())) {
                    e.click();
                    buttonClicked = true;
                }
            }
            Thread.sleep(1000);
            ReportService.ReportAction("\"" + button + "\" button was clicked", buttonClicked);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I click on 'Select All' checkbox on pop-up \"([^\"]*)\"")
    public void iClickOnSelectAllCheckboxOnPopUp(String popup) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(3, editorPage.formSelectAllCheckbox.getWrappedElement());
            editorPage.formSelectAllCheckbox.click();
            ReportService.ReportAction("'Select All' checkbox was clicked", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see success notification \"([^\"]*)\"")
    public void iSeeSuccessNotification(String text) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(15, settingsPage.successNotificationWindow.getWrappedElement());
            Thread.sleep(500);
            if (settingsPage.successNotificationWindow.isDisplayed()) {
                if (text.equals("")) {
                    ReportService.ReportAction("Notification window appeared.", true);
                } else {
                    String s = settingsPage.successNotificationWindow.getText();
                    ReportService.ReportAction("\"" + text + "\" notification window appeared.", s.equals(text));
                }
                settingsPage.successNotificationWindow.click();
            } else {
                ReportService.ReportAction("Notification window appeared.", false);
            }
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see error notification \"([^\"]*)\"")
    public void iSeeErrorNotification(String text) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(10, settingsPage.errorNotificationWindow.getWrappedElement());
            if (settingsPage.errorNotificationWindow.isDisplayed()) {
                if (text.equals("")) {
                    ReportService.ReportAction("Notification window appeared.", true);
                } else {
                    String s = settingsPage.errorNotificationWindow.getText();
                    ReportService.ReportAction("\"" + text + "\" notification window appeared.", s.equals(text));
                }
            } else {
                ReportService.ReportAction("Notification window appeared.", false);
            }
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see info notification \"([^\"]*)\"")
    public void iSeeInfoNotification(String text) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(10, settingsPage.infoNotificationWindow.getWrappedElement());
            if (settingsPage.infoNotificationWindow.isDisplayed()) {
                if (text.equals("")) {
                    ReportService.ReportAction("Notification window appeared.", true);
                } else {
                    String s = settingsPage.infoNotificationWindow.getText();
                    ReportService.ReportAction("\"" + text + "\" notification window appeared.", s.equals(text));
                }
            } else {
                ReportService.ReportAction("Notification window appeared.", false);
            }
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I navigate to URL \"([^\"]*)\"")
    public void iNavigateToURL(String url) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            driver.navigate().to(url);
            ReportService.ReportAction("Navigated to page '" + url + "' successfully.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }
}
