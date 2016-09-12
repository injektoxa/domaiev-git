package stepdefinition.FeaturesPage.ScenarioEditor.EditScenario;

import arp.CucumberArpReport;
import arp.ReportService;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.Label;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.TextInput;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.CommonHelper;
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
public class AceEditor extends PageInstance {
    @Autowired
    DashboardPage dashboardPage;

    @Autowired
    EditorPage editorPage;

    @And("^I type \"([^\"]*)\" in the current string in Scenario Editor in scenario accordion$")
    public void iTypeInTheFirstStringInScenarioEditorInPopUpNewScenario(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Thread.sleep(500);
            if(!editorPage.scenarioStepsTextarea.getAttribute("class").contains("ace_focus")){
                editorPage.scenarioStepsTextarea.click();
                Thread.sleep(500);
            }
            TextInput t = new TextInput(editorPage.scenarioStepsTextarea.findElement(By.xpath("./textarea")));
            for (char c : arg0.toCharArray()) {
                String s = String.valueOf(c);
                t.sendKeys(s);
            }
            Thread.sleep(1000);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I type \"([^\"]*)\" into string \"([^\"]*)\" in Scenario Editor in scenario accordion$")
    public void iTypeIntoStringInScenarioEditorInScenarioAccordion(String arg0, String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            if(arg0.equals("comment")){
                arg0 = "\"\"\" comment";
            }

            if(!editorPage.scenarioStepsTextarea.getAttribute("class").contains("ace_focus"))
                editorPage.scenarioStepsTextarea.click();
            TextInput t = new TextInput(editorPage.scenarioStepsTextarea.findElement(By.xpath("./textarea")));
            t.sendKeys("\n");
            for (char c : arg0.toCharArray()) {
                String s = String.valueOf(c);
                t.sendKeys(s);
            }
            Thread.sleep(1000);
            ReportService.ReportAction("'" + arg0 + "' is set to the " + arg1 + " string in Scenario Editor in pop-up 'New Scenario'.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I click button 'Backspace' for steps input in scenario acordion$")
    public void iClickButtonBackspaceFoSteps() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            try{
                TextInput t = new TextInput(editorPage.scenarioStepsTextarea.findElement(By.xpath("./textarea")));
                t.sendKeys(Keys.BACK_SPACE);
                //editorPage.stepsTextarea.sendKeys(Keys.BACK_SPACE);
                //Thread.sleep(1000);
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

    @Then("^I see that \"([0-9]{1,2})\" line equals \"([^\"]*)\" in Ace Editor in scenario accordion$")
    public void iSeeThatLineEqualsInAceEditorInAccordion(int line, String text) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Thread.sleep(1000);
            if(text.equals("comment"))
                text = "\"\"\"";
            ReportService.ReportAction("Line " + line + "equals '" + text + "' in Ace Editor.",  editorPage.scenarioStepLines.get(--line).getText().equals(text));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that \"([0-9]{1,2})\" line is marked as comment in Ace Editor in scenario accordion$")
    public void iSeeThatLineIsMarkedAsCommentInAceEditorInAccordion(int line) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Label step = new Label(editorPage.scenarioStepLines.get(--line).findElement(By.xpath(".//span")));
            ReportService.ReportAction("Line " + line + " is marked as comment in Ace Editor.",  step.getAttribute("class").equals("ace_comment"));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that step \"([1-9])\" is marked red in Ace Editor in scenario accordion$")
    public void iSeeThatStepIsMarkedRedInAccordion(int step) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Step " + step + "equals is marked red in Ace Editor.",  editorPage.scenarioStepStatusLabels.get(--step).getAttribute("class").contains("btn-danger"));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that step \"([1-9])\" is marked green in Ace Editor in scenario accordion$")
    public void iSeeThatStepIsMarkedGreenInAccordion(int step) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Step " + step + "equals is marked green in Ace Editor.",  editorPage.scenarioStepStatusLabels.get(--step).getAttribute("class").contains("btn-success"));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }


    @Then("^I see that step \"([1-9])\" is not marked in Ace Editor in scenario accordion$")
    public void iSeeThatStepIsNotMarkedInAccordion(int step) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Step " + step + "equals is marked green in Ace Editor.",  editorPage.scenarioStepStatusLabels.get(--step).getAttribute("class").equals("ace_gutter-cell "));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }
}
