package pages.relime;

import com.unitedsofthouse.ucucumberpackage.tools.Waiters;
import com.unitedsofthouse.ucucumberpackage.typesfactory.factory.TypeFactory;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.*;
import helpers.CommonHelper;
import helpers.Node;
import helpers.SystemHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;

import java.util.List;

public class EditorPage extends RelimePage {

    public EditorPage() {
        TypeFactory.containerInitHTMLElements(this);
    }

    @Override
    protected WebElement elementForLoading() throws Exception {
        return addNewFolderButton.getWrappedElement();
    }

    public final String TREE_ELEMENT_NAME = "./a/div/span";
    public final String TREE_ELEMENT_SUBELEMENTS = "./ul/li";

    @Lazy
    @FindBy(xpath = "(.//span[contains(@class, 'tree-node-content')])[1]")
    public Button firstTreeNode;

    @Lazy
    @FindBy(xpath = "(.//h3[contains(text(), 'Scenarios')]/following-sibling::div//div[contains(@class, 'scnearioName')])[1]")
    public Button firstScenario;

    @Lazy
    @FindBy(xpath = ".//div[contains(@id, 'accordion-')][contains(@class, 'panel-open')]")
    public List<PlaceHolder> expandedScenarios;

    @Lazy
    @FindBy(xpath = ".//button[@data-uib-tooltip = 'New folder']")
    public Button addNewFolderButton;

    @Lazy
    @FindBy(xpath = ".//button[@data-uib-tooltip='New feature']")
    public Button addNewFeatureButton;

    @Lazy
    @FindBy(xpath = ".//button[@data-uib-tooltip = 'Update from GIT']")
    public Button updateFromGit;

    @Lazy
    @FindBy(xpath = ".//button[@data-uib-tooltip = 'Update from Jira']")
    public Button updateFromJira;

    @Lazy
    @FindBy(xpath = ".//ul[contains(@class, 'whirl')]")
    public Label treeUpdating;

    @Lazy
    @FindBy(xpath = ".//auto-complete//ul")
    public List<Label> tagAutocompleteElements;

    @Lazy
    @FindBy(xpath = ".//form//ti-tag-item")
    public List<Label> addedTagsOnPopup;

    @Lazy
    @FindBy(xpath = ".//rl-stories-explorer//ti-tag-item")
    public List<Label> featureAddedTags;

    @Lazy
    @FindBy(xpath = ".//div[contains(@class, 'scenario-column')]//ti-tag-item")
    public List<Label> scenarioAddedTags;

    @Lazy
    @FindBy(xpath = ".//button[@data-uib-tooltip='Save changes to Git']")
    public Button saveChangesToGit;

    @Lazy
    @FindBy(xpath = ".//div[@class='ui-notification ng-scope info']")
    public PlaceHolder infoNotification;

    @Lazy
    @FindBy(xpath = ".//rl-example-table")
    public PlaceHolder examplesTable;

    @Lazy
    @FindBy(xpath = ".//form//rl-example-table/div/h3[text()='example table']")
    public PlaceHolder examplesTableHeader;

    @Lazy
    @FindBy(xpath = ".//form//rl-example-table//textarea[@id='extdescription']")
    public PlaceHolder examplesTableDescription;

    @Lazy
    @FindBy(xpath = ".//button[@data-uib-tooltip='Delete']")
    public Button deleteTreeNodeButton;

    @Lazy
    @FindBy(xpath = ".//button[@data-uib-tooltip='New Scenario']")
    public Button addNewScenarioButton;

    @Lazy
    @FindBy(id = "folder-name")
    public TextInput folderNameInput;

    @Lazy
    @FindBy(id = "name")
    public TextInput nameInput;

    @Lazy
    @FindBy(id = "description")
    public TextInput descriptionInput;

    @Lazy
    @FindBy(xpath = ".//span[@class = 'text-danger ng-binding']")
    public Label inputNotificationMessage;

    @Lazy
    @FindBy(xpath = ".//div[contains(@class, 'dialog-holder')]//input[contains(@style, 'width:')][@placeholder='Type and press Enter']")
    public TextInput tagsInputOnNewScenarioPopup;

