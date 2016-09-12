package stepdefinition.JiraImplementation;

import arp.CucumberArpReport;
import arp.ReportService;
import com.unitedsofthouse.ucucumberpackage.tools.Waiters;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import pages.base.PageInstance;
import pages.relime.DashboardPage;
import pages.relime.EditorPage;
import pages.relime.GitHubPage;
import pages.relime.SettingsPage;

/**
 * Created by kozlov on 7/7/2016.
 */
public class JiraProjectSettingsPage extends PageInstance {

    @Autowired
    SettingsPage settingsPage;

    @Autowired
    DashboardPage dashboardPage;

    @Autowired
    EditorPage editorPage;

    @Autowired
    GitHubPage gitHubPage;

    @Then("^I see \"([^\"]*)\" warning under TTS Path field")
    public void iSeeThatButtonUploadFromJiraIsDisabled(String warning) throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(10, settingsPage.jiraAddressWarning.getWrappedElement());
            if(settingsPage.jiraAddressWarning.isDisplayed()) {
                if(warning.equals("")){
                    ReportService.ReportAction("Warning field appeared.", true);
                }
                else {
                    String s = settingsPage.successNotificationWindow.getText().toLowerCase();
                    ReportService.ReportAction("\"" + warning + "\" warning field appeared.", s.equals(warning.toLowerCase()));
                }
            }
            else {
                ReportService.ReportAction("Warning field didn't appear.", false);
            }
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }
}
