package stepdefinition.ProjectDataEditing.ProjectSettings;

import arp.CucumberArpReport;
import arp.ReportService;
import com.unitedsofthouse.ucucumberpackage.tools.Waiters;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.Element;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.CommonHelper;
import helpers.SystemHelper;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import pages.base.PageInstance;
import pages.relime.DashboardPage;
import pages.relime.SettingsPage;

import java.util.Random;

/**
 * Created by kozlov on 6/27/2016.
 */
public class TTSSettings extends PageInstance {
    @Autowired
    SettingsPage settingsPage;

    @Autowired
    DashboardPage dashboardPage;

    public String TTSVCSURL = "";

    @Then("^I see that \"([^\"]*)\" is added to setting 'Task tracking system' in page 'Project settings'$")
    public void iSeeThatJiraIsAddedToSettingTTS(String name) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Thread.sleep(500);
            Waiters.waitAppearanceOf(5, settingsPage.jiraAddressLabels.get(0).getWrappedElement());
            boolean elementFound = false;
            for (Element e : settingsPage.jiraAddressLabels) {
                if(e.getText().toLowerCase().equals(name.toLowerCase())){
                    elementFound = true;
                    break;
                }
            }
            ReportService.ReportAction(name + " is added to setting 'Task tracking system'", elementFound);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I change \"([^\"]*)\" 'Task tracking system' path setting to \"([^\"]*)\" in page 'Project settings'$")
    public void iChangeTTSPathValueTo(String TTS, String value) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(5, settingsPage.jiraTypeLabels.get(0).getWrappedElement());
            boolean elementFound = false;
            for (int i = 0; i < settingsPage.jiraTypeLabels.size(); i++) {
                if(settingsPage.jiraTypeLabels.get(i).getText().toLowerCase().equals(TTS.toLowerCase())){
                    elementFound = true;
                    if(!settingsPage.jiraAddressInput.isDisplayed()) {
                        settingsPage.jiraAddressLabels.get(i).click();
                    }
                    settingsPage.jiraAddressInput.clear();
                    settingsPage.jiraAddressInput.sendKeys(value);
                    settingsPage.jiraAddressInput.submit();
                    break;
                }
            }
            ReportService.ReportAction(TTS + " path value changed to " + value, elementFound);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that button 'Add TTS' is disabled$")
    public void iSeeThatButtonAddTTSIsDisabled() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Button 'Add TTS' is disabled.", settingsPage.addJiraButton.getAttribute("disabled").equals("true"));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that all the entered data matches data in page 'Project Settings' for the new project$")
    public void iSeeThatEnteredDataIsCorrect() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(10, settingsPage.NameField.getWrappedElement());
            boolean correct = settingsPage.NameField.getText().equals(CommonHelper.testProjectName)
                    &&settingsPage.KeyField.getText().equals(CommonHelper.testProjectKey)
                    &&settingsPage.DescriptionField.getText().equals(CommonHelper.testProjectDescription)
                    &&settingsPage.TypeField.getText().equals(CommonHelper.testProjectType);
            ReportService.ReportAction("Created project data is correct.", correct);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I click button 'Plus' near setting 'Task tracking system' in page 'Project settings'$")
    public void iClickButtonPlusNearTTSInPageProjectSettings() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(10, settingsPage.addJiraButton.getWrappedElement());
            settingsPage.addJiraButton.click();
            ReportService.ReportAction("Button 'Plus' near setting 'Task tracking system' in page 'Project settings' was clicked.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I type \"([^\"]*)\" into textbox 'URL' in pop-up \"([^\"]*)\"$")
    public void iTypeURLIntoURLTextboxInPopup(String arg0, String popup) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean changed = false;
            if(arg0.equals("default"))
                arg0 = SystemHelper.DEFAULTGIT;
            if(arg0.equals("smoke"))
                arg0 = SystemHelper.SMOKEGIT;
            for (Element e : settingsPage.formFields) {
                if(e.findElement(By.xpath(settingsPage.FormFieldName)).getText().contains("URL")){
                    if(arg0.contains("[random]")){
                        Random r = new Random();
                        arg0 = arg0.replace("[random]", String.valueOf(r.nextInt()));
                    }
                    e.findElement(By.xpath(settingsPage.AddProjectFormFieldInput)).click();
                    e.findElement(By.xpath(settingsPage.AddProjectFormFieldInput)).clear();
                    e.findElement(By.xpath(settingsPage.AddProjectFormFieldInput)).sendKeys(arg0);
                    TTSVCSURL = arg0;
                    changed = true;
                }
            }
            ReportService.ReportAction("Textbox 'URL' value was changed to '" + arg0 + "' on pop-up '" + popup + "'.", changed);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that entered data matches data in setting 'Task tracking system' in page 'Project settings' for Jira$")
    public void iSeeThatEnteredDataMatchesdataInSettingTTS() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Entered data matches data in setting 'Task tracking system'", settingsPage.jiraAddressLabels.get(0).getText().toLowerCase().contains(TTSVCSURL.toLowerCase()));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that entered data matches data in setting 'Version control system' in page 'Project settings' for Git$")
    public void iSeeThatEnteredDataMatchesdataInSettingVCS() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Entered data matches data in setting 'Version control system'", settingsPage.VCSAddressLabel.getText().toLowerCase().equals(TTSVCSURL.toLowerCase()));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }
}
