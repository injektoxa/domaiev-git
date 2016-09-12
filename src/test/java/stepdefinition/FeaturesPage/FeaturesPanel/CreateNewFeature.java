package stepdefinition.FeaturesPage.FeaturesPanel;

import com.unitedsofthouse.ucucumberpackage.tools.Waiters;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.CommonHelper;
import arp.CucumberArpReport;
import arp.ReportService;
import helpers.SystemHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import pages.base.PageInstance;
import pages.relime.DashboardPage;
import pages.relime.EditorPage;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CreateNewFeature extends PageInstance{

    @Autowired
    EditorPage editorPage;

    @And("^I click button 'New feature' in panel 'Features'$")
    public void iClickButtonNewFeatureInPanelFeatures() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(CommonHelper.delay, editorPage.addNewFeatureButton.getWrappedElement());
            editorPage.addNewFeatureButton.click();
            ReportService.ReportAction("Button 'New feature' in panel 'Features' was clicked.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that autocomplete for tags doesn't contains elements that match RegEx \"([^\"]*)\"$")
    public void iSeeThatAutocompleteDoesNotContainElements(String pattern) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //Waiters.waitAppearanceOf(5, driver.findElement(By.xpath(".//auto-complete")));
            Pattern p = Pattern.compile(pattern);
            boolean contains = false;
            for (Element e :editorPage.tagAutocompleteElements) {
                if(p.matcher(e.getText()).matches()){
                    contains = true;
                    break;
                }
            }
            ReportService.ReportAction("Autocomplete doesn't contain '" + pattern + "' element.", !contains);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that autocomplete contains elements that match RegEx \"([^\"]*)\"$")
    public void iSeeThatAutocompleteContainsElements(String pattern) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Thread.sleep(1000);
            boolean contains = false;
            for (Element e :editorPage.tagAutocompleteElements) {
                String s = e.getText();
                if(e.getText().equals(pattern)){
                    contains = true;
                    break;
                }
            }
            ReportService.ReportAction("Autocomplete contains '" + pattern + "' element.", contains);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that tag \"([^\"]*)\" is added on popup$")
    public void iSeeThatTagIsAddedOnPopupNewFeature(String tag) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean contains = false;
            for (Element e :editorPage.addedTagsOnPopup) {
                if(e.findElement(By.xpath(".//span")).getText().equals(tag)){
                    contains = true;
                    break;
                }
            }
            ReportService.ReportAction("Tag '" + tag + "' is added on pop-up.", contains);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that tag \"([^\"]*)\" is absent on popup$")
    public void iSeeThatTagIsAbsentOnPopupNewFeature(String tag) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean contains = false;
            for (Element e :editorPage.addedTagsOnPopup) {
                if(e.findElement(By.xpath(".//span")).getText().equals(tag)){
                    contains = true;
                    break;
                }
            }
            ReportService.ReportAction("Tag '" + tag + "' is added on pop-up.", !contains);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I click button 'Delete' for tag \"([^\"]*)\" on Pop Up$")
    public void iClickButtonDeleteForTag(String tag) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean contains = false;
            for (Element e :editorPage.addedTagsOnPopup) {
                if(e.findElement(By.xpath(".//span")).getText().equals(tag)){
                    e.findElement(By.xpath(".//a")).click();
                    contains = true;
                    break;
                }
            }
            ReportService.ReportAction("Tag '" + tag + "' is added on pop-up.", contains);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I click button 'Backspace' for tags input on Pop Up$")
    public void iClickButtonBackspace() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            try{
                Thread.sleep(500);
                editorPage.tagsInputOnNewScenarioPopup.sendKeys(Keys.BACK_SPACE);
                ReportService.ReportAction("'Backspace' button was pressed.", true);
                Thread.sleep(1000);
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

    @Then("^I delete feature \"([^\"]*)\" if it's present in the tree$")
    public void iDeleteFeatureIfItIsPresent(String feature) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            if(editorPage.treeElementExists(feature)) {
                editorPage.selectTreeElementByName(feature);
                Waiters.waitAppearanceOf(CommonHelper.delay, editorPage.deleteTreeNodeButton.getWrappedElement());
                editorPage.deleteTreeNodeButton.click();
                Thread.sleep(1000);
                for (Button e : editorPage.FormButtons) {
                    String s = e.getText();
                    if (s.toLowerCase().equals("delete")) {
                        e.click();
                    }
                }
                Waiters.waitWhileConditionIsTrue(CommonHelper.delay, editorPage.firstTreeNode.isDisplayed());
                Thread.sleep(500);
            }
            ReportService.ReportAction("Feature was deleted.", !editorPage.treeElementExists(feature));
        } catch (Exception e){}
        catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I type \"([^\"]*)\" into textbox 'Feature' in pop-up 'New feature'$")
    public void iTypeIntoTextboxFeatureInPopUpNewFeature(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            SystemHelper.waitAppearanceByElement(driver, 30, 100, editorPage.nameInput.getWrappedElement());
            editorPage.nameInput.enterText(arg0);
            CommonHelper.testFeatureName = arg0;
            ReportService.ReportAction("'Feature' textbox in pop-up 'New feature' was filled with data.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I type \"([^\"]*)\" into textbox 'File name' in pop-up 'New feature'$")
    public void iTypeIntoTextboxFileNameInPopUpNewFeature(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            editorPage.fileNameInput.enterText(arg0);
            CommonHelper.testFeatureName = arg0;
            ReportService.ReportAction("'File name' textbox in pop-up 'New feature' was filled with data.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I type \"([^\"]*)\" into textbox 'Description' in pop-up 'New feature'$")
    public void iTypeIntoTextboxDescriptionInPopUpNewFeature(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            editorPage.descriptionInput.enterText(arg0);
            ReportService.ReportAction("'Description' textbox in pop-up 'New feature' was filled with data.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I type \"([^\"]*)\" into tags input textbox in pop-up 'New feature'$")
    public void iTypeIntoTagsInputTextboxInPopUpNewFeature(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            editorPage.tagsInputOnNewScenarioPopup.click();
            editorPage.tagsInputOnNewScenarioPopup.clear();
            editorPage.tagsInputOnNewScenarioPopup.sendKeys(arg0);
            ReportService.ReportAction("Tags input textbox in pop-up 'New feature' was filled with data.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that new feature is successfully created$")
    public void iSeeThatNewFeatureIsSuccessfullyCreated() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitWhileConditionIsTrue(CommonHelper.delay, editorPage.firstTreeNode.isDisplayed());
            ReportService.ReportAction("Feature was created.", editorPage.treeElementExists(CommonHelper.testFeatureName));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that the new feature is selected in the tree$")
    public void iSeeThatTheNewFeatureIsSelectedInTheTree() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Feature was selected.", editorPage.verifyIfTreeElementIsSelected(CommonHelper.testFeatureName));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }
}