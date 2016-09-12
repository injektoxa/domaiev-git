package stepdefinition.JiraImplementation;

import arp.CucumberArpReport;
import arp.ReportService;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.CommonHelper;
import helpers.SystemHelper;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import pages.base.PageInstance;
import pages.relime.DashboardPage;
import pages.relime.EditorPage;
import pages.relime.GitHubPage;
import pages.relime.SettingsPage;

/**
 * Created by kozlov on 7/7/2016.
 */
public class JiraEditorPageImplementation extends PageInstance {

    @Autowired
    EditorPage editorPage;

    @Then("^I see that button 'Upload from Jira' is disabled")
    public void iSeeThatButtonUploadFromJiraIsDisabled() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Button 'Upload from Jira' is disabled.", editorPage.updateFromJira.getAttribute("class").contains("disabled"));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that button 'Upload from Jira' is enabled")
    public void iSeeThatButtonUploadFromJiraIsEnabled() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Button 'Upload from Jira' is enabled.", !editorPage.updateFromJira.getAttribute("class").contains("disabled"));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that checkbox 'Jira linked' is disabled")
    public void iSeeThatCheckboxJiraLinkedIsDisabled() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Chackbox 'Jira linked' is disabled.", editorPage.jiraLinkedFeatureCheckbox.getAttribute("disabled")!=null);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that checkbox 'Jira linked' is enabled")
    public void iSeeThatCheckboxJiraLinkedIsEnabled() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Chackbox 'Jira linked is enabled.", editorPage.jiraLinkedFeatureCheckbox.getAttribute("disabled")==null);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that checkbox 'Jira linked' tooltip equals \"([^\"]*)\"")
    public void iSeeThatCheckboxJiraLinkedTooltipEquals(String tooltip) throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            String elementTooltip = editorPage.jiraLinkedFeatureCheckbox.findElement(By.xpath("./parent::label")).getAttribute("data-uib-tooltip");
            ReportService.ReportAction("Chackbox 'Jira linked is enabled.", elementTooltip.toLowerCase().equals(tooltip.toLowerCase()));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I click checkbox 'Jira-linked' in pop-up 'New feature'$")
    public void iClickCheckboxJiraLinkedInPopUpNewFeature() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            editorPage.checkJiraLinkedFeatureCheckbox();
            ReportService.ReportAction("'Jira-linked feature' checkbox was clicked", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I type \"([^\"]*)\" into textbox 'Jira-key' in pop-up 'New feature'$")
    public void iTypeIntoTextboxJiraKeyInPopUpNewFeature(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            SystemHelper.waitAppearanceByElement(driver, 30, 100, editorPage.jiraKeyNameInput.getWrappedElement());
            editorPage.jiraKeyNameInput.enterText(arg0);
            editorPage.newFeatureLabel.click();
            Thread.sleep(500);
            ReportService.ReportAction("Data was loaded successfully.", editorPage.verifyCreateJiraLinkedFeaturePopup());
            CommonHelper.testJiraLinkedFeatureFilename = arg0;
            CommonHelper.testJiraLinkedFeatureName = "Auto test feature";
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }
}
