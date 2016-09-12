package stepdefinition.FeaturesPage.ScenarioEditor.EditScenario;

import arp.CucumberArpReport;
import arp.ReportService;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.Element;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.CommonHelper;
import helpers.SystemHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import pages.base.PageInstance;
import pages.relime.DashboardPage;
import pages.relime.EditorPage;

import java.awt.event.KeyEvent;

/**
 * Created by kozlov on 7/26/2016.
 */
public class ScenatioTagsEditing extends PageInstance {
    @Autowired
    DashboardPage dashboardPage;

    @Autowired
    EditorPage editorPage;

    @When("^I type \"([^\"]*)\" into tags input textbox in scenario info block$")
    public void iTypeIntoTagsInputTextboxInScenarioInfoBlock(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            editorPage.scenarioTagsInput.clear();
            editorPage.scenarioTagsInput.sendKeys(arg0);
            //CommonHelper.testFeatureTags = arg0;
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that tag \"([^\"]*)\" is absent in scenario info$")
    public void iSeeThatTagIsAbsentOnPopupNewFeature(String tag) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean contains = false;
            for (Element e :editorPage.scenarioAddedTags) {
                if(e.findElement(By.xpath(".//span")).getText().equals(tag)){
                    contains = true;
                    break;
                }
            }
            ReportService.ReportAction("Tag '" + tag + "' is absent for given scenario.", !contains);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that tag \"([^\"]*)\" is added to scenario info$")
    public void iSeeThatTagIsAddedOnPopupNewFeature(String tag) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean contains = false;
            for (Element e :editorPage.scenarioAddedTags) {
                if(e.findElement(By.xpath(".//span")).getText().equals(tag)){
                    contains = true;
                    break;
                }
            }
            ReportService.ReportAction("Tag '" + tag + "' is added to scenario info.", contains);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I click button 'Backspace' for scenario tags input$")
    public void iClickButtonBackspaceForScenarioTags() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            try{
                editorPage.scenarioTagsInput.sendKeys(Keys.BACK_SPACE);
                Thread.sleep(500);
            }
            catch (Exception ex) {
                CommonHelper.sendKeyWithAWT(KeyEvent.VK_BACK_SPACE);
                ReportService.ReportAction("'Backspace' button was pressed.", true);
            }
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I click button 'Delete' for tag \"([^\"]*)\" in scenario info$")
    public void iClickButtonDeleteForScenarioTag(String tag) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean contains = false;
            for (Element e :editorPage.scenarioAddedTags) {
                if(e.findElement(By.xpath(".//span")).getText().equals(tag)){
                    e.findElement(By.xpath(".//a")).click();
                    contains = true;
                    break;
                }
            }
            //ReportService.ReportAction("Tag '" + tag + "' is added on pop-up.", contains);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }
}
