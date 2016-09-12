package stepdefinition.FeaturesPage.ScenarioEditor.EditBackground;

import arp.CucumberArpReport;
import arp.ReportService;
import com.unitedsofthouse.ucucumberpackage.tools.Waiters;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.Link;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import helpers.CommonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import pages.base.PageInstance;
import pages.relime.DashboardPage;
import pages.relime.EditorPage;

/**
 * Created by kozlov on 7/28/2016.
 */
public class EditAndSaveBackground extends PageInstance {
    @Autowired
    DashboardPage dashboardPage;

    @Autowired
    EditorPage editorPage;

    @Then("^I select background in the table")
    public void iSelectBackgroundInTheTable() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(5, editorPage.backgroundElement.getWrappedElement());
            editorPage.backgroundElement.click();
            ReportService.ReportAction("Background was selected.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that changes are successfully saved and changed data matches data in Scenario Editor for the edited background")
    public void iSeeThatChangesAreSuccessfullySavedAndChangedDataMatchesDataInScenarioEditorForTheEditedScenario() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            editorPage.backgroundElement.click();
            //editorPage.selectScenarioByName(CommonHelper.testScenarioName);
            ReportService.ReportAction("Scenario name is correct.", editorPage.verifyScenarioName());
            ReportService.ReportAction("Scenario description is correct.", editorPage.verifyScenarioDescription());
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }
}