    @Lazy
    @FindBy(id = "file-name")
    public TextInput fileNameInput;

    @Lazy
    @FindBy(id = "tags-fiels")
    public TextInput tagsInput;

    @Lazy
    @FindBy(xpath = ".//form//div[@id= 'editor_']")
    public TextInput formStepsTextarea;

    @Lazy
    @FindBy(xpath = ".//div[contains(@id,  'editor_')]")
    public TextInput scenarioStepsTextarea;

    @Lazy
    @FindBy(xpath = ".//form//div[contains(@class, 'ace_line_group')]")
    public List<Label> formStepLines;

    @Lazy
    @FindBy(xpath = ".//div[contains(@class, 'ace_line_group')]")
    public List<Label> scenarioStepLines;

    @Lazy
    @FindBy(xpath = ".//div[contains(@class, 'ace_line_group')]")
    public List<Label> tableStepLines;

    @Lazy
    @FindBy(xpath = ".//form//div[contains(@class, 'ace_gutter-cell')]")
    public List<Label> formStepStatusLabels;

    @Lazy
    @FindBy(xpath = ".//div[contains(@class, 'footer-data')]/div")
    public List<PlaceHolder> treeElementFields;

    @Lazy
    @FindBy(xpath = ".//form//*[contains(@class, 'checkbox')]/label")
    public List<PlaceHolder> formCheckboxes;

    @Lazy
    @FindBy(xpath = ".//div[contains(@class, 'ace_gutter-cell')]")
    public List<Label> scenarioStepStatusLabels;

    @Lazy
    @FindBy(xpath = ".//div[contains(@class, 'ace_autocomplete')][not(contains(@style, 'display: none;'))]//div[contains(@class, 'ace_content')]//div[contains(@class, 'ace_line')]")
    public List<Label> formStepAutocompleteLines;

    @Lazy
    @FindBy(xpath = ".//div[contains(@class, 'ace_autocomplete')][not(contains(@style, 'display: none;'))]//div[contains(@class, 'ace_content')]")
    public PlaceHolder formStepAutocomplete;

    @Lazy
    @FindBy(xpath = ".//h4[contains(text(), 'New Feature')]")
    public Label newFeatureLabel;

    @Lazy
    @FindBy(xpath = ".//rl-scenarios-explorer//div[contains(@class, 'panel-heading')]/h1")
    public Label featureNameLabel;

    @Lazy
    @FindBy(id = "nameNewScenario")
    public TextInput newScenarioNameInput;

    @Lazy
    @FindBy(xpath = ".//div[contains(@id, 'accordion-')][contains(@class, 'accordion-block-active')]//*[@id='nameScenario']")
    public Label activeScenarioNameLabel;

    @Lazy
    @FindBy(xpath = ".//div[contains(@id, 'accordion-')][contains(@class, 'accordion-block-active')]")
    public Label activeScenario;

    @Lazy
    @FindBy(xpath = ".//form//rl-jira-autocomplete/input")
    public TextInput jiraKeyNameInput;

    @Lazy
    @FindBy(xpath = ".//h3[text()='feature']/parent::*/parent::*//a[contains(@class, 'editable-click')]")
    public TextInput changeFeatureNameBeforeFocusInput;

    @Lazy
    @FindBy(xpath = ".//h3[text()='file name']/parent::*/parent::*//a[contains(@class, 'editable-click')]")
    public TextInput changeFileNameBeforeFocusInput;

    @Lazy
    @FindBy(xpath = ".//h3[text()='description']/parent::*/parent::*//a[contains(@class, 'editable-click')]")
    public TextInput changeDescriptionBeforeFocusInput;

    @Lazy
    @FindBy(xpath = ".//h3[contains(text(), 'Scenarios')]/following-sibling::div//div[contains(@class, 'scnearioName')]")
    public List<Link> scenariosList;

    @Lazy
    @FindBy(xpath = ".//span[contains(@class, 'counter')][text()='BG']/parent::div//div[contains(@class, 'scnearioName')]")
    public Link backgroundElement;

