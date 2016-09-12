package stepdefinition.GitImplementation;

import arp.CucumberArpReport;
import arp.ReportService;
import com.unitedsofthouse.ucucumberpackage.tools.Waiters;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.Element;
import cucumber.api.java.en.*;
import helpers.CommonHelper;
import helpers.SystemHelper;
import org.apache.commons.collections.map.HashedMap;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import pages.base.PageInstance;
import pages.relime.DashboardPage;
import pages.relime.EditorPage;
import pages.relime.GitHubPage;
import pages.relime.SettingsPage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by kozlov on 7/4/2016.
 */
public class GitEditorPageImplementation extends PageInstance {

    @Autowired
    EditorPage editorPage;

    @Autowired
    GitHubPage gitHubPage;

    @And("^I read initial IDs from database")
    public void iReadInitialIDsFromDB() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            String connectionString = "jdbc:sqlserver://" + SystemHelper.DATABASEIP + ";databaseName=RelimeDb;user=" + SystemHelper.DATABASELOGIN + ";password=" + SystemHelper.DATABASEPASS + ";";
            CommonHelper.DBFeaturesTreeElements = gitHubPage.getFeatureIdNameMapFromDatabaseByProjectKey(connectionString, CommonHelper.testProjectKey);
            ReportService.ReportAction("Initial IDs were read database.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I can see IDs is changed in ng-ispector")
    public void iCanSeeIDsIsChanged() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            String connectionString = "jdbc:sqlserver://" + SystemHelper.DATABASEIP + ";databaseName=RelimeDb;user=" + SystemHelper.DATABASELOGIN + ";password=" + SystemHelper.DATABASEPASS + ";";
            Map<Integer, String> newTree = gitHubPage.getFeatureIdNameMapFromDatabaseByProjectKey(connectionString, CommonHelper.testProjectKey);
            boolean a = CommonHelper.DBFeaturesTreeElements!=null;
            if(CommonHelper.DBFeaturesTreeElements!=null&&CommonHelper.DBFeaturesTreeElements.size() == newTree.size()) {
                boolean IDsChanged = true;
                for (Map.Entry e : CommonHelper.DBFeaturesTreeElements.entrySet()) {
                    if(!newTree.values().contains(e.getValue())||newTree.keySet().contains(e.getKey())){
                        IDsChanged = false;
                        break;
                    }
                }
                ReportService.ReportAction("All IDs changed in the database.", IDsChanged);
            }
            else{
                ReportService.ReportAction("Number of elements in the database changed", false);
            }
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I read folder structure from GIT \"([^\"]*)\"")
    public void iReadFolderStructureFromGit(String url) throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            if(url.equals("default")) {
                url = SystemHelper.DEFAULTGIT + "tree/master/src/test/resources/feature";
            }
            if(url.equals("smoke")) {
                url = SystemHelper.SMOKEGIT + "tree/master/src/test/resources/feature";
            }
            CommonHelper.gitHubFileTree = gitHubPage.getFolderStructureFromGit(url);
            ReportService.ReportAction("Folder structure was read from Git.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I read folder structure from Editor page")
    public void iReadFolderStructureFromEditorPage() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            CommonHelper.editorPageFileTree = editorPage.getFolderStructureFromEditPage();
            ReportService.ReportAction("Folder structure was read from Editor Page.", true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I check that GitHub and ReLime trees are the same")
    public void iCheckThatTreesAreTheSame() throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("GitHub file tree is the same as ReLime tree", CommonHelper.gitHubFileTree.equals(CommonHelper.editorPageFileTree));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I can see that structures in scenario accordion for scenario \"([^\"]*)\" and Git file \"([^\"]*)\" are the same")
    public void iCanSeeThatStructuresInScenarioAccordionAndGitFileAreTheSame(String scenario, String url) throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            if(url.contains("[default]")){
                url = url.replace("[default]", SystemHelper.DEFAULTGIT);
            }
            boolean contains = false;
            ArrayList<String> scenarioLines = new ArrayList<>();
            for (Element e : editorPage.scenarioStepLines) {
                scenarioLines.add(e.getText());
            }
            ArrayList<String> fileLines = gitHubPage.readContentsOfTheFile(url);
            outer:
            for (int i = 0; i < fileLines.size(); i++) {
                if(fileLines.get(i).contains(scenario)){
                    contains = true;
                    i++;
                    for (int j = 0; j < scenarioLines.size(); j++, i++) {
                        if(!scenarioLines.get(j).equals(fileLines.get(i))) {
                            contains = false;
                            break outer;
                        }
                    }
                }
            }
            ReportService.ReportAction("Structures in scenario accordion for scenario and Git file are the same.", contains);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I see that tags are present for scenarios and feature in Git file \"([^\"]*)\"")
    public void iSeeThatTagsArePresentForScenarioInGitFile(String url) throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try{
            if(url.contains("[default]")){
                url = url.replace("[default]", SystemHelper.DEFAULTGIT);
            }
            boolean tagsPresent = true;
            ArrayList<String> lines = gitHubPage.readContentsOfTheFile(url);
            for (int i = 0; i < lines.size(); i++) {
                String scenario = lines.get(i);
                if(scenario.startsWith("Scenario")){
                    String tag = lines.get(i-1);
                    if(!tag.contains("@SC_")) {
                        tagsPresent = false;
                        break;
                    }
                }
                else if(scenario.startsWith("Feature")){
                    String tag = lines.get(i-1);
                    if(!tag.contains("@ST_")) {
                        tagsPresent = false;
                        break;
                    }
                }
            }
            ReportService.ReportAction("Tags are present for scenarios and feature in Git file '" + url + "'.",  tagsPresent);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @And("^I delete tags for scenarios and feature in Git file \"([^\"]*)\"")
    public void iDeleteTagsForScenarioInGitFile(String url) throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try{
            if(url.contains("[default]")){
                url = url.replace("[default]", SystemHelper.DEFAULTGIT);
            }
            driver.navigate().to(url);
            Waiters.waitAppearanceOf(10, gitHubPage.firstGitFileContentLine.getWrappedElement());
            if(gitHubPage.gitSignInButton.isDisplayed()){
                gitHubPage.gitSignInButton.click();
                Waiters.waitAppearanceOf(5, gitHubPage.gitLoginPageSignInButton.getWrappedElement());
                gitHubPage.gitLoginInput.sendKeys("san4a");
                gitHubPage.gitPasswordInput.sendKeys("fcmkh1925");
                gitHubPage.gitLoginPageSignInButton.click();
                Waiters.waitAppearanceOf(10, gitHubPage.firstGitFileContentLine.getWrappedElement());
            }
            Thread.sleep(500);
            gitHubPage.gitFileEditButton.click();
            Thread.sleep(1000);
            for (int i = 0; i < gitHubPage.editedGitFileContentLines.size(); i++) {
                Element e = gitHubPage.editedGitFileContentLines.get(i);
                if(e.getText().contains("@SC_")||e.getText().contains("@ST_")){
                    CommonHelper.clickWithActions(e.getWrappedElement());
                    Thread.sleep(500);
                    CommonHelper.selectLine(e.getWrappedElement());
                    Actions actions = new Actions(driver);
                    actions.sendKeys(Keys.BACK_SPACE);
                    if(i==0){
                        actions.sendKeys(Keys.DELETE);
                    }else
                        actions.sendKeys(Keys.BACK_SPACE);
                    actions.build().perform();
                    i--;
                    Thread.sleep(1000);
                }
            }
            gitHubPage.gitFileSubmitButton.click();
            Waiters.waitAppearanceOf(5, gitHubPage.gitFileEditButton.getWrappedElement());
            ReportService.ReportAction("Tags were deleted for git file.",  true);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }
}
