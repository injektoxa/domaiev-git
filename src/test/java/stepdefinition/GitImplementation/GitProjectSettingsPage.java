package stepdefinition.GitImplementation;

import arp.CucumberArpReport;
import arp.ReportService;
import com.unitedsofthouse.ucucumberpackage.tools.Waiters;
import cucumber.api.java.en.*;
import helpers.SystemHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.beans.factory.annotation.Autowired;
import pages.base.PageInstance;
import pages.relime.DashboardPage;
import pages.relime.EditorPage;
import pages.relime.GitHubPage;
import pages.relime.SettingsPage;

import java.util.regex.Pattern;

/**
 * Created by kozlov on 7/4/2016.
 */
public class GitProjectSettingsPage extends PageInstance {

    @Autowired
    SettingsPage settingsPage;

    @Autowired
    EditorPage editorPage;

    @Autowired
    GitHubPage gitHubPage;

    @Then("^I can see that block 'Version control system' is empty")
    public void iSeeBlockVCSIsEmpty() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("'Version control system' block is empty.", !settingsPage.VCSTypeLabel.isDisplayed());
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I can't see button 'Load/Reload project from GIT' in block \"Version control system'")
    public void iCantSeeButtonReloadProjectFromGitInBlockVCS() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("'Load/Reload project from GIT' button is not displayed in block VCS.", !settingsPage.reloadProjectFromGit.isDisplayed());
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I can see button 'Load/Reload project from GIT' in block \"Version control system'")
    public void iCanSeeButtonReloadProjectFromGitInBlockVCS() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("'Load/Reload project from GIT' button is displayed in block VCS.", settingsPage.reloadProjectFromGit.isDisplayed());
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I can see tooltip \"([^\"]*)\" on button 'Load/Reload project from GIT' in block \"Version control system'")
    public void iCanSeeButtonReloadProjectFromGitInBlockVCS(String tooltip) throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("'Load/Reload project from GIT' button is displayed in block VCS.", settingsPage.reloadProjectFromGit.getAttribute("tooltip").equals(tooltip));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I click on button 'Load from Git' on page 'Settings'")
    public void iClickOnButtonLoadFromGit() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitForCustomCondition(5, new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver webDriver) {
                    boolean b = false;
                    try {
                        b = settingsPage.reloadProjectFromGit.isEnabled();
                    } catch (Exception e) {}
                    return b;
                }
            });
            settingsPage.reloadProjectFromGit.click();
            ReportService.ReportAction("Button 'Load from Git' was clicked.",  true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^Unique tags appear in Git repository \"([^\"]*)\"")
    public void uniqueTagsAppearInGitRepository(String url) throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            if(url.contains("[default]")){
                url = url.replace("[default]", SystemHelper.DEFAULTGIT);
            }
            ReportService.ReportAction("Unique tags appear in Git repository", gitHubPage.uniqueTagsArePresentInProjectFeatures(url));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I can see project was uploaded")
    public void iCanSeeProjectUploaded(String url) throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            driver.navigate().to(url);
            ReportService.ReportAction("Project was uploaded.",  true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            Waiters.waitAppearanceOf(5, editorPage.firstTreeNode.getWrappedElement());
            ReportService.ReportAction("Error: " + e.getMessage(), editorPage.firstTreeNode.isDisplayed());
        } finally {
            CucumberArpReport.nextStep();
        }
    }
}