    @Lazy
    @FindBy(xpath = ".//span[contains(text(), 'BG')]/parent::*/parent::*/parent::*//a[contains(@class, 'description-project-content')]")
    public Link backgroundDescription;

    @Lazy
    @FindBy(xpath = ".//div[contains(@class, 'accordion-block-active')]//a[contains(text(), 'Delete')]")
    public Button actionDeleteInScenarioBlockButton;

    @Lazy
    @FindBy(xpath = ".//div[contains(@class, 'editable-controls')]/span/button[1]")
    public Button saveFeatureEditedFieldButton;

    @Lazy
    @FindBy(xpath = ".//form[contains(@class, 'editable-text')]/*[1]/span/button[2]")
    public Button cancelEditedFieldButton;

    @Lazy
    @FindBy(xpath = ".//div[contains(@class, 'accordion-block-active')]//i[@data-uib-tooltip='Edit scenario title']")
    public Link changeScenarioNameBeforeFocusButton;

    @Lazy
    @FindBy(xpath = ".//div[contains(@class, 'accordion-block-active')]//input[contains(@class, 'editable-input')]")
    public TextInput changeScenarioNameInputAfterFocus;

    @Lazy
    //@FindBy(xpath = ".//div[contains(@class, 'description-project-content')]")
    @FindBy(xpath = ".//div[contains(@class, 'accordion-block-active')]//a[contains(@class, 'description-project-content')]")
    public Link changeScenarioDescriptionInputBeforeFocus;

    @Lazy
    @FindBy(xpath = ".//div[contains(@class, 'accordion-block-active')]//button[contains(@class, 'btn-success')]")
    public TextInput submitChangeScenarioDescriptionButton;

    @Lazy
    @FindBy(xpath = ".//textarea[contains(@class, 'editable-input')]")
    public TextInput changeScenarioDescriptionInputAfterFocus;

    @Lazy
    @FindBy(xpath = ".//div[contains(@class, 'accordion-block-active')]//input[contains(@ng-model, 'newTag.text')]")
    public TextInput scenarioTagsInput;

    @Lazy
    @FindBy(xpath = ".//rl-stories-explorer//tags-input[@name='tags']//input")
    public TextInput featureTagsInput;

    @Lazy
    @FindBy(xpath = ".//button[@data-uib-tooltip='Save scenarios']")
    public Button saveScenariosButton;

    @Lazy
    @FindBy(xpath = ".//div[contains(@class, 'dialog-holder')]//input[@type='checkbox']")
    public TextInput backgroundOnNewScenarioPopupCheckbox;

    @Lazy
    @FindBy(xpath = ".//div[contains(@class, 'dialog-holder')]//input[@type='checkbox']")
    public TextInput jiraLinkedFeatureCheckbox;

    @Lazy
    @FindBy(xpath = ".//li[contains(@class, 'active')]//span[contains(@class, 'tree-node-content')]")
    public Label currentNodeLabel;

    @Lazy
    @FindBy(xpath = ".//div[@class = 'footer-data']")
    public PlaceHolder featureDataPanel;

    @Lazy
    @FindBy(xpath = ".//div[contains(@class, 'angular-ui-tree')]/div[3]/ul/li")
    public PlaceHolder topTreeFolder;

    @Lazy
    @FindBy(xpath = ".//rl-scenarios-explorer//div[contains(@class, 'btn-holder')]")
    public PlaceHolder scenariosListControlElements;

    @Lazy
    @FindBy(xpath = ".//ul[contains(@class, 'pagination')]/li")
    public List<Label> scenariosListPages;

    @Lazy
    @FindBy(xpath = ".//li[contains(@class, 'angular-ui-tree-node')]/a")
    public List<Label> treeElements;

    @Lazy
    @FindBy(xpath = ".//li[contains(@class, 'angular-ui-tree-node')][contains(@class, 'active')]/a")
    public Label activeTreeElement;

    @Lazy
    @FindBy(xpath = ".//div[contains(@class, 'accordion-block-active')]//button[contains(text(), 'Actions')]")
    public Button actionsButton;

