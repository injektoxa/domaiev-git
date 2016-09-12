package testUtils;

import com.paulhammant.ngwebdriver.NgWebDriver;
import helpers.SystemHelper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import pages.base.PageInstance;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import arp.CucumberArpReport;
import java.util.concurrent.TimeUnit;

import static com.unitedsofthouse.ucucumberpackage.typesfactory.factory.TypeFactory.setArpReportClient;
import static helpers.SystemHelper.MAINWINDOWHANDLER;
import static helpers.SystemHelper.Reset_Values;

public class BeforeAfter extends PageInstance {

    public static Scenario lastScenario;

    @Before
    public void setUp(Scenario scenario) {
        Reset_Values();
        try {String url = SystemHelper.URL;
            driver.navigate().to(url);
            try {
                Alert alert = driver.switchTo().alert();
                alert.accept();
            } catch (Exception e){}
            driver.manage().window().maximize();
            driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
            ngDriver = new NgWebDriver((JavascriptExecutor) driver);
            ngDriver.waitForAngularRequestsToFinish();
            MAINWINDOWHANDLER = driver.getWindowHandle();
            setArpReportClient(new CucumberArpReport());
            if (!scenario.getId().startsWith(arpClient.getTestSuiteName().toLowerCase())) {
                //arpClient.close();
                arpClient.closeAndSendToAnotherURL("http://10.10.80.162:90/Services/Deployment.asmx?WSDL");
                arpClient.open("02CBE32D-FC51-4812-98A7-DE012DFD1EC2", scenario.getId());
            }
            arpClient.addTestToTestSuite(scenario);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown(Scenario scenario) throws Exception {
        try {
            arpClient.decideTestStatus();
            arpClient.FinishTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}