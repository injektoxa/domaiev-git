package stepdefinition.FeaturesPage.FeaturesPanel;

import com.unitedsofthouse.ucucumberpackage.tools.Waiters;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.Element;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.CommonHelper;
import arp.CucumberArpReport;
import arp.ReportService;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import pages.base.PageInstance;
import pages.relime.DashboardPage;
import pages.relime.EditorPage;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class EditFeature extends PageInstance{
    @Autowired
    DashboardPage dashboardPage;

    @Autowired
    EditorPage editorPage;

    @Then("^I see that tag \"([^\"]*)\" is added to feature info under the tree$")
    public void iSeeThatTagIsAddedOnPopupNewFeature(String tag) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean contains = false;
            for (Element e :editorPage.featureAddedTags) {
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

    @Then("^I see that tag \"([^\"]*)\" is absent on feature info under the tree$")
    public void iSeeThatTagIsAbsentOnPopupNewFeature(String tag) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean contains = false;
            for (Element e :editorPage.featureAddedTags) {
                if(e.findElement(By.xpath(".//span")).getText().equals(tag)){
                    contains = true;
                    break;
                }
            }
            ReportService.ReportAction("Tag '" + tag + "' is absent under the tree.", !contains);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I click button 'Delete' for tag \"([^\"]*)\" under the tree$")
    public void iClickButtonDeleteForTag(String tag) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean contains = false;
            for (Element e :editorPage.featureAddedTags) {
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

    @And("^I click button 'Backspace' for tags input under the tree$")
    public void iClickButtonBackspace() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            try{
                editorPage.featureTagsInput.sendKeys(Keys.BACK_SPACE);
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

    @When("^I change textbox 'Feature' value to \"([^\"]*)\" in feature info block under the tree$")
    public void iChangeTextboxFeatureValueToInFeatureInfoBlockUnderTheTree(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(CommonHelper.delay, editorPage.changeFeatureNameBeforeFocusInput.getWrappedElement());
            editorPage.changeFeatureNameBeforeFocusInput.click();
            ReportService.ReportAction("Feature name input was selected.", true);
            Waiters.waitAppearanceOf(CommonHelper.delay, editorPage.changeFieldAfterFocusInput.getWrappedElement());
            editorPage.changeFieldAfterFocusInput.clear();
            editorPage.changeFieldAfterFocusInput.sendKeys(arg0);
            CommonHelper.testFeatureName = arg0;
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that changes are successfully saved in textbox 'Feature' in feature info block under the tree$")
    public void iSeeThatChangesAreSuccessfullySavedInTextboxFeatureInFeatureInfoBlockUnderTheTree() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(CommonHelper.delay, editorPage.changeFeatureNameBeforeFocusInput.getWrappedElement());
            String s = editorPage.getChangeFeatureInputBeforeFocusText("feature");
            ReportService.ReportAction("Changes in 'Feature' textbox were successfully saved.", editorPage.getChangeFeatureInputBeforeFocusText("feature").equals(CommonHelper.testFeatureName));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I change textbox 'File name' value to \"([^\"]*)\" in feature info block under the tree$")
    public void iChangeTextboxFileNameValueToInFeatureInfoBlockUnderTheTree(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            if(editorPage.changeFileNameBeforeFocusInput.isDisplayed()) {
                Waiters.waitAppearanceOf(CommonHelper.delay, editorPage.changeFileNameBeforeFocusInput.getWrappedElement());
                editorPage.changeFileNameBeforeFocusInput.click();
            }
            ReportService.ReportAction("File name input was selected.", true);
            Waiters.waitAppearanceOf(CommonHelper.delay, editorPage.changeFieldAfterFocusInput.getWrappedElement());
            editorPage.changeFieldAfterFocusInput.clear();
            editorPage.changeFieldAfterFocusInput.sendKeys(arg0);
            CommonHelper.testFeatureFileName = arg0;
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that changes are successfully saved in textbox 'File name' in feature info block under the tree$")
    public void iSeeThatChangesAreSuccessfullySavedInTextboxFileNameInFeatureInfoBlockUnderTheTree() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(CommonHelper.delay, editorPage.changeFileNameBeforeFocusInput.getWrappedElement());
            ReportService.ReportAction("Changes in 'File name' textbox were successfully saved.", editorPage.getChangeFeatureInputBeforeFocusText("file name").equals(CommonHelper.testFeatureFileName));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I change textbox 'Description' value to \"([^\"]*)\" in feature info block under the tree$")
    public void iChangeTextboxDescriptionValueToInFeatureInfoBlockUnderTheTree(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(CommonHelper.delay, editorPage.changeDescriptionBeforeFocusInput.getWrappedElement());
            editorPage.changeDescriptionBeforeFocusInput.click();
            ReportService.ReportAction("Description input was selected.", true);
            editorPage.changeFeatureDescriptionAfterFocusInput.clear();
            editorPage.changeFeatureDescriptionAfterFocusInput.sendKeys(arg0);
            CommonHelper.testFeatureDescription = arg0;
            ReportService.ReportAction("'" + arg0 + "' value was sent to description input.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that changes are successfully saved in textbox 'Description' in feature info block under the tree$")
    public void iSeeThatChangesAreSuccessfullySavedInTextboxDescriptionInFeatureInfoBlockUnderTheTree() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(CommonHelper.delay, editorPage.changeDescriptionBeforeFocusInput.getWrappedElement());
            ReportService.ReportAction("Changes in 'File name' textbox were successfully saved.", editorPage.getChangeFeatureInputBeforeFocusText("description").equals(CommonHelper.testFeatureDescription));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }


    @When("^I type \"([^\"]*)\" into tags input textbox in feature info block under the tree$")
    public void iTypeIntoTagsInputTextboxInFeatureInfoBlockUnderTheTree(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            if(CommonHelper.testFeatureTags==null)
                CommonHelper.testFeatureTags = new ArrayList<>();
            editorPage.featureTagsInput.clear();
            editorPage.featureTagsInput.sendKeys(arg0);
            CommonHelper.testFeatureTags.add(arg0);
            ReportService.ReportAction("'" + arg0 + "' value was sent to tags input.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }
}