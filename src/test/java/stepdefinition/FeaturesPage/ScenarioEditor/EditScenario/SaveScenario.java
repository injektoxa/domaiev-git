package stepdefinition.FeaturesPage.ScenarioEditor.EditScenario;

import arp.CucumberArpReport;
import arp.ReportService;
import com.unitedsofthouse.ucucumberpackage.tools.Waiters;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.CheckBox;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.PlaceHolder;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.CommonHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import pages.base.PageInstance;
import pages.relime.DashboardPage;
import pages.relime.EditorPage;

/**
 * Created by kozlov on 7/27/2016.
 */
public class SaveScenario extends PageInstance {
    @Autowired
    DashboardPage dashboardPage;

    @Autowired
    EditorPage editorPage;

    @When("^I click checkbox \"([^\"]*)\" in pop-up \"([^\"]*)\"")
    public void iClickCheckboxInPoUp(String field, String popup) throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Thread.sleep(500);
            for (PlaceHolder e : editorPage.formCheckboxes) {
                String s = e.getText();
                if(e.getText().toLowerCase().contains(field.toLowerCase())){
                    e.click();
                    Thread.sleep(500);
                    break;
                }
            }
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I see that checkbox \"([^\"]*)\" is checked in pop-up \"([^\"]*)\"")
    public void iSeeThatCheckboxIsCheckedInPoUp(String field, String popup) throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean checked = false;
            Thread.sleep(500);
            for (PlaceHolder e : editorPage.formCheckboxes) {
                String s = e.getText();
                CheckBox c = new CheckBox(e.findElement(By.xpath("./input")));
                if(e.getText().toLowerCase().contains(field.toLowerCase())&&c.isSelected()){
                    checked = true;
                }
            }
            ReportService.ReportAction("Checkbox '" + field + "' is checked in popup '" + popup + "'", checked);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I see that checkbox \"([^\"]*)\" is unchecked in pop-up \"([^\"]*)\"")
    public void iSeeThatCheckboxIsUncheckedInPoUp(String field, String popup) throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean checked = false;
            Thread.sleep(500);
            for (PlaceHolder e : editorPage.formCheckboxes) {
                String s = e.getText();
                CheckBox c = new CheckBox(e.findElement(By.xpath("./input")));
                if(e.getText().toLowerCase().contains(field.toLowerCase())&&c.isSelected()){
                    checked = true;
                }
            }
            ReportService.ReportAction("Checkbox '" + field + "' is unchecked in popup '" + popup + "'", !checked);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I delete step \"([1-9])\" in Ace Editor in scenario accordion$")
    public void iDeleteStepInAccordion(int step) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            step--;
            Thread.sleep(1000);
            CommonHelper.clickWithActions(editorPage.scenarioStepLines.get(step).getWrappedElement());
            Thread.sleep(500);
            CommonHelper.selectLine(editorPage.scenarioStepLines.get(step).getWrappedElement());
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.BACK_SPACE);
            if(step==0){
                actions.sendKeys(Keys.DELETE);
            }else
                actions.sendKeys(Keys.BACK_SPACE);
            actions.build().perform();
            ReportService.ReportAction("Step " + step + "equals is selected.",  true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that background was successfully deleted$")
    public void iSeeThatTheScenarioWasSuccessfullyDeleted() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitDisappearsOf(3, editorPage.backgroundElement.getWrappedElement(), 3);
            ReportService.ReportAction("Scenario was deleted.", !editorPage.backgroundElement.isDisplayed());
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }
}
