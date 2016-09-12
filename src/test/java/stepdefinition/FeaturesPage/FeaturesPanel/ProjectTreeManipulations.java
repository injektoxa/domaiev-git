package stepdefinition.FeaturesPage.FeaturesPanel;

import arp.CucumberArpReport;
import arp.ReportService;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.Image;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.Label;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.PlaceHolder;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.TextInput;
import cucumber.api.java.en.*;
import gherkin.lexer.Th;
import helpers.CommonHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import pages.base.PageInstance;
import pages.relime.DashboardPage;
import pages.relime.EditorPage;

/**
 * Created by kozlov on 8/1/2016.
 */
public class ProjectTreeManipulations extends PageInstance {
    @Autowired
    DashboardPage dashboardPage;

    @Autowired
    EditorPage editorPage;

    @When("^I drag element \"([0-9]{1,2})\" under element \"([0-9]{1,2})\" in the tree$")
    public void iDragFolderToFolder(int from, int to) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            int fromX = editorPage.treeElements.get(from-1).getWrappedElement().getLocation().getX();
            int fromY = editorPage.treeElements.get(from-1).getWrappedElement().getLocation().getY();
            int toX = 0;
            int toY = 0;
            if(to==editorPage.treeElements.size()){
                toX = editorPage.treeElements.get(to-1).getWrappedElement().getLocation().getX();
                toY = editorPage.treeElements.get(to-1).getWrappedElement().getLocation().getY();
                toY += 20;
            }
            else {
                toX = editorPage.treeElements.get(to).getWrappedElement().getLocation().getX();
                toY = editorPage.treeElements.get(to).getWrappedElement().getLocation().getY();
            }
            editorPage.treeElements.get(from-1).click();
            Thread.sleep(500);
            Actions a = new Actions(driver);
            a.clickAndHold(editorPage.treeElements.get(from-1).getWrappedElement());
            a.pause(1000);
            int offsetY = toY-fromY;
            a.moveByOffset(toX-fromX, 0);
            for (int i = 0; i < offsetY; i+=10) {
                a.moveByOffset(0, 10);
                a.pause(50);
            }
            a.pause(500);
            a.release();
            //a.dragAndDropBy(editorPage.treeElements.get(from-1).getWrappedElement(),);
            a.build().perform();
            ReportService.ReportAction("Element was successfully dragged.", true);
            Thread.sleep(5000);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I can see that element \"([^\"]*)\" is in position \"([0-9]{1,2})\" in the tree$")
    public void iTypeIntoStringInScenarioEditorInScenarioAccordion(String element, int position) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            String s = editorPage.treeElements.get(position-1).getText();
            ReportService.ReportAction("Element '" + element + "' is in position " + position + " in the tree.", editorPage.treeElements.get(position-1).getText().equals(element));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that field \"([^\"]*)\" with label is displayed under the tree$")
    public void iSeeThatFieldFeatureWithLabelIsDisplayedUnderTheTree(String field) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean displayed = false;
            for (PlaceHolder p : editorPage.treeElementFields) {
                if(p.findElement(By.xpath(".//h3[contains(@class, 'title')]")).getText().toLowerCase().equals(field.toLowerCase())
                        &&p.findElement(By.xpath(".//div[contains(@class, 'content-col')]")).isDisplayed()){
                    displayed = true;
                    break;
                }
            }
            ReportService.ReportAction("Field '" + field + "' with label is displayed under the tree.", displayed);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that feature name \"([^\"]*)\" label is displayed above scenarios list$")
    public void iSeeThatFeatureNameLabelIsDisplayedAboveScenariosList(String feature) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Feature name '" + feature + "' label is displayed above scenarios list.", editorPage.featureNameLabel.isDisplayed()&&editorPage.featureNameLabel.getText().toLowerCase().equals(feature.toLowerCase()));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that scenarios table controls are displayed above scenarios list$")
    public void iSeeThatScenariosTableControlsAreDisplayedAboveScenariosList() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean enabled = false;
            if(editorPage.scenariosListControlElements.findElement(By.xpath(".//li[1]/button")).isEnabled()&&
            editorPage.scenariosListControlElements.findElement(By.xpath(".//li[3]//input")).isEnabled()){
                enabled = true;
            }
            ReportService.ReportAction("Scenarios table controls are displayed above scenarios list.", enabled);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that scenarios table controls are not displayed above scenarios list$")
    public void iSeeThatScenariosTableControlsAreNotDisplayedAboveScenariosList() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean enabled = false;
            boolean b1 = editorPage.scenariosListControlElements.findElement(By.xpath(".//li[1]/button")).isEnabled();
            boolean b2 = editorPage.scenariosListControlElements.findElement(By.xpath(".//li[2]/button")).isEnabled();
            boolean b3 = editorPage.scenariosListControlElements.findElement(By.xpath(".//li[3]//input")).isEnabled();
            if(!editorPage.scenariosListControlElements.findElement(By.xpath(".//li[1]/button")).getAttribute("class").contains("disabled")||
                    !editorPage.scenariosListControlElements.findElement(By.xpath(".//li[2]/button")).getAttribute("class").contains("disabled")||
                    editorPage.scenariosListControlElements.findElement(By.xpath(".//li[3]//input")).isEnabled()){
                enabled = true;
            }
            ReportService.ReportAction("Scenarios table controls are not displayed above scenarios list.", !enabled);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that scenarios have label 'Scenarios' above the first accordion in Scenario Editor$")
    public void iSeeThatScenariosHaveLabelScenariosAboveTheFirstAccordion() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Label 'Scenarios' is displayed above the first accordion in Scenario Editor.", editorPage.scenariosLabel.isDisplayed()&&editorPage.scenariosLabel.getText().toLowerCase().equals("scenarios"));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that label 'Scenarios' is not displayed in Scenario Editor$")
    public void iSeeThatScenariosHaveLabelScenariosIsNotDisplayed() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Label 'Scenarios' is not displayed in Scenario Editor.", !editorPage.scenariosLabel.isDisplayed());
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }
}
