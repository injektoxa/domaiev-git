package stepdefinition.ProjectDataEditing.ProjectSettings;

import arp.CucumberArpReport;
import arp.ReportService;
import com.unitedsofthouse.ucucumberpackage.tools.Waiters;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import helpers.SystemHelper;
import org.springframework.beans.factory.annotation.Autowired;
import pages.base.PageInstance;
import pages.relime.DashboardPage;
import pages.relime.SettingsPage;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by kozlov on 6/27/2016.
 */
public class VCSSettings extends PageInstance {

    @Autowired
    SettingsPage settingsPage;

    @And("^I am not able to add or delete VCS$")
    public void iAmNotAbleToAddOrDeleteVCS() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitDisappearsOf(0, settingsPage.AddVCSButton.getWrappedElement(),2);
            ReportService.ReportAction("Add button is absent", !settingsPage.AddVCSButton.isDisplayed());
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I click button 'Plus' near setting 'Version control system' in page 'Project settings'$")
    public void iClickButtonPlusNearVCSInPageProjectSettings() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(10, settingsPage.AddVCSButton.getWrappedElement());
            settingsPage.AddVCSButton.click();
            ReportService.ReportAction("Button 'Plus' near setting 'Version control system' in page 'Project settings' was clicked.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I check that VCS \"([^\"]*)\" is absent in DB$")
    public void iCheckThatVCSIsAbsentInDB(String Key) throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            if(Key.equals("default"))
                Key = SystemHelper.DEFAULTGIT;
            if(Key.equals("smoke"))
                Key = SystemHelper.SMOKEGIT;
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:jtds:sqlserver://" + SystemHelper.DATABASEIP + ";databaseName=RelimeDb;user=" + SystemHelper.DATABASELOGIN + ";password=" + SystemHelper.DATABASEPASS + ";");
            con.prepareStatement("DELETE FROM [RelimeDb].[dbo].[Vcs] WHERE Url = '" + Key + "';").execute();
            ReportService.ReportAction("VCS '" + Key + "' is absent in DB.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that \"([^\"]*)\" is added to setting 'Version control system' in page 'Project settings'$")
    public void iSeeThatJiraIsAddedToSettingVCS(String name) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(5, settingsPage.VCSTypeLabel.getWrappedElement());
            ReportService.ReportAction("Jira is added to setting 'Version control system'", settingsPage.VCSTypeLabel.getText().toLowerCase().equals(name.toLowerCase()));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }
}
