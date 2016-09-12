package stepdefinition.Routing;

import arp.CucumberArpReport;
import arp.ReportService;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import pages.base.PageInstance;
import pages.relime.EditorPage;

/**
 * Created by kozlov on 6/30/2016.
 */
public class FeatureURL extends PageInstance {

    @Autowired
    EditorPage editorPage;

    @Then("^I see story \"([^\"]*)\" is selected in the tree")
    public void iSeeStorySelectedInTheTree(String story) throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Story '" + story + "' is selected.", editorPage.currentNodeLabel.getText().toLowerCase().equals(story.toLowerCase()));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see story data under the tree")
    public void iSeeNotificationMessages() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Story data is displayed.", editorPage.featureDataPanel.isDisplayed());
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }
}
