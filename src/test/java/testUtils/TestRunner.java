package testUtils;

import com.unitedsofthouse.ucucumberpackage.tools.WebCucDriver;
import arp.ReportService;
import helpers.SystemHelper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.RegexFileFilter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.base.PageInstance;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.junit.Cucumber;
import arp.CucumberArpReport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.*;

import static com.unitedsofthouse.ucucumberpackage.typesfactory.factory.TypeFactory.setArpReportClient;

@RunWith(Cucumber.class)

@CucumberOptions(format = {"pretty",
                           "html:target/cucumber-htmlreport",
                           "junit:target/cucumber-junit-report/cuc.xml"},
                 glue = {"stepdefinition",
                        "testUtils"},
                 features = {"src/test/resources",
                             "src/test/resources/FeaturesPage/FeaturesPanel",
                             "src/test/resources/FeaturesPage/ScenarioEditor",
                             "src/test/resources/ProfileDataEditing"},
                 tags = {"@Smoke", "~@ignore"}
)
public class TestRunner extends PageInstance {

    @BeforeClass
    public static void BeforeClass() {
        try {
            ArrayList<File> features = new ArrayList();
            File dir = new File("src/test/resources");
            Collection featuresCol = FileUtils.listFiles(
                    dir,
                    new RegexFileFilter("^(.*feature)"),
                    DirectoryFileFilter.DIRECTORY
            );
            for (Object temp : featuresCol) {
                features.add((File)temp);
            }
            BufferedReader br = new BufferedReader(new FileReader(features.get(0)));
            String featureName = "";
            while (true) {
                String stringFromFile = br.readLine();
                if (stringFromFile.contains("Feature:")) {
                    featureName = stringFromFile.replace("Feature:", "");
                    while (featureName.startsWith(" ") || featureName.endsWith(" ")) {
                        featureName = featureName.trim();
                    }
                    break;
                }
            }
            arpClient.open("02CBE32D-FC51-4812-98A7-DE012DFD1EC2", featureName);
            arpClient.enableScreenshotLogging();
            setArpReportClient(new CucumberArpReport());
            ChromeOptions options = new ChromeOptions();
            options.addArguments("test-type");
            options.addArguments("disable-popup-blocking");
            options.addArguments("--disable-extensions");
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            WebCucDriver.setWebdriver("CH", capabilities, null);
            driver = WebCucDriver.getDriver();
            driver.get(SystemHelper.URL);
            arpClient.getReport();
            arpClient.turnOnJUnitLogging();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void CreateReport() throws Exception {
        try {
            arpClient.getReport();
            //arpClient.close();
            arpClient.closeAndSendToAnotherURL("http://10.10.80.162:90/Services/Deployment.asmx?WSDL");
            try {
                Scenario scenario = BeforeAfter.lastScenario;
                Field f = null;
                try {
                    f = scenario.getClass().getDeclaredField("reporter");
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
                f.setAccessible(true);
            } catch (Exception ex) {
            }
            driver.quit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            driver = null;
        }
    }
}
