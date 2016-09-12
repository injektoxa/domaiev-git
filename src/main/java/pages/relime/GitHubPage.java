package pages.relime;

import com.unitedsofthouse.ucucumberpackage.tools.Waiters;
import com.unitedsofthouse.ucucumberpackage.typesfactory.factory.TypeFactory;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.*;
import helpers.CommonHelper;
import helpers.Node;
import org.apache.commons.collections.map.HashedMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;
import pages.base.BasePage;
import org.antlr.runtime.tree.CommonTree;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.regex.Pattern;

/**
 * Created by kozlov on 7/5/2016.
 */
public class GitHubPage extends BasePage {


    @Override
    protected WebElement elementForLoading() throws Exception {
        return loadingElement;
    }

    public final String GIT_FILE_LINK = "./td[2]//a";
    public final String GIT_FILE_ICON = ".//td[1]/*[name()='svg']";

    @Lazy
    @FindBy(xpath = ".//a[@class = 'header-logo-invertocat']")
    public WebElement loadingElement;

    @Lazy
    @FindBy(xpath = ".//div[contains(@id, 'ngdialog')]//div[@class='form-group']")
    public List<Label> gitFileLines;

    @Lazy
    @FindBy(xpath = ".//div[contains(@id, 'ngdialog')]//div[@class='form-group'][1]")
    public Label firstGitFileLine;

    @Lazy
    @FindBy(xpath = ".//button[@aria-label = 'Edit this file']")
    public Label gitFileEditButton;

    @Lazy
    @FindBy(xpath = ".//button[@id = 'submit-file']")
    public Label gitFileSubmitButton;

    @Lazy
    @FindBy(xpath = ".//a[text() = 'Sign in']")
    public Button gitSignInButton;

    @Lazy
    @FindBy(xpath = ".//input[@value = 'Sign in']")
    public Button gitLoginPageSignInButton;

    @Lazy
    @FindBy(xpath = ".//input[@id='login_field']")
    public TextInput gitLoginInput;

    @Lazy
    @FindBy(xpath = ".//input[@id='password']")
    public TextInput gitPasswordInput;

    @Lazy
    @FindBy(xpath = ".//td[contains(@id, 'LC')]")
    public List<Label> gitFileContentLines;

    @Lazy
    @FindBy(xpath = ".//div[contains(@class, 'ace_line')]")
    public List<Label> editedGitFileContentLines;

    @Lazy
    @FindBy(xpath = "(.//td[contains(@id, 'LC')])[1]")
    public Label firstGitFileContentLine;

    @Lazy
    @FindBy(xpath = ".//table/tbody[2]/tr[contains(@class, 'js-navigation-item')]")
    public List<PlaceHolder> gitFiles;

    @Lazy
    @FindBy(xpath = ".//tr[contains(@class, 'up-tree')]//a")
    public Button goUpTree;

    public boolean uniqueTagsArePresentInProjectFeatures(String url) throws Exception {
        driver.navigate().to(url);
        Pattern p = Pattern.compile("SC_[a-z,A-Z,0-9]+");
        boolean tagsAppeared = true;
        Waiters.waitAppearanceOf(10, this.firstGitFileLine.getWrappedElement());
        for (int i = 1; i < this.gitFileLines.size(); i++) {
            if(this.gitFileLines.get(i).getText().contains("Scenario")){
                if(!p.matcher(this.gitFileLines.get(i-1).getText()).matches()){
                    tagsAppeared = false;
                    break;
                }
            }
        }
        return tagsAppeared;
    }

    public ArrayList<String> readContentsOfTheFile(String url) throws Exception {
        driver.navigate().to(url);
        ArrayList<String> lines = new ArrayList<>();
        Waiters.waitAppearanceOf(10, this.firstGitFileContentLine.getWrappedElement());
        for (Element e : this.gitFileContentLines) {
            lines.add(e.getText());
        }
        return lines;
    }

    public Map<Integer, String> getFeatureIdNameMapFromDatabaseByProjectKey(String DBConnectionString, String Key) throws Exception {
        Map<Integer, String> result = new HashedMap();
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection(DBConnectionString);
        ResultSet set = con.createStatement().executeQuery("SELECT [Id] FROM [RelimeDb].[dbo].[Project] WHERE ProjectKey = '" + Key + "'");
        set.next();
        int projectId = set.getInt("Id");
        set = con.createStatement().executeQuery("SELECT [Id], [Name] FROM [RelimeDb].[dbo].[Tree] WHERE Project_Id = '" + projectId + "'");
        while(set.next()){
            int id = set.getInt("Id");
            String name = set.getString("Name");
            result.put(id, name);
        }
        return result;
    }

    public Node getFolderStructureFromGit(String url) throws Exception {
        driver.navigate().to(url);
        Waiters.waitAppearanceOf(5, this.goUpTree.getWrappedElement());
        Node<String> root = new Node(url.substring(url.lastIndexOf("/") + 1));
        for (int i = 0; i < gitFiles.size(); i++) {
            Element e = gitFiles.get(i);
            Node<String> node = new Node(e.findElement(By.xpath(this.GIT_FILE_LINK)).getText());
            node.setParent(root);
            WebElement el = e.findElement(By.xpath(this.GIT_FILE_ICON));
            String s = el.getAttribute("class");
            if(e.findElement(By.xpath(this.GIT_FILE_ICON)).getAttribute("class").contains("octicon-file-directory")){
                e.findElement(By.xpath(this.GIT_FILE_LINK)).click();
                Thread.sleep(500);
                getFolderStructureFromGit(node);
                this.goUpTree.click();
                Thread.sleep(500);
            }
        }
        return root;
    }

    private void getFolderStructureFromGit(Node parent) throws Exception {
        for (int i = 0; i < gitFiles.size(); i++) {
            Element e = gitFiles.get(i);
            Node<String> node = new Node(e.findElement(By.xpath(this.GIT_FILE_LINK)).getText().replace(".feature", ""));
            node.setParent(parent);
            if(e.findElement(By.xpath(this.GIT_FILE_ICON)).getAttribute("class").contains("octicon-file-directory")){
                e.findElement(By.xpath(this.GIT_FILE_LINK)).click();
                Thread.sleep(500);
                getFolderStructureFromGit(node);
                this.goUpTree.click();
                Thread.sleep(500);
            }
        }
    }
}
