package stepdefinition.FeaturesPage.ScenarioEditor;

import arp.CucumberArpReport;
import arp.ReportService;
import com.unitedsofthouse.ucucumberpackage.tools.Waiters;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.Element;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.Label;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.PlaceHolder;
import cucumber.api.java.en.*;
import helpers.CommonHelper;
import helpers.SystemHelper;
import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import pages.base.PageInstance;
import pages.relime.DashboardPage;
import pages.relime.EditorPage;

/**
 * Created by kozlov on 7/27/2016.
 */
public class PaginationFunctionality extends PageInstance {

    @Autowired
    EditorPage editorPage;

    @Then("^I see that pagination element didn't appear$")
    public void iSeeThatPaginationElementDidNotAppear() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Pagination element didn't appear.", !editorPage.scenariosListPaginationElement.isDisplayed());
        }
        catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that pagination element appeared$")
    public void iSeeThatPaginationElementAppeared() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Pagination element appeared.", editorPage.scenariosListPaginationElement.isDisplayed());
        }
        catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I click on button \"([^\"]*)\" on scenarios pagination panel")
    public void iClickScenariosPaginationButton(String name) throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(5, editorPage.scenariosListPages.get(0).getWrappedElement());
            boolean buttonFound = false;
            for (Element e : editorPage.scenariosListPages) {
                if(e.getText().equals(name)){
                    buttonFound = true;
                    e.click();
                    Thread.sleep(1000);
                    break;
                }
            }
            ReportService.ReportAction("Clicked on button " + name + " on scenarios pagination panel", buttonFound);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I am on the \"([^\"]*)\" page on scenarios pagination panel")
    public void iAmOnTheRightPage(String page) throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean buttonFound = false;
            if(page.equals("last")) {
                for (int i = 0; i < editorPage.scenariosListPages.size(); i++){
                    Element e = editorPage.scenariosListPages.get(i);
                    String s = e.getText();
                    if (e.getText().equals("&gt;")) {
                        Element last = editorPage.scenariosListPages.get(i - 1);
                        if(NumberUtils.isNumber(last.getText()) && last.getAttribute("class").contains("active")) {
                            buttonFound = true;
                            break;
                        }
                    }
                }
            }
            else if(NumberUtils.isNumber(page)){
                for (Element e : editorPage.scenariosListPages) {
                    if(e.getText().equals(page)){
                        buttonFound = true;
                        break;
                    }
                }
            }
            else{
                Throwable t = new Throwable("You should provide a number or 'last' as a parameter");
                throw t;
            }
            ReportService.ReportAction("Created account is in the table.", buttonFound);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that 10 scenarios are displayed")
    public void iSeeThatTenScenariosAreDisplayed() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("10 scenarios are displayed.", editorPage.scenariosList.size()==10);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see scenario \"([^\"]*)\" is displayed")
    public void iSeeScenarioIsDisplayed(String scenario) throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean displayed = false;
            Waiters.waitAppearanceOf(3, editorPage.firstScenario.getWrappedElement());
            for (Element e : editorPage.scenariosList) {
                if(e.getText().equals(scenario)){
                    displayed = true;
                }
            }
            ReportService.ReportAction("Scenarion '" + scenario + "' is displayed.", displayed);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see scenario \"([^\"]*)\" is expanded")
    public void iSeeScenarioIsExpanded(String scenario) throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean expanded = false;
            Thread.sleep(1000);
            for (PlaceHolder p : editorPage.expandedScenarios) {
                try {
                    Label scenarioName = new Label(p.findElement(By.xpath(".//*[@id = 'nameScenario']")));
                    PlaceHolder scenarioAccordion = new PlaceHolder(p.findElement(By.xpath(".//div[contains(@class, 'accordion-content')]")));
                    if (scenarioName.getText().equals(scenario) && scenarioAccordion.isDisplayed()) {
                        expanded = true;
                    }
                }catch (Exception e){}
            }
            ReportService.ReportAction("Scenarion '" + scenario + "' is expanded.", expanded);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see scenario \"([^\"]*)\" is modified")
    public void iSeeScenarioIsModified(String scenario) throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean modified = false;
            Thread.sleep(1000);
            //Waiters.waitAppearanceOf(3, editorPage.firstScenario.getWrappedElement());
            for (PlaceHolder p : editorPage.expandedScenarios) {
                try {
                    Label scenarioName = new Label(p.findElement(By.xpath(".//*[@id = 'nameScenario']")));
                    PlaceHolder modifiedIcon = new PlaceHolder(p.findElement(By.xpath(".//i[contains(@class, 'ico-locked')]")));
                    if(scenarioName.getText().equals(scenario)&&modifiedIcon.isDisplayed()){
                        modified = true;
                    }
                }catch (Exception e){}
            }
            ReportService.ReportAction("Scenarion '" + scenario + "' is modified.", modified);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that the scenario \"([^\"]*)\" was successfully deleted$")
    public void iSeeThatTheScenarioWasSuccessfullyDeleted(String scenario) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Thread.sleep(1000);
            ReportService.ReportAction("Scenario was deleted.", !editorPage.scenarioExists(scenario));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I click option 'Delete' under drop-down 'Actions' for scenario \"([^\"]*)\" in scenario accordion$")
    public void iClickOptionDeleteUnderDropDownActionsInScenarioAccordion(String scenario) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            SystemHelper.waitAppearanceByXpath(driver, 100, 30, "(.//div[contains(@class, 'ace_line')])[1]");
            editorPage.actionsButton.click();
            Waiters.waitAppearanceOf(3, editorPage.actionDeleteInScenarioBlockButton.getWrappedElement());
            editorPage.actionDeleteInScenarioBlockButton.click();
            ReportService.ReportAction("Option 'Delete' under drop-down 'Actions' was clicked.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }
}
