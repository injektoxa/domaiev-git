package stepdefinition.NavigationPanel;

import arp.CucumberArpReport;
import arp.ReportService;
import com.unitedsofthouse.ucucumberpackage.tools.Waiters;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.Element;
import cucumber.api.java.en.*;
import helpers.CommonHelper;
import helpers.SystemHelper;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import pages.base.PageInstance;
import pages.relime.DashboardPage;

/**
 * Created by kozlov on 7/11/2016.
 */
public class NavigationPanel extends PageInstance {

    @Autowired
    DashboardPage dashboardPage;

    @Then("^I see that left panel is hidden$")
    public void iSeeThatLeftPanelIsHidden() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean panelIsVisible = false;
            for (Element e : dashboardPage.sidePanelElements) {
                if(e.isDisplayed()) {
                    panelIsVisible = true;
                    break;
                }
            }
            ReportService.ReportAction("Side panel is hidden.", !panelIsVisible);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that left panel is shown")
    public void iSeeThatLeftPanelIsShown() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean panelIsVisible = dashboardPage.sidePanelElements.size()>0;
            for (Element e : dashboardPage.sidePanelElements) {
                if(!e.isDisplayed()) {
                    panelIsVisible = false;
                    break;
                }
            }
            ReportService.ReportAction("Side panel is shown.", panelIsVisible);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that left panel is maximized")
    public void iSeeThatLeftPanelIsMaximized() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean panelIsMaximized = dashboardPage.sidePanelElements.size()>0;
            for (Element e : dashboardPage.sidePanelElements) {
                if(!e.isDisplayed()||e.getText().equals("")) {
                    panelIsMaximized = false;
                    break;
                }
            }
            ReportService.ReportAction("Side panel is maximized.", panelIsMaximized);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that left panel is minimized")
    public void iSeeThatLeftPanelIsMinimized() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Thread.sleep(1000);
            boolean panelIsMaximized = dashboardPage.sidePanelElements.size()>0;
            for (Element e : dashboardPage.sidePanelElements) {
                if(!e.isDisplayed()||e.getText().equals("")) {
                    panelIsMaximized = false;
                    break;
                }
            }
            ReportService.ReportAction("Side panel is minimized.", !panelIsMaximized);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see item 'Relime' on the top panel$")
    public void iSeeItemRelimeOnTheTopPanel() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Relime item is displayed.", dashboardPage.topPanelRelimeButton.isDisplayed());
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see item 'Maximize' on the top panel$")
    public void iSeeItemMaximizeOnTheTopPanel() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Maximize item is displayed.", dashboardPage.topPanelMaximizeButton.isDisplayed());
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see item 'Dashboard' on the top panel$")
    public void iSeeItemDashboardOnTheTopPanel() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            ReportService.ReportAction("Dashboard item is displayed.", dashboardPage.topPanelDashboardButton.isDisplayed());
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see that 'Current Project' label equals \"([^\"]*)\"")
    public void iSeeCurrentPorjectIsCorrect(String projectName) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            String s = dashboardPage.topPanelCurrentProjectLabel.getText();
            ReportService.ReportAction("Dashboard item is displayed.", dashboardPage.topPanelCurrentProjectLabel.getText().equals(projectName));
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I click on item 'Relime'$")
    public void iClickOnItemRelime() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            dashboardPage.topPanelRelimeButton.click();
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I click on item 'Maximize'$")
    public void iClickOnItemMaximize() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            dashboardPage.topPanelMaximizeButton.click();
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I expand 'Recent Projects' dropdown$")
    public void iExpandRecentProjectsDropdown() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            dashboardPage.topPanelMaximizeButton.click();
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I click on item 'Dashboard'$")
    public void iClickOnItemDashboard() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            dashboardPage.topPanelDashboardButton.click();
            ngDriver.waitForAngularRequestsToFinish();
            Waiters.waitAppearanceOf(CommonHelper.delay, dashboardPage.addNewProjectButton.getWrappedElement());
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I click on item 'Recent Projects'$")
    public void iClickOnItemRecentProjects() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            dashboardPage.topPanelCurrentProjectDropdown.click();
            Waiters.waitAppearanceOf(CommonHelper.delay, dashboardPage.recentProjectsDropdown.getWrappedElement());
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see up to 5 last opened projects in dropdown 'Recent Projects'$")
    public void iSeeUpToFiveLastOpenedProjectsInDropdownRecentProjects() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(CommonHelper.delay, dashboardPage.recentProjectsDropdown.getWrappedElement());
            boolean visible = dashboardPage.recentProjectsDropdown.isDisplayed();
            boolean correctNumberOfElements = dashboardPage.recentProjectsDropdown.findElements(By.xpath("./li")).size()>0&&dashboardPage.recentProjectsDropdown.findElements(By.xpath("./li")).size()<6;
            ReportService.ReportAction("'Recent Projects' dropdown with elements is displayed.", visible&&correctNumberOfElements);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see 'View all projects' in dropdown'$")
    public void iSeeViewAllProjectsInDropdown() throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            Waiters.waitAppearanceOf(CommonHelper.delay, dashboardPage.viewAllProjectsLink.getWrappedElement());
            ReportService.ReportAction("'View all projects' is displayed in dropdown.", dashboardPage.viewAllProjectsLink.isDisplayed());
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }

    @Then("^I see \"([^\"]*)\" item in the left panel$")
    public void iSeeItemInTheLesftPanel(String item) throws Throwable {
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
            boolean elementPresent = false;
            for (Element e : dashboardPage.sidePanelElements) {
                String s = e.getText();
                if(e.getText().toLowerCase().equals(item.toLowerCase())){
                    elementPresent = true;
                    break;
                }
            }
            ReportService.ReportAction("Element '" + item + "' is displayed in the left panel.", elementPresent);
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }
}
