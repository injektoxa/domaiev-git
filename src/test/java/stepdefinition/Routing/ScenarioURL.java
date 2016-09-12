package stepdefinition.Routing;

import arp.CucumberArpReport;
import arp.ReportService;
import com.sun.webkit.network.CookieManager;
import com.unitedsofthouse.ucucumberpackage.tools.Waiters;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.*;
import cucumber.api.java.en.Then;
import helpers.CommonHelper;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import pages.base.PageInstance;
import pages.relime.EditorPage;

/**
 * Created by kozlov on 6/30/2016.
 */
public class ScenarioURL extends PageInstance {

    @Autowired
    EditorPage editorPage;

    @Then("^I select \"([^\"]*)\" scenario in the table")
    public void iSelectScenarioInTheTable(String scenario) throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(5, editorPage.firstScenario.getWrappedElement());
            boolean elementFound = false;
            for (Link l : editorPage.scenariosList) {
                String s = l.getText();
                if(l.getText().equals(scenario)){
                    l.click();
                    elementFound = true;
                    CommonHelper.testScenarioName = scenario;
                    break;
                }
            }
            ReportService.ReportAction("'" + scenario + "' scenario was selected in the table.", elementFound);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see scenario is expanded")
    public void iSelectScenarioInTheTable() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(5, driver.findElement(By.xpath(".//div[contains(@class, 'accordion-content')]")));
            ReportService.ReportAction("Scenario is expanded.", editorPage.verifyIfScenarioAccordionIsExpanded());
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }
}
