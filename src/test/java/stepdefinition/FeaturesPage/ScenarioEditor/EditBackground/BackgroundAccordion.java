package stepdefinition.FeaturesPage.ScenarioEditor.EditBackground;

import arp.CucumberArpReport;
import arp.ReportService;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.*;
import cucumber.api.java.en.*;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import pages.relime.DashboardPage;
import pages.relime.EditorPage;

import static pages.base.PageInstance.checkIfFurtherStepsAreNeeded;

/**
 * Created by kozlov on 8/1/2016.
 */
public class BackgroundAccordion {

    @Autowired
    EditorPage editorPage;


    @Then("^I see that background 'Name' label is visible")
    public void iSeeThatBackgroundIsModified() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean displayed = false;
            Thread.sleep(1000);
            //Waiters.waitAppearanceOf(3, editorPage.firstScenario.getWrappedElement());
            for (PlaceHolder p : editorPage.expandedScenarios) {
                try {
                    Label scenarioName = new Label(p.findElement(By.xpath(".//span[contains(@class, 'counter')]")));
                    Label label = new Label(p.findElement(By.xpath(".//*[@id='nameScenario']")));
                    if(scenarioName.getText().equals("BG")&&label.isDisplayed()){
                        displayed = true;
                    }
                }catch (Exception e){}
            }
            ReportService.ReportAction("Background 'Name' label is visible.", displayed);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that background 'Description' field with label is visible")
    public void iSeeThatBackgroundDescriptionFieldIsVisible() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean displayed = false;
            Thread.sleep(1000);
            //Waiters.waitAppearanceOf(3, editorPage.firstScenario.getWrappedElement());
            for (PlaceHolder p : editorPage.expandedScenarios) {
                try {
                    Label scenarioName = new Label(p.findElement(By.xpath(".//span[contains(@class, 'counter')]")));
                    Label label = new Label(p.findElement(By.xpath(".//div[contains(@class, 'description-holder')]//*[@class = 'title']")));
                    Label field = new Label(p.findElement(By.xpath(".//div[contains(@class, 'description-holder')]//a")));
                    if(scenarioName.getText().equals("BG")&&label.getText().toLowerCase().equals("description")&&field.isDisplayed()){
                        displayed = true;
                    }
                }catch (Exception e){}
            }
            ReportService.ReportAction("Background 'Description' field with label is visible.", displayed);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that background steps editor with label is visible")
    public void iSeeThatBackgroundStepsEditorIsVisible() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean displayed = false;
            Thread.sleep(1000);
            //Waiters.waitAppearanceOf(3, editorPage.firstScenario.getWrappedElement());
            for (PlaceHolder p : editorPage.expandedScenarios) {
                try {
                    Label scenarioName = new Label(p.findElement(By.xpath(".//span[contains(@class, 'counter')]")));
                    Label label = new Label(p.findElement(By.xpath(".//scenario-steps-editor//label")));
                    String s = label.getText();
                    if(scenarioName.getText().equals("BG")&&label.getText().toLowerCase().startsWith("steps")&&editorPage.scenarioStepsTextarea.isDisplayed()){
                        displayed = true;
                    }
                }catch (Exception e){}
            }
            ReportService.ReportAction("Background steps editor with label is visible.", displayed);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that background tags editor with label is not visible")
    public void iSeeThatBackgroundTagsEditorIsNotVisible() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean displayed = false;
            Thread.sleep(1000);
            //Waiters.waitAppearanceOf(3, editorPage.firstScenario.getWrappedElement());
            for (PlaceHolder p : editorPage.expandedScenarios) {
                try {
                    Label scenarioName = new Label(p.findElement(By.xpath(".//span[contains(@class, 'counter')]")));
                    Label tagsEditor = new Label(p.findElement(By.xpath(".//scenario-tags-editor")));
                    if(scenarioName.getText().equals("BG")&&!tagsEditor.isDisplayed()){
                        displayed = true;
                    }
                }catch (Exception e){}
            }
            ReportService.ReportAction("Background tags editor with label is not visible.", displayed);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that example table is not displayed for background")
    public void iSeeThatExampleTableIsNotDisplayedForBackground() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean displayed = false;
            Thread.sleep(1000);
            //Waiters.waitAppearanceOf(3, editorPage.firstScenario.getWrappedElement());
            for (PlaceHolder p : editorPage.expandedScenarios) {
                try {
                    Label scenarioName = new Label(p.findElement(By.xpath(".//span[contains(@class, 'counter')]")));
                    if(scenarioName.getText().equals("BG")&&!editorPage.tagsInput.isDisplayed()){
                        displayed = true;
                    }
                }catch (Exception e){}
            }
            ReportService.ReportAction("Example table is not displayed for background.", displayed);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }
}
