package stepdefinition.FeaturesPage.FeaturesPanel;

import com.unitedsofthouse.ucucumberpackage.tools.Waiters;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.Button;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
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

public class DeleteFolder extends PageInstance{

    @Autowired
    EditorPage editorPage;

    @Then("^I delete folder \"([^\"]*)\" if it's present in the tree$")
    public void iDeleteFeatureIfItIsPresent(String folder) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            if(editorPage.treeElementExists(folder)) {
                editorPage.selectTreeElementByName(folder);
                Waiters.waitAppearanceOf(CommonHelper.delay, editorPage.deleteTreeNodeButton.getWrappedElement());
                editorPage.deleteTreeNodeButton.click();
                Thread.sleep(1000);
                for (Button e : editorPage.FormButtons) {
                    String s = e.getText();
                    if (s.toLowerCase().equals("delete")) {
                        e.click();
                    }
                }
            }
            Waiters.waitWhileConditionIsTrue(CommonHelper.delay, editorPage.firstTreeNode.isDisplayed());
            ReportService.ReportAction("Folder was deleted.", !editorPage.treeElementExists(folder));
        } catch (Exception e){}
        catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }


    @Then("^I see that the folder was successfully deleted$")
    public void iSeeThatTheFolderWasSuccessfullyDeleted() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Thread.sleep(2000);
            ReportService.ReportAction("Folder was deleted.", !editorPage.treeElementExists(CommonHelper.testFolderName));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }
}