package pages.relime;

import com.unitedsofthouse.ucucumberpackage.typesfactory.factory.TypeFactory;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.*;
import helpers.SystemHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;
import pages.base.BasePage;

import java.util.List;

public class RelimePage extends BasePage {

    @Override
    protected WebElement elementForLoading() throws Exception {
        return loadingElement;
    }

    public final String FormFieldName = "./*[1]";
    public final String AddAccountFormFieldInput = "./div/*[not(@ng-hide)]";
    public final String AddProjectFormFieldInput = "./*[2]";
    public final String FormFieldDropdownElements = ".//li/*";

    @Lazy
    @FindBy(id = "btn-append-to-single-button")
    public WebElement loadingElement;

    @Lazy
    @FindBy(xpath = ".//rl-projects-list-dropdown//a[@ui-sref='app.dashboard']")
    public WebElement viewAllProjectsLink;

    @Lazy
    @FindBy(xpath = ".//div[contains(@class, 'user-block')]/button[@class='btn dropdown-toggle']")
    public WebElement profileDropdownButton;

    @Lazy
    @FindBy(xpath = ".//div[contains(@class, 'user-block')]/ul/li/*")
    public List<WebElement> profileDropdownElements;

    @Lazy
    @FindBy(xpath = ".//div[contains(@id, 'ngdialog')]//div[@class='modal-header']/*")
    public Label formHeader;

    @Lazy
    @FindBy(xpath = ".//form//*[contains(@class, 'ask-message')]")
    public Label formMessage;

    @Lazy
    @FindBy(xpath = ".//div[contains(@id, 'ngdialog')]//div[@class='form-group']")
    public List<PlaceHolder> formFields;

    @Lazy
    @FindBy(xpath = ".//div[contains(@id, 'ngdialog')]//div[@class='checkbox c-checkbox']/label")
    public CheckBox formSelectAllCheckbox;

    @Lazy
    @FindBy(xpath = ".//button[contains(@class, 'btn-signin')]")
    public Button signInButton;

    @Lazy
    @FindBy(xpath = ".//md-dialog[contains(@class, 'sign-in-dialog')]")
    public PlaceHolder signInDialog;

    @Lazy
    @FindBy(xpath = ".//md-dialog[contains(@class, 'sign-in-dialog')]//input[@id='userName']")
    public TextInput signInDialogEmailField;

    @Lazy
    @FindBy(xpath = ".//md-dialog[contains(@class, 'sign-in-dialog')]//input[@id='password']")
    public TextInput signInDialogPasswordField;

    @Lazy
    @FindBy(xpath = ".//md-dialog[contains(@class, 'sign-in-dialog')]//button[contains(@class, 'sign-in')]")
    public TextInput signInDialogSignInButton;

    @Lazy
    @FindBy(xpath = ".//header")
    public TextInput pageHeader;

    /*@Lazy
    @FindBy(xpath = ".//input[@name='name']")
    public WebElement AddAccountFormAccountName;

    @Lazy
    @FindBy(xpath = ".//input[@name='login']")
    public WebElement AddAccountFormUserName;

    @Lazy
    @FindBy(xpath = ".//input[@name='password']")
    public WebElement AddAccountFormPassword;*/

    @Lazy
    @FindBy(xpath = ".//div[contains(@id, 'ngdialog')]//button")
    public List<Button> FormButtons;

    @Lazy
    @FindBy(xpath = ".//form//*[contains(@class, 'text-danger')]")
    public List<Label> formFieldWarnings;

    @Lazy
    @FindBy(xpath = ".//*[contains(@class, 'text-danger')]")
    public List<Label> EditorFieldWarnings;

    @Lazy
    @FindBy(xpath = "//form//div[@class='form-group'][2]//span[@class = 'text-danger']")
    public Label SecondFieldWarning;

    @Lazy
    @FindBy(xpath = ".//header")
    public Label headerLabel;

    public void clickButton(String button){
        driver.findElement(By.xpath(".//button[text() = '" + button + "']")).click();
    }
}