    @Lazy
    @FindBy(xpath = ".//div[contains(@class, 'accordion-block-active')]//div[contains(@class, 'dropdown open')]//a")
    public List<Button> actionOptions;

    @Lazy
    @FindBy(xpath = ".//ul[contains(@class, 'pagination')]")
    public Label scenariosListPaginationElement;

    @Lazy
    @FindBy(xpath = ".//uib-accordion//h3[contains(@class, 'title')]")
    public Label scenariosLabel;

    @Lazy
    @FindBy(xpath = ".//div[@class='column-holder'][1]//a")
    public Link changeFolderNameInputBeforeFocus;

    @Lazy
    @FindBy(xpath = ".//input[@type='text'][contains(@class, 'editable-input')]")
    public TextInput changeFieldAfterFocusInput;

    @Lazy
    @FindBy(xpath = ".//form[contains(@class, 'editable-textarea')]//textarea")
    public TextInput changeFeatureDescriptionAfterFocusInput;

    //Parameter: "feature" / "file name" / "description"
    public String getChangeFeatureInputBeforeFocusText(String inputName){
        return driver.findElement(By.xpath(".//h3[text()='" + inputName + "']/parent::*/parent::*//a[contains(@class, 'editable-click')]")).getText();
    }

    public boolean treeElementExists(String folderName){
        try {
            Thread.sleep(500);
            driver.findElement(By.xpath(".//span[text() = '" + folderName + "']"));
            return true;
        }
        catch(Exception ex) {
            return false;
        }
    }

    public boolean scenarioExists(String scenarioName) throws Exception{
        Thread.sleep(500);
        for (Link l : scenariosList) {
            if (l.getText().equals(scenarioName))
                return true;
        }
        return false;
    }

    public void selectScenarioByName(String scenarioName) throws Exception {
        if(scenarioName == "")
            scenarioName = "(no name)";
        for (Link l : scenariosList) {
            if(l.getText().equals(scenarioName))
                l.click();
        }
    }

    public void selectTreeElementByName(String treeElementName) throws Exception {
        for (Label l : treeElements) {
            if(l.getText().equals(treeElementName))
                l.click();
        }
    }

    public Element getEmptyInputFieldForExampleByName(String name) throws Exception {
        List<WebElement> exampleLabels = examplesTable.findElements(By.xpath("./thead//th"));
        int index = 0;
        for (int i = 1; i < exampleLabels.size(); i++) {
            if(exampleLabels.get(i).getText().equals(name)){
                index = i;
                break;
            }
        }
        if(index>0) {
            index++;
            Label input = new Label(driver.findElement(By.xpath("(.//table[@class=\"example-table\"]/tbody//tr/td[" + index + "]//div/span[not(text())])[1]")));
            input.findElement(By.xpath("./parent::div"))
                    .click();
            input = new Label(driver.findElement(By.xpath("(.//table[@class=\"example-table\"]/tbody//tr/td[" + index + "]//div/input)[1]")));
            Waiters.waitAppearanceOf(5, input.getWrappedElement());
            return input;
        }
        else{
            return null;
        }
    }

    public boolean exampleTableHeaderIsPresent(String name) throws Exception {
        List<WebElement> exampleLabels = examplesTable.findElements(By.xpath("./thead//th"));
        boolean present = false;
        for (int i = 1; i < exampleLabels.size(); i++) {
            String s = exampleLabels.get(i).getText();
            if(exampleLabels.get(i).getText().equals(name)){
                present = true;
                break;
            }
        }
        return present;
    }

    public boolean verifyIfTreeElementIsSelected(String treeNodeName) throws Exception {
        Waiters.waitAppearanceOf(5, activeTreeElement.getWrappedElement());
        if(activeTreeElement.isDisplayed()&&activeTreeElement.getText().equals(treeNodeName))
            return true;
        return false;
    }

    public void changeScenarioName(String scenarioName) throws Exception {
        Waiters.waitAppearanceOf(10, changeScenarioNameBeforeFocusButton.getWrappedElement());
        changeScenarioNameBeforeFocusButton.click();
        Waiters.waitAppearanceOf(5, changeScenarioNameInputAfterFocus.getWrappedElement());
        changeScenarioNameInputAfterFocus.clear();
        changeScenarioNameInputAfterFocus.sendKeys(scenarioName);
        submitChangeScenarioDescriptionButton.sendKeys(Keys.ENTER);
        CommonHelper.testScenarioName = scenarioName;
    }

