package pages.relime;

import com.unitedsofthouse.ucucumberpackage.tools.Waiters;
import com.unitedsofthouse.ucucumberpackage.typesfactory.factory.TypeFactory;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.*;
import helpers.CommonHelper;
import helpers.SystemHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;

import java.util.List;

public class DashboardPage extends RelimePage{

    public DashboardPage() {
        TypeFactory.containerInitHTMLElements(this);
    }

    public final String PROJECTNAME = "./*[2]";
    public final String PROJECTKEY = "./*[3]";
    public final String EDITBUTTON = "./*[4]/button[1]";
    public final String DELETEBUTTON = "./*[4]/button[2]";

    @Override
    protected WebElement elementForLoading() throws Exception {
        return addNewProjectButton.getWrappedElement();
    }

    @Lazy
    @FindBy(xpath = ".//div[@class='navbar-header']/a")
    public Button topPanelRelimeButton;

    @Lazy
    @FindBy(xpath = ".//div[@class='nav-wrapper']/ul/li[1]/a")
    public Button topPanelMaximizeButton;

    @Lazy
    @FindBy(xpath = ".//div[@class='nav-wrapper']/ul/li[2]/a")
    public Button topPanelDashboardButton;

    @Lazy
    @FindBy(xpath = ".//button[@id='btn-append-to-single-button']")
    public Button topPanelCurrentProjectDropdown;

    @Lazy
    @FindBy(xpath = ".//rl-projects-list-dropdown/span")
    public Button topPanelCurrentProjectLabel;

    @Lazy
    @FindBy(xpath = ".//ul[@class='recent-list']")
    public PlaceHolder recentProjectsDropdown;

    @Lazy
    @FindBy(xpath = ".//nav[@sidebar-anyclick-close]//li/a")
    public List<Link> sidePanelElements;

    @Lazy
    @FindBy(xpath = ".//a[text()='View all projects']")
    public Link viewAllProjectsLink;

    @Lazy
    @FindBy(xpath = ".//*[@data-uib-tooltip='Create new project']")
    public Button addNewProjectButton;

    @Lazy
    @FindBy(xpath = ".//div[@class = 'panel-info']/div/div/ul/li")
    public List<Label> projectTableRows;

    @Lazy
    @FindBy(xpath = ".//ul[contains(@class, 'pagination')]/li")
    public List<Label> projectTablePages;

    public Element findRowInProjectPanelByProjectKey(String value) throws Exception {
        Thread.sleep(500);
        if(this.projectTablePages.get(this.projectTablePages.size() - 2).isDisplayed()&&!this.projectTablePages.get(this.projectTablePages.size() - 2).getAttribute("class").contains("active")){
            this.projectTablePages.get(this.projectTablePages.size() - 2).click();
            Thread.sleep(500);
        }
        if(this.projectTablePages!=null&&this.projectTablePages.size()>3) {
            boolean firstPage = true;
            outer:
            while (!this.projectTablePages.get(1).getAttribute("class").contains("active"))
            {
                String t = this.projectTablePages.get(0).getText();
                String s = this.projectTablePages.get(this.projectTablePages.size() - 2).getAttribute("class");
                for (int i = this.projectTablePages.size() - 1; i >= 0; i--) {
                    Element e = this.projectTablePages.get(i);
                    String s1 = e.getText();
                    String s2 = e.getAttribute("class");
                    String s3 = this.projectTablePages.get(i - 1).getText();
                    boolean isActive = e.getAttribute("class").contains("active");
                    boolean isLastPage = this.projectTablePages.get(i - 1).getText().equals("&lt;");
                    if (e.getAttribute("class").contains("active") && !this.projectTablePages.get(i - 1).getText().equals("&lt;")) {
                        if (!firstPage) {
                            this.projectTablePages.get(i - 1).click();
                            Thread.sleep(500);
                        } else {
                            firstPage = false;
                            //i--;
                        }
                        for (Element row : this.projectTableRows) {
                            String key = row.findElement(By.xpath(this.PROJECTKEY)).getText();
                            if (key.equals(value)) {
                                return row;
                            }
                        }
                        break;
                    } else if (e.getAttribute("class").contains("active") && this.projectTablePages.get(i - 1).getText().equals("&lt;")) {
                        break outer;
                    }
                }
            }
        }
        else{
            for (Element row : this.projectTableRows) {
                String s = row.findElement(By.xpath(this.PROJECTKEY)).getText();
                if (s.equals(value)) {
                    return row;
                }
            }
        }
        return null;
    }

    /*public Element findRowInProjectPanelByProjectKey(String value) throws Exception {
        Thread.sleep(500);
        if(this.projectTablePages.get(1).isDisplayed()&&!this.projectTablePages.get(1).getAttribute("class").contains("active")){
            this.projectTablePages.get(1).click();
            Thread.sleep(500);
        }
        if(this.projectTablePages!=null&&this.projectTablePages.size()>3) {
            boolean firstPage = true;

            outer:
            while (!this.projectTablePages.get(this.projectTablePages.size() - 2).getAttribute("class").contains("active"))
            {
                String s = this.projectTablePages.get(this.projectTablePages.size() - 2).getAttribute("class");
                for (int i = 0; i < this.projectTablePages.size(); i++) {
                    Element e = this.projectTablePages.get(i);
                    String s1 = e.getText();
                    String s2 = e.getAttribute("class");
                    String s3 = this.projectTablePages.get(i + 1).getText();
                    boolean isActive = e.getAttribute("class").contains("active");
                    boolean isLastPage = this.projectTablePages.get(i + 1).getText().equals("&gt;");
                    if (e.getAttribute("class").contains("active") && !this.projectTablePages.get(i + 1).getText().equals("&gt;")) {
                        if (!firstPage) {
                            this.projectTablePages.get(i + 1).click();
                            Thread.sleep(500);
                        } else {
                            firstPage = false;
                            i--;
                        }
                        for (Element row : this.projectTableRows) {
                            String key = row.findElement(By.xpath(this.PROJECTKEY)).getText();
                            if (key.equals(value)) {
                                return row;
                            }
                        }
                        break;
                    } else if (e.getAttribute("class").contains("active") && this.projectTablePages.get(i + 1).getText().equals("&gt;")) {
                        break outer;
                    }
                }
            }
        }
        else{
            for (Element row : this.projectTableRows) {
                String s = row.findElement(By.xpath(this.PROJECTKEY)).getText();
                if (s.equals(value)) {
                    return row;
                }
            }
        }
        return null;
    }*/
}