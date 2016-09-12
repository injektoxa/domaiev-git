package stepdefinition.FeaturesPage.FeaturesPanel;

import com.unitedsofthouse.ucucumberpackage.tools.Waiters;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.CommonHelper;
import arp.CucumberArpReport;
import arp.ReportService;
import org.openqa.selenium.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import pages.base.PageInstance;
import pages.relime.DashboardPage;
import pages.relime.EditorPage;

import java.awt.event.KeyEvent;

public class CreateNewFolder extends PageInstance{

    @Autowired
    EditorPage editorPage;

    @When("^I type \"([^\"]*)\" into textbox 'Name' in pop-up 'New folder'$")
    public void iTypeIntoTextboxNameInPopUpNewFolder(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            CommonHelper.testFolderName = arg0;
            editorPage.folderNameInput.enterText(arg0);
            ReportService.ReportAction("'" + arg0 + "' is set to the field 'Name' in pop-up 'New folder'.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that new folder is successfully created$")
    public void iSeeThatNewFolderIsSuccessfullyCreated() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitWhileConditionIsTrue(CommonHelper.delay, editorPage.firstTreeNode.isDisplayed());
            ReportService.ReportAction("Folder was created.", editorPage.treeElementExists(CommonHelper.testFolderName));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that the new folder is selected in the tree$")
    public void iSeeThatTheNewFolderIsSelectedInTheTree() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Folder was selected.", editorPage.verifyIfTreeElementIsSelected(CommonHelper.testFolderName));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I click button 'New folder' in panel 'Features'$")
    public void iClickButtonNewFolderInPanelFeatures() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(10, editorPage.addNewFolderButton.getWrappedElement());
            editorPage.addNewFolderButton.click();
            ReportService.ReportAction("Button 'New folder' in panel 'Features' was clicked.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }
}