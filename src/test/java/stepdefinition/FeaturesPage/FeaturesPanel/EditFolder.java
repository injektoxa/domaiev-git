package stepdefinition.FeaturesPage.FeaturesPanel;

import com.unitedsofthouse.ucucumberpackage.tools.Waiters;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.Link;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import helpers.CommonHelper;
import arp.CucumberArpReport;
import arp.ReportService;
import org.openqa.selenium.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import pages.base.PageInstance;
import pages.relime.DashboardPage;
import pages.relime.EditorPage;

import java.awt.event.KeyEvent;

public class EditFolder extends PageInstance{
    @Autowired
    DashboardPage dashboardPage;

    @Autowired
    EditorPage editorPage;

    @Then("^I click button 'Save' for edited field under the tree$")
    public void iClickButtonSaveForEditedFieldUnderTheTree() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(CommonHelper.delay, editorPage.saveFeatureEditedFieldButton.getWrappedElement());
            editorPage.saveFeatureEditedFieldButton.click();
            ReportService.ReportAction("Button 'Save' for edited field was clicked.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I click button 'Cancel' for edited field under the tree$")
    public void iClickButtonCancelForEditedFieldUnderTheTree() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(CommonHelper.delay, editorPage.cancelEditedFieldButton.getWrappedElement());
            editorPage.cancelEditedFieldButton.click();
            ReportService.ReportAction("Button 'Cancel' for edited field was clicked.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see \"([^\"]*)\" notifiction message under current input field$")
    public void iSeeNotificationMesageUndetCurrentInputField(String message) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(5, editorPage.inputNotificationMessage.getWrappedElement());
            ReportService.ReportAction("Notification message '" + message + "' is displayed.", editorPage.inputNotificationMessage.isDisplayed()&&editorPage.inputNotificationMessage.getText().equals(message));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I click button 'Esc'$")
    public void iClickButtonEsc() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            try{
                editorPage.changeFieldAfterFocusInput.sendKeys(Keys.ESCAPE);
            }
            catch (Exception ex) {
                CommonHelper.sendKeyWithAWT(KeyEvent.VK_ESCAPE);
                ReportService.ReportAction("'Esc' button was pressed.", true);
            }
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that selected folder name equals \"([^\"]*)\"$")
    public void iSeeThatSelectedFolderNamesEquals(String message) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(5, editorPage.changeFolderNameInputBeforeFocus.getWrappedElement());
            Link folderName = editorPage.changeFolderNameInputBeforeFocus;
            /*Waiters.waitAppearanceOf(5, editorPage.getChangeFolderNameInputBeforeFocus().getWrappedElement());
            Link folderName = editorPage.getChangeFolderNameInputBeforeFocus();*/
            ReportService.ReportAction("Current folder name equals '" + message + "'.", folderName.isDisplayed()&&folderName.getText().equals(message));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }
}