    public void changeScenarioDescription(String scenarioDescription) throws Exception {
        Waiters.waitAppearanceOf(CommonHelper.delay, changeScenarioDescriptionInputBeforeFocus.getWrappedElement());
        changeScenarioDescriptionInputBeforeFocus.click();
        Waiters.waitAppearanceOf(CommonHelper.delay, changeScenarioDescriptionInputAfterFocus.getWrappedElement());
        changeScenarioDescriptionInputAfterFocus.clear();
        changeScenarioDescriptionInputAfterFocus.sendKeys(scenarioDescription);
        submitChangeScenarioDescriptionButton.click();
    }

    public void changeScenarioTags(String scenarioTags) throws Exception {
        Waiters.waitAppearanceOf(CommonHelper.delay, scenarioTagsInput.getWrappedElement());
        scenarioTagsInput.clear();
        scenarioTagsInput.sendKeys(scenarioTags);
    }

    //Parameter: "Save" / "Rollback" / "Show History" / "Delete" / "Execute"
    public void clickActionsMenuOption(String option) throws Exception {
        SystemHelper.waitAppearanceByElement(driver, 100, 30, actionsButton.getWrappedElement());
        actionsButton.click();
        Thread.sleep(1000);
        for (Button b : actionOptions) {
            if(b.getText().equals(option)) {
                b.click();
                break;
            }
        }
    }

    public boolean verifyIfScenarioAccordionIsExpanded() throws Exception {
        try {
            Thread.sleep(1000);
            Waiters.waitAppearanceOf(10, activeScenario.getWrappedElement());
            if(activeScenario.isDisplayed())
                return true;
        }
        catch(Exception ex) {
            return false;
        }
        return false;
    }

    public boolean verifyIfExampleTableIsDisplayed() throws Exception {
        try {
            Waiters.waitAppearanceOf(5, examplesTable.getWrappedElement());
            if(examplesTable.isDisplayed())
                return true;
        }
        catch(Exception ex) {
            return false;
        }
        return false;
    }

    public boolean verifyIfBackgroundIsDisplayedInSeparatedControl() throws Exception {
        Waiters.waitAppearanceOf(5, backgroundElement.getWrappedElement());
        try {
            if(backgroundElement.isDisplayed())
                return true;
        }
        catch(Exception ex) {
            return false;
        }
        return false;
    }

    public boolean verifyScenarioName() throws Exception {
        Waiters.waitAppearanceOf(5, activeScenarioNameLabel.getWrappedElement());
        try{
            if(CommonHelper.testScenarioName.equals(""))
                CommonHelper.testScenarioName = "(no name)";

            if (activeScenarioNameLabel.getText().equals(CommonHelper.testScenarioName))
                return true;
            else
                return false;
        }
        catch(Exception ex){
            return false;
        }
    }

    public boolean verifyScenarioDescription() throws Exception {
        Waiters.waitAppearanceOf(5, changeScenarioDescriptionInputBeforeFocus.getWrappedElement());
        try{
            if(CommonHelper.testScenarioDescription.equals(""))
                CommonHelper.testScenarioDescription = "(no description)";
            if (changeScenarioDescriptionInputBeforeFocus.getText().equals(CommonHelper.testScenarioDescription))
                return true;
            else
                return false;
        }
        catch(Exception ex){
            return false;
        }
    }

    public boolean verifyScenarioTags() throws Exception {
        Waiters.waitAppearanceOf(5, scenarioTagsInput.getWrappedElement());
        try{
            boolean tagsArePresent = true;
            for (String s : CommonHelper.testScenarioTags) {
                boolean tagPresent = false;
                for (Element e : scenarioAddedTags) {
                    if(e.getText().substring(0, e.getText().indexOf("\n")).equals(s)){
                        tagPresent = true;
                        break;
                    }
                }
                if(!tagPresent){
                    tagsArePresent = false;
                    break;
                }
            }
            if (tagsArePresent){
                return true;
            }
            return false;
        }
        catch(Exception ex){
            return false;
        }
    }

