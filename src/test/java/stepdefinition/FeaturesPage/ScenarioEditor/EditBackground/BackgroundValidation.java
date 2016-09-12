package stepdefinition.FeaturesPage.ScenarioEditor.EditBackground;

import arp.CucumberArpReport;
import arp.ReportService;
import com.unitedsofthouse.ucucumberpackage.tools.Waiters;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.Label;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.PlaceHolder;
import cucumber.api.java.en.*;
import gherkin.lexer.Th;
import helpers.CommonHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import pages.base.PageInstance;
import pages.relime.DashboardPage;
import pages.relime.EditorPage;

/**
 * Created by kozlov on 7/29/2016.
 */
public class BackgroundValidation extends PageInstance {
    @Autowired
    DashboardPage dashboardPage;

    @Autowired
    EditorPage editorPage;


    @Then("^I see that background is modified")
    public void iSeeThatBackgroundIsModified() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean modified = false;
            Thread.sleep(1000);
            //Waiters.waitAppearanceOf(3, editorPage.firstScenario.getWrappedElement());
            for (PlaceHolder p : editorPage.expandedScenarios) {
                try {
                    Label scenarioName = new Label(p.findElement(By.xpath(".//span[contains(@class, 'counter')]")));
                    PlaceHolder modifiedIcon = new PlaceHolder(p.findElement(By.xpath(".//i[contains(@class, 'ico-locked')]")));
                    if(scenarioName.getText().equals("BG")&&modifiedIcon.isDisplayed()){
                        modified = true;
                    }
                }catch (Exception e){}
            }
            ReportService.ReportAction("Background is modified.", modified);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I select step \"([1-9])\" in Ace Editor in scenario accordion$")
    public void iSelectStepIsMarkedRedInAccordion(int step) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            CommonHelper.clickWithActions(editorPage.scenarioStepLines.get(--step).getWrappedElement());
            ReportService.ReportAction("Step " + ++step + " is selected.",  true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I delete keyword from step \"([1-9])\" in Ace Editor in scenario accordion$")
    public void iDeleteKeywordFromStepIsMarkedRedInAccordion(int step) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            CommonHelper.clickWithActions(editorPage.scenarioStepsTextarea.getWrappedElement());
            Thread.sleep(1000);
            CommonHelper.doubleClickWithActions(editorPage.scenarioStepLines.get(--step).findElement(By.xpath(".//span[@class='ace_keyword']")));
            Thread.sleep(500);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.BACK_SPACE);
            actions.build().perform();
            ReportService.ReportAction("Step " + step + " is selected.",  true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I see that checkbox \"([^\"]*)\" is disabled in pop-up \"([^\"]*)\"")
    public void iClickCheckboxInPoUp(String field, String popup) throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Thread.sleep(500);
            boolean disabled = false;
            for (PlaceHolder e : editorPage.formCheckboxes) {
                String s = e.getText();
                String d = e.findElement(By.xpath("./input")).getAttribute("disabled");
                if(e.getText().toLowerCase().contains(field.toLowerCase())&&e.findElement(By.xpath("./input")).getAttribute("disabled").equals("true")){
                    disabled = true;
                    break;
                }
            }
            ReportService.ReportAction("Checkbox '" + field + "' is disabled.", disabled);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }
}
