package stepdefinition;

import com.unitedsofthouse.ucucumberpackage.tools.Waiters;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.CommonHelper;
import helpers.SystemHelper;
import arp.CucumberArpReport;
import arp.ReportService;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import pages.base.PageInstance;
import pages.relime.DashboardPage;
import pages.relime.EditorPage;
import pages.relime.ProfilePage;
import pages.relime.SettingsPage;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Smoke extends PageInstance {

    @Autowired
    DashboardPage dashboardPage;

    @Autowired
    EditorPage editorPage;

    @Autowired
    SettingsPage settingsPage;

    @Autowired
    ProfilePage profilePage;

    @And("^I type \"([^\"]*)\" as background name in textbox 'Name' in pop-up 'New Scenario'$")
    public void iTypeAsBackgroundNameInTextboxNameInPopUpNewScenario(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            editorPage.newScenarioNameInput.enterText(arg0);
            CommonHelper.testBackgroundName = arg0;
            ReportService.ReportAction("'" + arg0 + "' is set to the field 'Name' for background in pop-up 'New Scenario'.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I type \"([^\"]*)\" as background description in textbox 'Description' for background in pop-up 'New Scenario'$")
    public void iTypeAsBackgroundDescriptionInTextboxDescriptionInPopUpNewScenario(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            editorPage.descriptionInput.enterText(arg0);
            CommonHelper.testBackgroundDescription = arg0;
            ReportService.ReportAction("'" + arg0 + "' is set to the field 'Description' in pop-up 'New Scenario'.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that new background is successfully created$")
    public void iSeeThatNewBackgroundIsSuccessfullyCreated() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Scenario name is correct.", editorPage.verifyBackgroundName());
            ReportService.ReportAction("Scenario description is correct.", editorPage.verifyBackgroundDescription());
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that the new background is expanded$")
    public void iSeeThatTheNewBackgroundIsExpanded() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("The scenario is expanded.", editorPage.verifyIfScenarioAccordionIsExpanded());
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that background is displayed in separated control in the first position in Scenario Editor$")
    public void iSeeThatBackgroundIsDisplayedInSeparatedControlInTheFirstPositionInScenarioEditor() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(3, editorPage.backgroundElement.getWrappedElement());
            ReportService.ReportAction("The scenario is expanded.", editorPage.verifyIfBackgroundIsDisplayedInSeparatedControl());
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^And I see that new background is successfully created and entered data matches data in Scenario Editor for the new background$")
    public void andISeeThatNewBackgroundIsSuccessfullyCreatedAndEnteredDataMatchesDataInScenarioEditorForTheNewBackground() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Background name is correct.", editorPage.verifyBackgroundName());
            ReportService.ReportAction("Background description is correct.", editorPage.verifyBackgroundDescription());
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that example table is not displayed in the new background in Scenario Editor$")
    public void iSeeThatExampleTableIsNotDisplayedInTheNewBackgroundInScenarioEditor() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("The scenario is expanded.", !editorPage.verifyIfExampleTableIsDisplayed());
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I select folder \"([^\"]*)\" in the tree$")
    public void iSelectFolderInTheTree(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(CommonHelper.delay, editorPage.firstTreeNode.getWrappedElement());
            editorPage.selectTreeElementByName(arg0);
            CommonHelper.testFolderName = arg0;
            ReportService.ReportAction("Folder was selected.", editorPage.verifyIfTreeElementIsSelected(CommonHelper.testFolderName));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I change textbox 'Folder name' value to \"([^\"]*)\" in folder info block under the tree$")
    public void iChangeTextboxFolderNameValueToInFolderInfoBlockUnderTheTree(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            if(!editorPage.changeFieldAfterFocusInput.isDisplayed())
                editorPage.changeFolderNameInputBeforeFocus.click();
            editorPage.changeFieldAfterFocusInput.clear();
            editorPage.changeFieldAfterFocusInput.sendKeys(arg0);
            CommonHelper.testFolderName = arg0;
            ReportService.ReportAction("'" + arg0 + "' is set to the field 'Folder name' in folder info block under the tree.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I click button 'Enter'$")
    public void iClickButtonEnter() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            try{
                Thread.sleep(500);
                CommonHelper.sendKeyWithActions(Keys.ENTER);
                ReportService.ReportAction("'Enter' button was pressed.", true);
            }
            catch (Exception ex) {
                CommonHelper.sendKeyWithAWT(KeyEvent.VK_ENTER);
                ReportService.ReportAction("'Enter' button was pressed.", true);
            }
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that changes are successfully saved in textbox 'Folder name' in folder info block under the tree$")
    public void iSeeThatChangesAreSuccessfullySavedInTextboxFolderNameInFolderInfoBlockUnderTheTree() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Changes were successfully saved in textbox 'Folder name' in folder info block under the tree.",
                    editorPage.changeFolderNameInputBeforeFocus.isDisplayed()&&editorPage.changeFolderNameInputBeforeFocus.getText().equals(CommonHelper.testFolderName));
            /*ReportService.ReportAction("Changes were successfully saved in textbox 'Folder name' in folder info block under the tree.",
            editorPage.getChangeFolderNameInputBeforeFocus().isDisplayed()&&editorPage.getChangeFolderNameInputBeforeFocus().getText().equals(CommonHelper.testFolderName));*/
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I lose focus$")
    public void iLoseFocus() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            SystemHelper.waitAppearanceByElement(driver, 100, 30, editorPage.headerLabel.getWrappedElement());
            editorPage.headerLabel.click();
            ReportService.ReportAction("Focus was lost.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that new tag is added in tags input textbox in feature info block under the tree$")
    public void iSeeThatNewTagIsAddedInTagsInputTextboxInFeatureInfoBlockUnderTheTree() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Scenario tags are correct.", editorPage.verifyFeatureTags());
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I type \"([^\"]*)\" in textbox 'Name' in pop-up 'New Scenario'$")
    public void iTypeInTextboxNameInPopUpNewScenario(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            editorPage.newScenarioNameInput.enterText(arg0);
            CommonHelper.testScenarioName = arg0;
            ReportService.ReportAction("'" + arg0 + "' is set to the field 'Name' in pop-up 'New Scenario'.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I type \"([^\"]*)\" in textbox 'Description' in pop-up 'New Scenario'$")
    public void iTypeInTextboxDescriptionInPopUpNewScenario(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            editorPage.descriptionInput.enterText(arg0);
            CommonHelper.testScenarioDescription = arg0;
            ReportService.ReportAction("'" + arg0 + "' is set to the field 'Description' in pop-up 'New Scenario'.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I type \"([^\"]*)\" in the first string in Scenario Editor in pop-up 'New Scenario'$")
    public void iTypeInTheFirstStringInScenarioEditorInPopUpNewScenario(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            editorPage.formStepsTextarea.click();
            TextInput t = new TextInput(editorPage.formStepsTextarea.findElement(By.xpath("./textarea")));
            for (char c : arg0.toCharArray()) {
                String s = String.valueOf(c);
                t.sendKeys(s);
            }
            Thread.sleep(1000);
            ReportService.ReportAction("'" + arg0 + "' is set to the first string in Scenario Editor in pop-up 'New Scenario'.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I type \"([^\"]*)\" into string \"([^\"]*)\" in Scenario Editor in pop-up 'New Scenario'$")
    public void iTypeIntoStringInScenarioEditorInScenarioAccordion(String arg0, String arg1) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            if(arg0.equals("comment")){
                arg0 = "\"\"\" comment";
            }
            if(editorPage.formStepsTextarea.getAttribute("class").contains("ace_focus"))
                editorPage.formStepsTextarea.click();
            TextInput t = new TextInput(editorPage.formStepsTextarea.findElement(By.xpath("./textarea")));
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

    /*@When("^I click option 'Delete' under drop-down 'Actions' in scenario accordion$")
    public void iClickOptionDeleteUnderDropDownActionsInScenarioAccordion() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            SystemHelper.waitAppearanceByXpath(driver, 100, 30, "(.//div[contains(@class, 'ace_line')])[1]");
            editorPage.actionsButton.click();
            editorPage.actionDeleteInScenarioBlockButton.click();
            ReportService.ReportAction("Button 'Delete' under dropdown actions was clicked.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }*/

    @And("^I expand scenario \"([^\"]*)\"$")
    public void iExpandScenario(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(CommonHelper.delay, editorPage.firstScenario.getWrappedElement());
            SystemHelper.waitAppearanceByElement(driver, 30, 100, editorPage.firstScenario.getWrappedElement());
            editorPage.selectScenarioByName(arg0);
            ReportService.ReportAction("'" + arg0 + "' scenario was selected.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I change textbox 'Name' value to \"([^\"]*)\" in scenario accordion$")
    public void iChangeTextboxNameValueToInScenarioAccordion(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            editorPage.changeScenarioName(arg0);
            CommonHelper.testScenarioName = arg0;
            ReportService.ReportAction("Scenario name was changed.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I change textbox 'Description' value to \"([^\"]*)\" in scenario accordion$")
    public void iChangeTextboxDescriptionValueToInScenarioAccordion(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            editorPage.changeScenarioDescription(arg0);
            CommonHelper.testScenarioDescription = arg0;
            ReportService.ReportAction("Scenario description was changed.", true);
        } catch (AssertionError e) {
            throw e;

        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I type \"([^\"]*)\" into tags input textbox in scenario accordion$")
    public void iTypeIntoTagsInputTextboxInScenarioAccordion(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            //editorPage.deleteTagsFromScenario();
            editorPage.changeScenarioTags(arg0);
            if(CommonHelper.testScenarioTags == null){
                CommonHelper.testScenarioTags = new ArrayList<>();
            }
            CommonHelper.testScenarioTags.add(arg0);
            ReportService.ReportAction("Scenario tags were changed.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I click button 'Save scenarios'$")
    public void iClickButtonSaveScenarios() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            editorPage.saveScenariosButton.click();
            ReportService.ReportAction("Save scenarios button was clicked.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I click option \"([^\"]*)\" under drop-down 'Actions' in scenario accordion$")
    public void iClickOptionUnderDropDownActionsInScenarioAccordion(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            editorPage.clickActionsMenuOption(arg0);
            ReportService.ReportAction("'" + arg0 + "' option in 'Actions' menu was clicked.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that the scenario is collapsed$")
    public void iSeeThatTheScenarioIsCollapsed() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("The scenario is collapsed.", !editorPage.verifyIfScenarioAccordionIsExpanded());
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that the new scenario is expanded$")
    public void iSeeThatTheNewScenarioIsExpanded() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("The scenario is expanded.", editorPage.verifyIfScenarioAccordionIsExpanded());
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I type \"([^\"]*)\" into tags input textbox in pop-up 'New Scenario'$")
    public void iTypeIntoTagsInputTextboxInPopUpNewScenario(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            editorPage.tagsInputOnNewScenarioPopup.click();
            editorPage.tagsInputOnNewScenarioPopup.clear();
            CommonHelper.sendKeysWithActions(editorPage.tagsInputOnNewScenarioPopup.getWrappedElement(), arg0);
            if(CommonHelper.testScenarioTags == null){
                CommonHelper.testScenarioTags = new ArrayList<>();
            }
            CommonHelper.testScenarioTags.add(arg0);
            ReportService.ReportAction("Valid automation tags were populated.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that example table is displayed in the new scenario in Scenario Editor$")
    public void iSeeThatExampleTableIsDisplayedInTheNewScenarioInScenarioEditor() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Example table is displayed.", editorPage.verifyIfExampleTableIsDisplayed());
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that new scenario is created and entered data matches data in Scenario Editor for the new scenario$")
    public void iSeeThatNewScenarioIsCreatedAndEnteredDataMatchesDataInScenarioEditorForTheNewScenario() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Scenario name is correct.", editorPage.verifyScenarioName());
            ReportService.ReportAction("Scenario description is correct.", editorPage.verifyScenarioDescription());
            ReportService.ReportAction("Scenario tags are correct.", editorPage.verifyScenarioTags());
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that changes are successfully saved and changed data matches data in Scenario Editor for the edited scenario$")
    public void iSeeThatChangesAreSuccessfullySavedAndChangedDataMatchesDataInScenarioEditorForTheEditedScenario() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            editorPage.selectScenarioByName(CommonHelper.testScenarioName);
            ReportService.ReportAction("Scenario name is correct.", editorPage.verifyScenarioName());
            ReportService.ReportAction("Scenario description is correct.", editorPage.verifyScenarioDescription());
            ReportService.ReportAction("Scenario tags are correct.", editorPage.verifyScenarioTags());
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }
	
    @When("^I click button 'Save changes to Git' in page 'Feature Management'$")
    public void iClickOnButtonSaveChangesToGit() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(CommonHelper.delay, editorPage.saveChangesToGit.getWrappedElement());
            editorPage.saveChangesToGit.click();
            ReportService.ReportAction("'Save changes to Git' button in page 'Feature Management' was clicked.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see wait notification is displayed in page 'Feature Management'$")
    public void iSeeWaitNotificationIsDispayed() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(CommonHelper.delay, editorPage.infoNotification.getWrappedElement());
            ReportService.ReportAction("Wait notification was displayed.", editorPage.infoNotification.isDisplayed());
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that changes are sucessfully saved in textbox 'Name' in page 'Project settings'$")
    public void iSeeChangesAreSuccessfulySavedInTextboxNameInPageProjectSettings() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Project name successfule changed.", settingsPage.NameField.getText().equals(CommonHelper.testProjectName));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

	@When("^I click checkbox 'background' in pop-up 'New Scenario'$")
    public void iClickCheckboxBackgroundInPopUpNewScenario() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            SystemHelper.waitAppearanceByElement(driver, 100, 30, editorPage.backgroundOnNewScenarioPopupCheckbox.getWrappedElement());
            editorPage.backgroundOnNewScenarioPopupCheckbox.sendKeys(Keys.SPACE);
            ReportService.ReportAction("'Background' checkbox was clicked", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I can delete \"([^\"]*)\" from setting 'Task tracking system' in page 'Project settings'$")
    public void icanDeleteOptionFromSettingTTS(String name) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            SystemHelper.waitAppearanceByXpath(driver, 100, 30, "//div[@class= 'system-control-row']//a");
            boolean elementFound = false;
            for (Element e : settingsPage.jiraDivs) {
                if(e.findElement(By.xpath(".//div[@class= 'system-control-row']//a")).getText().toLowerCase().equals(name.toLowerCase())){
                    e.findElement(By.xpath(".//*[@data-uib-tooltip= 'Delete Jira path']")).click();
                }
            }
            Waiters.waitAppearanceOf(5, settingsPage.formHeader.getWrappedElement());
            boolean buttonClicked = false;
            for(Button e : settingsPage.FormButtons){
                String s = e.getText();
                if(s.toLowerCase().equals("delete")) {
                    e.click();
                    buttonClicked = true;
                }
            }
            if(!buttonClicked)
                ReportService.ReportAction("\"" + "Delete" + "\" button not found!", false);
            Waiters.waitDisappearsOf(5, settingsPage.formHeader.getWrappedElement(), 10);
            for (Element e : settingsPage.jiraDivs) {
                String s = e.findElement(By.xpath(".")).getText();
                if(s.equals("")){break;}
                else if(e.findElement(By.xpath(".//div[@class= 'system-control-row']//a")).getText().toLowerCase().equals(name.toLowerCase())){
                    elementFound = true;
                }
            }
            ReportService.ReportAction(name + " deleted from setting 'Task tracking system'", !elementFound);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I tie \"([^\"]*)\" account in TTS settings$")
    public void iTieAccountInTTSSettings(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            settingsPage.selectTTSAccount(arg0);
            ReportService.ReportAction("Account was selected.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that data from linked Jira issue matches data in new feature in feature info block under the tree$")
    public void iSeeThatDataFromLinkedJiraIssueMatchesDataInNewFeatureInFeatureInfoBlockUnderTheTree() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Feature name is correct.", editorPage.changeFeatureNameBeforeFocusInput.getWrappedElement().getText().equals(CommonHelper.testJiraLinkedFeatureName));
            ReportService.ReportAction("Feature filename is correct.", editorPage.changeFileNameBeforeFocusInput.getWrappedElement().getText().equals(CommonHelper.testJiraLinkedFeatureFilename));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that new jira-linked feature is successfully created$")
    public void iSeeThatNewJiraLinkedFeatureIsSuccessfullyCreated() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitWhileConditionIsTrue(CommonHelper.delay, editorPage.firstTreeNode.isDisplayed());
            ReportService.ReportAction("Feature was created.", editorPage.treeElementExists(CommonHelper.testJiraLinkedFeatureFilename));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I click icon 'Update from Git' in panel 'Features'$")
    public void iClickIconUpdateFromgitInPanelFeatures() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(2000, editorPage.updateFromGit.getWrappedElement());
            editorPage.updateFromGit.click();
            ReportService.ReportAction("'Update from Git' button in panel 'Features' was clicked.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that the tree is refreshed$")
    public void iSeeThatTheTreeIsRefreshed() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(500, editorPage.treeUpdating.getWrappedElement());
            Waiters.waitDisappearsOf(20000, editorPage.treeUpdating.getWrappedElement(), 500);
            ReportService.ReportAction("Tree successfully updated.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }
}
