package stepdefinition.ProjectDataEditing;

import com.unitedsofthouse.ucucumberpackage.tools.Waiters;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.*;
import cucumber.api.java.en.*;
import helpers.CommonHelper;
import arp.CucumberArpReport;
import arp.ReportService;
import helpers.SystemHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.*;
import pages.base.PageInstance;
import pages.relime.DashboardPage;
import pages.relime.ProfilePage;
import pages.relime.SettingsPage;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

//import java.sql.Connection;
//import java.sql.DriverManager;
import net.sourceforge.jtds.jdbcx.JtdsDataSource;
import net.sourceforge.jtds.jdbc.Driver;

/**
 * Created by kozlov on 6/24/2016.
 */
public class CreateNewProject extends PageInstance {

    @Autowired
    SettingsPage settingsPage;

    @Autowired
    DashboardPage dashboardPage;

    @Autowired
    ProfilePage profilePage;

    @And("^I see a notification message \"([^\"]*)\" under second field")
    public void iSeeNotificationMessages(String message) throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(2, dashboardPage.SecondFieldWarning.getWrappedElement());
            boolean WarningVisible = false;
            if(dashboardPage.SecondFieldWarning.isDisplayed()&&dashboardPage.SecondFieldWarning.getText().equals(message)) {
                WarningVisible = true;
            }
            ReportService.ReportAction("Notification appeared.", WarningVisible);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }
    /*default = defaultProject
    sDefault = defaultSmokeProject
    rDefaultOne = defaultRegressionProjectOne
    rDefaultTwo = defaultRegressionProjectTwo*/
    @And("^I check that project \"([^\"]*)\" is absent in DB$")
    public void iCheckThatProjectIsAbsentInDB(String Key) throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            if(Key.equals("default"))
                Key = SystemHelper.DEFAULTPROJECT;
            if(Key.equals("sDefault"))
                Key = SystemHelper.DEFAULTSMOKEPROJECT;
            if(Key.equals("rDefaultOne"))
                Key = SystemHelper.DEFAULTREGRESSIONPROJECTONE;
            if(Key.equals("rDefaultTwo"))
                Key = SystemHelper.DEFAULTREGRESSIONPROJECTTWO;
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:jtds:sqlserver://" + SystemHelper.DATABASEIP + ";databaseName=RelimeDb;user=" + SystemHelper.DATABASELOGIN + ";password=" + SystemHelper.DATABASEPASS + ";");
            con.prepareStatement("DELETE FROM [RelimeDb].[dbo].[Project] WHERE ProjectKey = '" + Key + "';").execute();
            ReportService.ReportAction("Project '" + Key + "' is absent in DB.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I click button 'Plus' in panel 'Projects' in page \"([^\"]*)\"$")
    public void iClickbuttonPlusInPanelProjects(String page) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            dashboardPage.addNewProjectButton.click();
            ReportService.ReportAction("Button 'Plus' in panel 'Projects' was clicked.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I type \"([^\"]*)\" into textbox 'Name' in pop-up 'New Project'$")
    public void iTypeIntoTextboxNameInPopupNewProject(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean valueChanged = false;
            for (Element e : dashboardPage.formFields) {
                if(e.findElement(By.xpath(dashboardPage.FormFieldName)).getText().toLowerCase().contains("name")){
                    e.findElement(By.xpath(dashboardPage.AddProjectFormFieldInput)).click();
                    e.findElement(By.xpath(dashboardPage.AddProjectFormFieldInput)).clear();
                    e.findElement(By.xpath(dashboardPage.AddProjectFormFieldInput)).sendKeys(arg0);
                    valueChanged = true;
                    CommonHelper.testProjectName = arg0;
                }
            }
            ReportService.ReportAction("Textbox 'Name' value was changed in pop-up 'New Project'.", valueChanged);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    /*default = defaultProject
    sDefault = defaultSmokeProject
    rDefaultOne = defaultRegressionProjectOne
    rDefaultTwo = defaultRegressionProjectTwo*/
    @When("^I type \"([^\"]*)\" into textbox 'Project key' in pop-up 'New Project'$")
    public void iTypeIntoTextboxKeyInPopupNewProject(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            if(arg0.equals("default"))
                arg0 = SystemHelper.DEFAULTPROJECT;
            if(arg0.equals("sDefault"))
                arg0 = SystemHelper.DEFAULTSMOKEPROJECT;
            if(arg0.equals("rDefaultOne"))
                arg0 = SystemHelper.DEFAULTREGRESSIONPROJECTONE;
            if(arg0.equals("rDefaultTwo"))
                arg0 = SystemHelper.DEFAULTREGRESSIONPROJECTTWO;
            boolean valueChanged = false;
            for (Element e : dashboardPage.formFields) {
                if(e.findElement(By.xpath(dashboardPage.FormFieldName)).getText().toLowerCase().contains("project key")){
                    e.findElement(By.xpath(dashboardPage.AddProjectFormFieldInput)).click();
                    e.findElement(By.xpath(dashboardPage.AddProjectFormFieldInput)).clear();
                    e.findElement(By.xpath(dashboardPage.AddProjectFormFieldInput)).sendKeys(arg0);
                    valueChanged = true;
                    CommonHelper.testProjectKey = arg0;
                }
            }
            ReportService.ReportAction("Textbox 'Project key' value was changed in pop-up 'New Project'.", valueChanged);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that characters in 'Project key' field in pop-up 'New Project' are in upper-case$")
    public void iSeeThatCharactersInProjectKeyAreInUpperCase() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean isUpperScale = false;
            for (Element e : dashboardPage.formFields) {
                if(e.findElement(By.xpath(dashboardPage.FormFieldName)).getText().toLowerCase().contains("project key")){
                    String value = e.findElement(By.xpath(dashboardPage.AddProjectFormFieldInput)).getText();
                    isUpperScale = e.findElement(By.xpath(dashboardPage.AddProjectFormFieldInput)).getText().toUpperCase().equals(value);
                }
            }
            ReportService.ReportAction("'Project key' is in upper case.", isUpperScale);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I type \"([^\"]*)\" into textbox 'Description' in pop-up 'New Project'$")
    public void iTypeIntoTextboxDescriptionInPopupNewProject(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean valueChanged = false;
            for (Element e : dashboardPage.formFields) {
                if(e.findElement(By.xpath(dashboardPage.FormFieldName)).getText().toLowerCase().contains("description")){
                    e.findElement(By.xpath(dashboardPage.AddProjectFormFieldInput)).click();
                    e.findElement(By.xpath(dashboardPage.AddProjectFormFieldInput)).clear();
                    e.findElement(By.xpath(dashboardPage.AddProjectFormFieldInput)).sendKeys(arg0);
                    valueChanged = true;
                    CommonHelper.testProjectDescription = arg0;
                }
            }
            ReportService.ReportAction("Textbox 'Description' value was changed in pop-up 'New Project'.", valueChanged);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I select item \"([^\"]*)\" in drop-down 'Project Type' in pop-up 'New Project'$")
    public void iSelectItemInDropdownBDDInPopupNewProject(String arg0) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean valueChanged = false;
            for (Element e : dashboardPage.formFields) {
                if(e.findElement(By.xpath(dashboardPage.FormFieldName)).getText().contains("PROJECT TYPE")){
                    e.findElement(By.xpath(dashboardPage.AddProjectFormFieldInput)).click();
                    for (WebElement li : e.findElements(By.xpath(dashboardPage.FormFieldDropdownElements))) {
                        if(li.getText().toLowerCase().equals(arg0.toLowerCase())) {
                            li.click();
                            valueChanged = true;
                            CommonHelper.testProjectType = arg0;
                            break;
                        }
                    }
                    break;
                }
            }
            ReportService.ReportAction("Item '" + arg0 + "' was selected in drop-down 'Project Type' in pop-up 'New Project'.", valueChanged);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that the project was successfully deleted")
    public void iSeeProjectIsDeleted() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean elementFound = false;
            if(dashboardPage.findRowInProjectPanelByProjectKey(CommonHelper.testProjectKey)!=null){
                elementFound = true;
            }
            ReportService.ReportAction("Project is deleted from the table 'Projects'.", !elementFound);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that project is added to panel 'Projects'")
    public void iSeeProjectDataIsCorrect() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean elementFound = false;
            if(dashboardPage.findRowInProjectPanelByProjectKey(CommonHelper.testProjectKey)!=null){
                elementFound = true;
            }
            ReportService.ReportAction("Created project is in the table.", elementFound);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I select project in panel 'Projects' in page \"Dashboard\"$")
    public void iSelectProjectInPanelProjects() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Element row = dashboardPage.findRowInProjectPanelByProjectKey(CommonHelper.testProjectKey);
            boolean elementFound = false;
            if(row!=null){
                row.findElement(By.xpath(dashboardPage.EDITBUTTON)).click();
                elementFound = true;
            }
            ReportService.ReportAction("Project selected from the table.", elementFound);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I delete project in panel 'Projects' in page \"Dashboard\"$")
    public void iDeleteProjectInPanelProjects() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Element row = dashboardPage.findRowInProjectPanelByProjectKey(CommonHelper.testProjectKey);
            boolean elementFound = false;
            if(row!=null){
                elementFound = true;
                row.findElement(By.xpath(dashboardPage.DELETEBUTTON)).click();
            }
            /*boolean elementFound = false;
            for (int i = 0; i< profilePage.credentialsTableRows.size(); i++) {
                Label e = profilePage.credentialsTableRows.get(i);
                if(e.getText().equals(CommonHelper.testAccountName)){
                    profilePage.credentialsTableRowsDeleteButtons.get(i).click();
                    elementFound=true;
                    break;
                }
            }*/
            ReportService.ReportAction("Project deleted from the table.", elementFound);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @When("^I select item \"([^\"]*)\" under drop-down 'Name' in pop-up \"([^\"]*)\"$")
    public void iSelectItemUnderDropdownNameInPopup(String arg0, String popup) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean elementFound = false;
            for (Element e : settingsPage.formFields) {
                if(e.findElement(By.xpath(settingsPage.FormFieldName)).getText().contains("NAME")){
                    e.findElement(By.xpath(settingsPage.AddProjectFormFieldInput)).click();
                    for (WebElement li : e.findElements(By.xpath(settingsPage.FormFieldDropdownElements))) {
                        if(li.getText().toLowerCase().equals(arg0.toLowerCase())) {
                            li.click();
                            elementFound = true;
                            break;
                        }
                    }
                    break;
                }
            }
            ReportService.ReportAction("'" + arg0 + "item was selected under drop-down 'Name' in pop-up '" + popup + "'.", elementFound);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see item \"([^\"]*)\" is absent under drop-down 'Name' in pop-up \"([^\"]*)\"$")
    public void iSeeItemIsAbsentUnderDropdownNameInPopup(String arg0, String popup) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean elementFound = false;
            for (Element e : settingsPage.formFields) {
                if(e.findElement(By.xpath(settingsPage.FormFieldName)).getText().contains("NAME")){
                    e.findElement(By.xpath(settingsPage.AddProjectFormFieldInput)).click();
                    for (WebElement li : e.findElements(By.xpath(settingsPage.FormFieldDropdownElements))) {
                        if(li.getText().toLowerCase().equals(arg0.toLowerCase())) {
                            elementFound = true;
                            break;
                        }
                    }
                    e.findElement(By.xpath(settingsPage.AddProjectFormFieldInput)).submit();
                    break;
                }
            }
            ReportService.ReportAction("Element '" + arg0 + "' is absent.", !elementFound);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }
}
