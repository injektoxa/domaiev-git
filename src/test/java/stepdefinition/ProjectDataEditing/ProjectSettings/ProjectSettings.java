package stepdefinition.ProjectDataEditing.ProjectSettings;

import arp.CucumberArpReport;
import arp.ReportService;
import com.unitedsofthouse.ucucumberpackage.tools.Waiters;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.Element;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.CommonHelper;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import pages.base.PageInstance;
import pages.relime.DashboardPage;
import pages.relime.SettingsPage;

/**
 * Created by kozlov on 6/27/2016.
 */
public class ProjectSettings extends PageInstance {
    @Autowired
    SettingsPage settingsPage;

    @Autowired
    DashboardPage dashboardPage;

    @When("^I change textbox 'Name' value to \"([^\"]*)\" in page 'Project settings'$")
    public void iChangeTextboxNameValueToInPageProjectSettings(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(10, settingsPage.NameField.getWrappedElement());
            settingsPage.NameField.click();
            Waiters.waitAppearanceOf(3, settingsPage.NameInput.getWrappedElement());
            settingsPage.NameInput.clear();
            settingsPage.NameInput.sendKeys(arg0);
            settingsPage.NameInput.submit();
            ReportService.ReportAction("Textbox 'Name' value was changed in page 'Project settings'.", true);
            CommonHelper.testProjectName = arg0;
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I change textbox 'Description' value to \"([^\"]*)\" in page 'Project settings'$")
    public void iChangeTextboxDescriptionValueToInPageProjectSettings(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(10, settingsPage.DescriptionField.getWrappedElement());
            settingsPage.DescriptionField.click();
            Waiters.waitAppearanceOf(10, settingsPage.DescriptionInput.getWrappedElement());
            settingsPage.DescriptionInput.clear();
            settingsPage.DescriptionInput.sendKeys(arg0);
            settingsPage.DescriptionInput.submit();
            ReportService.ReportAction("Textbox 'Description' value was changed in page 'Project settings'.", true);
            CommonHelper.testProjectDescription = arg0;
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I change drop-down 'Project type' value to \"([^\"]*)\" in page 'Project settings'$")
    public void iChangeDropdownProjectTypeValueToInPageProjectSettings(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean elementFound = false;
            //Waiters.waitAppearanceOf(5, settingsPage.TypeField.getWrappedElement());
            //settingsPage.TypeField.click();
            Waiters.waitAppearanceOf(5, settingsPage.TypeInput.getWrappedElement());
            settingsPage.TypeInput.click();
            Waiters.waitAppearanceOf(5, settingsPage.TypeOptions.get(0).getWrappedElement());
            for (Element e : settingsPage.TypeOptions) {
                if(e.getText().equals(arg0)){
                    e.click();
                    elementFound = true;
                    break;
                }
            }
            //settingsPage.TypeInput.submit();
            ReportService.ReportAction("Textbox 'Description' value was changed in page 'Project settings'.", elementFound);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I change drop-down 'Saving mode' value to \"([^\"]*)\" in page 'Project settings'$")
    public void iChangeDropdownSavingModeValueToInPageProjectSettings(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean elementFound = false;
            Waiters.waitAppearanceOf(5, settingsPage.SavingModeInput.getWrappedElement());
            settingsPage.SavingModeInput.click();
            Waiters.waitAppearanceOf(5, settingsPage.SavingModeOptions.get(0).getWrappedElement());
            for (Element e : settingsPage.SavingModeOptions) {
                if(e.getText().equals(arg0)){
                    e.click();
                    elementFound = true;
                    break;
                }
            }
            //settingsPage.SavingModeInput.submit();
            ReportService.ReportAction("Textbox 'Description' value was changed in page 'Project settings'.", elementFound);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that textbox 'Name' is \"([^\"]*)\" in page 'Project settings'$")
    public void iSeeChangesAreSuccessfulySavedInTextboxNameInPageProjectSettings(String value) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Project name successfule changed.", settingsPage.NameField.getText().equals(value));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that textbox 'Description' is \"([^\"]*)\" in page 'Project settings'$")
    public void iSeeChangesAreSuccessfulySavedInTextboxDesriptionInPageProjectSettings(String value) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Project name successfule changed.", settingsPage.DescriptionField.getText().equals(value));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that drop-down 'Project type' value is \"([^\"]*)\" in page 'Project settings'$")
    public void iSeeThatDropdownProjectTypevalueIsInPageProjectSettings(String value) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            String s = settingsPage.TypeInput.findElement(By.xpath(".//span[@class='ng-binding ng-scope']")).getText();
            ReportService.ReportAction("Drop-down 'Project type' value is '" + value + "'.", settingsPage.TypeInput.findElement(By.xpath(".//span[@class='ng-binding ng-scope']")).getText().equals(value));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that drop-down 'Saving mode' value is \"([^\"]*)\" in page 'Project settings'$")
    public void iSeeThatDropdownSavingModeValueIsInPageProjectSettings(String value) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Drop-down 'Saving mode' value is '" + value + "'.", settingsPage.SavingModeInput.findElement(By.xpath(".//span[@class='ng-binding ng-scope']")).getText().equals(value));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }
}
