package stepdefinition.FeaturesPage.ScenarioEditor;

import com.unitedsofthouse.ucucumberpackage.tools.Waiters;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.*;
import cucumber.api.PendingException;
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

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class NewScenarioPopup extends PageInstance{

    @Autowired
    EditorPage editorPage;

    @And("^I click button 'New Scenario'$")
    public void iClickButtonNewScenario() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            SystemHelper.waitAppearanceByElement(driver, 100, 30, editorPage.addNewScenarioButton.getWrappedElement());
            CommonHelper.testScenarioName = "Automation_test_scenario_" + CommonHelper.getDate();
            CommonHelper.clickWithActions(editorPage.addNewScenarioButton.getWrappedElement());
            CommonHelper.testScenarioTags = new ArrayList<>();
            ReportService.ReportAction("'Add new scenario' button was clicked.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I add element \"([^\"]*)\" to example data for \"([^\"]*)\"$")
    public void iPopulateValidDataInExampleTableDataCellsInPopUpNewScenario(String element, String example) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Element e = editorPage.getEmptyInputFieldForExampleByName(example);
            e.sendKeys(element);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that example table header \"([^\"]*)\" is present$")
    public void iSeeThatExampleTableIsPresent(String name) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Example table header '" + name + "' is present", editorPage.exampleTableHeaderIsPresent(name));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that example tab did not appear on popup 'New Scenario'$")
    public void iSeeThatExamplesTabDidNotAppearOnPopupNewScenario() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Example tab did not appear.", !editorPage.examplesTable.isDisplayed());
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that all the example tab elements appeared on popup 'New Scenario'$")
    public void iSeeThatAllTheExamplesTabElementsAppearedOnPopupNewScenario() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Example table appeared.", editorPage.examplesTable.isDisplayed());
            ReportService.ReportAction("Example table header appeared.", editorPage.examplesTableHeader.isDisplayed());
            ReportService.ReportAction("Example table description appeared.", editorPage.examplesTableDescription.isDisplayed());
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that new scenario is created$")
    public void iSeeThatNewScenarioIsCreated() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            SystemHelper.waitAppearanceByXpath(driver, 100, 30, ".//div[contains(@class, 'ace_line')][contains(text(), ' another step')]");
            ReportService.ReportAction("New scenario was created.", driver.findElement(By.xpath(".//div[contains(@class, 'ace_line')][contains(text(), ' another step')]")).isDisplayed());
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that all the autocomplete lines contain word \"([^\"]*)\" in pop-up 'New Scenario'$")
    public void iSeeThatAutocompleteContainsWord(String word) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean contains = true;
            for (Element e : editorPage.formStepAutocompleteLines) {
                if(e.isDisplayed()) {
                    String line = e.getText().toLowerCase();
                    if (!line.toLowerCase().contains(word.toLowerCase())) {
                        contains = false;
                        break;
                    }
                }
            }
            ReportService.ReportAction("All the steps in autocomplete contain '" + word + "'",  contains);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that autocomplete line \"([^\"]*)\" is marked as \"([^\"]*)\" in pop-up 'New Scenario'$")
    public void iSeeThatAutocompleteLineIsMarkedAs(String line, String mark) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(3, editorPage.formStepAutocomplete.getWrappedElement());
            boolean marked = false;
            for (Element e : editorPage.formStepAutocompleteLines) {
                String s = e.getText();
                //String value = e.getText().substring(0, e.getText().indexOf("/n"));
                //String actualMark = e.getText().substring(e.getText().indexOf("/n"));
                if(e.isDisplayed()) {
                    if (e.getText().startsWith(line)&&e.getText().endsWith(mark)) {
                        marked = true;
                        break;
                    }
                }
            }
            ReportService.ReportAction("'" + line + "' line in autocomplete is marked as '" + mark + "'",  marked);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I select step \"([^\"]*)\" in autocomplete in pop-up 'New Scenario'$")
    public void iSelectStepInAutocomplete(String word) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(3, editorPage.formStepAutocomplete.getWrappedElement());
            for (Element e : editorPage.formStepAutocompleteLines) {
                if(e.isDisplayed()) {
                    String line = e.getText();
                    if (line.startsWith(word)) {
                        CommonHelper.clickWithActions(e.getWrappedElement());
                        //e.click();
                        break;
                    }
                }
            }
            //ReportService.ReportAction("All the steps in autocomplete contain '" + word + "'",  contains);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that \"([0-9]{1,2})\" line equals \"([^\"]*)\" in Ace Editor in pop-up 'New Scenario'$")
    public void iSeeThatLineEqualsInAceEditorInPopup(int line, String text) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            if(text.equals("comment"))
                text = "\"\"\"";
            ReportService.ReportAction("Line " + line + "equals '" + text + "' in Ace Editor.",  editorPage.formStepLines.get(--line).getText().equals(text));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that \"([0-9]{1,2})\" line is marked as comment in Ace Editor in pop-up 'New Scenario'$")
    public void iSeeThatLineIsMarkedAsCommentInAceEditorInPopup(int line) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Label step = new Label(editorPage.formStepLines.get(--line).findElement(By.xpath(".//span")));
            ReportService.ReportAction("Line " + line + " is marked as comment in Ace Editor.",  step.getAttribute("class").equals("ace_comment"));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that created scenario contains no empty lines$")
    public void iSeeThatCreatedScenarioContainsNoEmptyLines() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean noEmptyLines = true;
            for (Element e : editorPage.tableStepLines) {
                if(e.getText().equals("")){
                    noEmptyLines = false;
                    break;
                }
            }
            ReportService.ReportAction("Scenario contains no empty lines.",  noEmptyLines);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that step \"([1-9])\" is marked red in Ace Editor in pop-up 'New Scenario'$")
    public void iSeeThatStepIsMarkedRedInAceEditor(int step) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Step " + step + "equals is marked red in Ace Editor.",  editorPage.formStepStatusLabels.get(--step).getAttribute("class").contains("btn-danger"));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that step \"([1-9])\" is marked green in Ace Editor in pop-up 'New Scenario'$")
    public void iSeeThatStepIsMarkedGreenInAceEditor(int step) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Step " + step + "equals is marked green in Ace Editor.",  editorPage.formStepStatusLabels.get(--step).getAttribute("class").contains("btn-success"));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }


    @Then("^I see that step \"([1-9])\" is not marked in Ace Editor in pop-up 'New Scenario'$")
    public void iSeeThatStepIsNotMarkedInAceEditor(int step) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Step " + step + "equals is marked green in Ace Editor.",  editorPage.formStepStatusLabels.get(--step).getAttribute("class").equals("ace_gutter-cell "));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that autocomplete is displayed in pop-up 'New Scenario'$")
    public void iSeeThatAutocompleteIsDisplayed() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(3, editorPage.formStepAutocomplete.getWrappedElement());
            ReportService.ReportAction("Autocomplete is displayed.'",  editorPage.formStepAutocomplete.isDisplayed());
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that autocomplete contains no keywords in pop-up 'New Scenario'$")
    public void iSeeThatAutocompleteContainsNoKeywords() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean contains = false;
            for (Element e : editorPage.formStepAutocompleteLines) {
                if(e.getText().startsWith("Given")
                        ||e.getText().startsWith("And")
                        ||e.getText().startsWith("When")
                        ||e.getText().startsWith("Then")){
                    contains = true;
                    break;
                }
            }
            ReportService.ReportAction("All the steps in autocomplete contain no keywords.",  !contains);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that autocomplete contains no duplicates in pop-up 'New Scenario'$")
    public void iSeeThatAutocompleteContainsNoDuplicates() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean contains = false;
            for (Element e : editorPage.formStepAutocompleteLines) {
                int quantity = 0;
                String s1 = e.getText();
                for (Element el : editorPage.formStepAutocompleteLines) {
                    String s2 = el.getText();
                    if(e.getText().equals(el.getText())){
                        quantity++;
                    }
                }
                if(quantity>1){
                    contains = true;
                    break;
                }
            }
            ReportService.ReportAction("All the steps in autocomplete contain no dulicates.",  !contains);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that checkbox 'background' has tooltip \"This story already has a background\" in pop-up 'New Scenario'$")
    public void iSeeThatCheckboxBackgroungHasTooltip() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("All the steps in autocomplete contain no dulicates.",  editorPage.backgroundOnNewScenarioPopupCheckbox.getAttribute("uib-popover").equals("This story already has a background"));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that checkbox 'background' is disabled in pop-up 'New Scenario'$")
    public void iSeeThatCheckboxBackgroundIsDisabled() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("All the steps in autocomplete contain no dulicates.",  !editorPage.backgroundOnNewScenarioPopupCheckbox.isEnabled());
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that numeric and literal regular expressions are replaced with placeholders in proposed steplines in autocomplete list in pop-up 'New Scenario'$")
    public void iSeeThatNumericAndLiteralExpressionsAreReplacedWithPlaceholders() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean contains = true;
            for (Element e : editorPage.formStepAutocompleteLines) {
                if(e.getText().contains("\"[")){
                    if(!e.getText().contains("string")) {
                        contains = false;
                        break;
                    }
                }
                else if(e.getText().contains("[")){
                    if(!e.getText().contains("number")) {
                        contains = false;
                        break;
                    }
                }
            }
            ReportService.ReportAction("All numeric and literal regular expressions are replaced with '[number]' and '\"[string]\"'  in autocomplete.",  contains);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that autocomplete types order is correct in pop-up 'New Scenario'$")
    public void iSeeThatAutocompleteTypesOrderIsCorrect() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(3, editorPage.formStepAutocomplete.getWrappedElement());
            boolean orderIsRight = true;
            String current = "local";
            for (Element e : editorPage.formStepAutocompleteLines) {
                if(!e.getText().endsWith(current)){
                    if(current.equals("local")){
                        if(e.getText().endsWith("automated")){
                            current = "automated";
                        }
                        else if(e.getText().endsWith("Not-automated")){
                            current = "Not-automated";
                        }
                        else{
                            orderIsRight = false;
                            break;
                        }
                    }
                    else if(current.equals("automated")){
                        if(e.getText().endsWith("local")){
                            orderIsRight = false;
                            break;
                        }
                        else if(e.getText().endsWith("Not-automated")){
                            current = "Not-automated";
                        }
                        else{
                            orderIsRight = false;
                            break;
                        }
                    }
                    else if(current.equals("Not-automated")){
                        if(e.getText().endsWith("local")){
                            orderIsRight = false;
                            break;
                        }
                        else if(e.getText().endsWith("automated")){
                            orderIsRight = false;
                            break;
                        }
                        else{
                            orderIsRight = false;
                            break;
                        }
                    }
                }
            }
            ReportService.ReportAction("All the steps in autocomplete are in right order by type.",  orderIsRight);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I click button 'Backspace' for steps input on Pop Up$")
    public void iClickButtonBackspaceFoSteps() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            try{
                TextInput t = new TextInput(editorPage.formStepsTextarea.findElement(By.xpath("./textarea")));
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
}