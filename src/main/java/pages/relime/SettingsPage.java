package pages.relime;

import com.unitedsofthouse.ucucumberpackage.typesfactory.factory.TypeFactory;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.*;
import helpers.SystemHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;

import java.util.List;

/**
 * Created by kozlov on 5/24/2016.
 */
public class SettingsPage extends RelimePage {

    public SettingsPage() {
        TypeFactory.containerInitHTMLElements(this);
    }

    @Lazy
    @FindBy(id = "btn-append-to-singl  e-button")
    public Button projectsDropdown;

    @Override
    protected WebElement elementForLoading() throws Exception {
        return loadingElement;
    }

    @Lazy
    @FindBy(xpath = ".//div[@class = 'column-holder'][1]/div[@class = 'content-col']/a")
    public Label NameField;

    @Lazy
    @FindBy(xpath = ".//div[@class = 'column-holder'][1]/div[@class = 'content-col']//input")
    public TextInput NameInput;

    @Lazy
    @FindBy(xpath = ".//div[@class = 'column-holder'][2]/div[@class = 'content-col']/span")
    public Label KeyField;

    @Lazy
    @FindBy(xpath = ".//div[@class = 'column-holder'][3]/div[@class = 'content-col']/a")
    public Label DescriptionField;

    @Lazy
    @FindBy(xpath = ".//div[@class = 'column-holder'][3]/div[@class = 'content-col']//textarea")
    public TextInput DescriptionInput;

    @Lazy
    @FindBy(xpath = ".//div[@class = 'column-holder'][4]/div[@class = 'content-col']//span[contains(@class, 'ui-select-match-text')]/span")
    public Label TypeField;

    @Lazy
    @FindBy(xpath = ".//div[@class = 'column-holder'][4]/div[@class = 'content-col']//span[contains(@class, 'ui-select-toggle')]")
    public TextInput TypeInput;

    @Lazy
    @FindBy(xpath = ".//div[@class = 'column-holder'][4]/div[@class = 'content-col']//a[@class = 'ui-select-choices-row-inner']")
    public List<Label> TypeOptions;

    @Lazy
    @FindBy(xpath = ".//div[@class = 'column-holder'][5]/div[@class = 'content-col']//a")
    public Label SavingModeField;

    @Lazy
    @FindBy(xpath = ".//div[@class = 'column-holder'][5]/div[@class = 'content-col']//span[contains(@class, 'ui-select-toggle')]")
    public TextInput SavingModeInput;

    @Lazy
    @FindBy(xpath = ".//div[@class = 'column-holder'][5]/div[@class = 'content-col']//a[@class = 'ui-select-choices-row-inner']")
    public List<Label> SavingModeOptions;

    @Lazy
    @FindBy(xpath = ".//rl-task-tracker//div[@class= 'content-col']")
    public List<PlaceHolder> jiraDivs;

    @Lazy
    @FindBy(xpath = ".//rl-task-tracker//div[@class='title-row']//*[@class= 'ng-binding']")
    public List<Label> jiraTypeLabels;

    @Lazy
    @FindBy(xpath = ".//rl-task-tracker//div[@class= 'system-control-row']//a")
    public List<Link> jiraAddressLabels;

    @Lazy
    @FindBy(xpath = ".//rl-task-tracker//div[@class= 'system-control-row']//input")
    public TextInput jiraAddressInput;

    @Lazy
    @FindBy(xpath = ".//rl-task-tracker//div[@class= 'system-control-row']//div[contains(@class, 'editable-error')]")
    public Label jiraAddressWarning;

    @Lazy
    @FindBy(xpath = ".//*[@data-uib-tooltip= 'Add Jira path'][@class='btn']")
    public Button addJiraButton;

    @Lazy
    @FindBy(xpath = ".//rl-task-tracker//button[contains(@class, 'dropdown-toggle')]")
    public Button jiraAccountDropdownButton;

    @Lazy
    @FindBy(xpath = ".//button[@class='btn btn-download']")
    public Button reloadProjectFromGit;

    @Lazy
    @FindBy(xpath = ".//rl-task-tracker//ul[@role= 'menu']/li/*")
    public List<Label> jiraAccountDropdownElements;

    @Lazy
    @FindBy(xpath = ".//rl-vcs-settings//*[@class= 'ng-binding']")
    public Label VCSTypeLabel;

    @Lazy
    @FindBy(xpath = ".//rl-vcs-settings//div[@class= 'system-control-row']//a")
    public Link VCSAddressLabel;

    @Lazy
    @FindBy(xpath = ".//button[@data-uib-tooltip= 'Add Git repository path']")
    public Button AddVCSButton;

    @Lazy
    @FindBy(xpath = ".//rl-vcs-settings//button[contains(@class, 'btn dropdown-toggle')]")
    public Button VCSAccountDropdownButton;

    @Lazy
    @FindBy(xpath = ".//rl-vcs-settings//ul[@role= 'menu']/li/*")
    public List<Label> VCSAccountDropdownElements;

    @Lazy
    @FindBy(xpath = ".//div[@class = 'ui-notification ng-scope success']")
    public PlaceHolder successNotificationWindow;

    @Lazy
    @FindBy(xpath = ".//div[@class = 'ui-notification ng-scope error']")
    public PlaceHolder errorNotificationWindow;

    @Lazy
    @FindBy(xpath = ".//div[@class = 'ui-notification ng-scope info']")
    public PlaceHolder infoNotificationWindow;

    public void selectTTSAccount(String account) throws Exception{
        SystemHelper.waitAppearanceByElement(driver, 100, 30, jiraAccountDropdownButton.getWrappedElement());
        jiraAccountDropdownButton.click();
        SystemHelper.waitAppearanceByXpath(driver, 100, 30, ".//rl-task-tracker//div[@uib-dropdown]//li/a[text()='" + account + "']");
        driver.findElement(By.xpath(".//rl-task-tracker//div[@uib-dropdown]//li/a[text()='" + account + "']")).click();
    }
}