    public boolean verifyBackgroundName() throws Exception {
        Waiters.waitAppearanceOf(5, this.backgroundElement.getWrappedElement());
        try{
            if (this.backgroundElement.getText().equals(CommonHelper.testBackgroundName))
                return true;
            else
                return false;
        }
        catch(Exception ex){
            return false;
        }
    }

    public boolean verifyBackgroundDescription() throws Exception {
        Waiters.waitAppearanceOf(5, this.backgroundDescription.getWrappedElement());
        try{
            if (this.backgroundDescription.getText().equals(CommonHelper.testBackgroundDescription))
                return true;
            else
                return false;
        }
        catch(Exception ex){
            return false;
        }
    }

    public boolean verifyFeatureTags() throws Exception {
        Waiters.waitAppearanceOf(5, featureTagsInput.getWrappedElement());
        try{
            boolean tagsArePresent = true;
            for (String s : CommonHelper.testFeatureTags) {
                boolean tagPresent = false;
                for (Element e : featureAddedTags) {
                    if(e.getText().substring(0, e.getText().indexOf("\n")).equals(s)){
                        tagPresent = true;
                        break;
                    }
                }
                if(!tagPresent){
                    tagsArePresent = false;
                    break;
                }
            }
            if (tagsArePresent){
                return true;
            }
            return false;
        }
        catch(Exception ex){
            return false;
        }
    }

    public void checkJiraLinkedFeatureCheckbox() throws Exception {
        SystemHelper.waitAppearanceByElement(driver, 100, 30, jiraLinkedFeatureCheckbox.getWrappedElement());
        Thread.sleep(500);
        jiraLinkedFeatureCheckbox.sendKeys(Keys.SPACE);
    }

    public boolean verifyCreateJiraLinkedFeaturePopup() throws Exception {
        for (int i=0; i<30; i++) {
            try {
                if (fileNameInput.getAttribute("value").startsWith("REL-")) {
                    return true;
                }
            }
            catch (Exception e) {}
            finally {
                Thread.sleep(100);
            }
        }
        return false;
    }

    public Node getFolderStructureFromEditPage() throws Exception {
        Waiters.waitAppearanceOf(5, topTreeFolder.getWrappedElement());
        Node<String> root = new Node(topTreeFolder.findElement(By.xpath(TREE_ELEMENT_NAME)).getText());
        try{
            for (int i = 0; i < topTreeFolder.findElements(By.xpath(TREE_ELEMENT_SUBELEMENTS)).size(); i++) {
                WebElement e = topTreeFolder.findElements(By.xpath(TREE_ELEMENT_SUBELEMENTS)).get(i);
                Node<String> node = new Node(e.findElement(By.xpath(this.TREE_ELEMENT_NAME)).getText());
                node.setParent(root);
                try {
                    getFolderStructureFromInnerFolders(node, e);
                } catch (Exception ex){}
            }
            return root;
        }
        catch (Exception e){
            return root;
        }

    }

    private void getFolderStructureFromInnerFolders(Node parent, WebElement element) throws Exception {
        try {
            for (int i = 0; i < element.findElements(By.xpath(TREE_ELEMENT_SUBELEMENTS)).size(); i++) {
                WebElement e = element.findElements(By.xpath(TREE_ELEMENT_SUBELEMENTS)).get(i);
                Node<String> node = new Node(e.findElement(By.xpath(this.TREE_ELEMENT_NAME)).getText());
                node.setParent(parent);
                try {
                    getFolderStructureFromInnerFolders(node, e);
                } catch (Exception ex){}
            }
        } catch (Exception ex){}
    }

    public boolean verifyIfBackgroundHasLabelBG() throws Exception {
        Waiters.waitAppearanceOf(5, backgroundElement.getWrappedElement());
        try {
            if(backgroundElement.isDisplayed())
                return true;
        }
        catch(Exception ex) {
            return false;
        }
        return false;
    }
}
