package stepdefinition.FeaturesPage.FeaturesPanel;

import com.unitedsofthouse.ucucumberpackage.tools.Waiters;
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

public class DeleteFeature extends PageInstance{

    @Autowired
    EditorPage editorPage;

    @When("^I click icon 'Delete' in panel 'Features'$")
    public void iClickIconDeleteInPanelFeatures() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(CommonHelper.delay, editorPage.deleteTreeNodeButton.getWrappedElement());
            editorPage.deleteTreeNodeButton.click();
            ReportService.ReportAction("'Delete' in panel 'Features' was clicked.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that the feature was successfully deleted$")
    public void iSeeThatTheFeatureWasSuccessfullyDeleted() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitWhileConditionIsTrue(CommonHelper.delay, editorPage.firstTreeNode.isDisplayed());
            ReportService.ReportAction("Folder was deleted.", !editorPage.treeElementExists(CommonHelper.testFeatureName));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }
}