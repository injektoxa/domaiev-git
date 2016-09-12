package stepdefinition.Routing;

import arp.CucumberArpReport;
import arp.ReportService;
import com.unitedsofthouse.ucucumberpackage.tools.Waiters;
import cucumber.api.java.en.*;
import helpers.CommonHelper;
import helpers.SystemHelper;
import pages.base.PageInstance;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kozlov on 6/30/2016.
 */
public class Pages extends PageInstance {
    @Then("^I can see path matches RegEx \"([^\"]*)\" in browser route")
    public void iSeeNotificationMessages(String pattern) throws Throwable{
        if (!checkIfFurtherStepsAreNeeded()) {
            return;
        }
        try {
        pattern = pattern.replace("[default]", SystemHelper.DOMAIN);
            String url = driver.getCurrentUrl();
            Pattern p = Pattern.compile(pattern);
            ReportService.ReportAction("Url path is correct.", p.matcher(url).matches());
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e)   {
            ReportService.ReportAction("Error: " + e.getMessage(), false);
        } finally {
            CucumberArpReport.nextStep();
        }
    }
}
