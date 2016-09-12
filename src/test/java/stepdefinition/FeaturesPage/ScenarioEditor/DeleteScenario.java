package stepdefinition.FeaturesPage.ScenarioEditor;

import com.unitedsofthouse.ucucumberpackage.tools.Waiters;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.CommonHelper;
import helpers.SystemHelper;
import arp.CucumberArpReport;
import arp.ReportService;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import pages.base.PageInstance;
import pages.relime.DashboardPage;
import pages.relime.EditorPage;

public class DeleteScenario extends PageInstance{
    @Autowired
    DashboardPage dashboardPage;

    @Autowired
    EditorPage editorPage;

    @Then("^I see that the scenario was successfully deleted$")
    public void iSeeThatTheScenarioWasSuccessfullyDeleted() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Scenario was deleted.", !editorPage.scenarioExists(CommonHelper.testScenarioName));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }
}