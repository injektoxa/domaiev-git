package helpers;

import arp.ReportService;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import pages.base.PageInstance;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class CommonHelper extends PageInstance {

    public static String testFolderName;
    public static String testFeatureName;
    public static String testFeatureFileName;
    public static ArrayList<String> testFeatureTags;
    public static String testFeatureDescription;
    public static String testJiraLinkedFeatureName;
    public static String testJiraLinkedFeatureFilename;
    public static String testScenarioName;
    public static String testScenarioDescription;
    public static ArrayList<String> testScenarioTags;
    public static String testBackgroundName;
    public static String testBackgroundDescription;
    public static String testProjectName;
    public static String testProjectKey;
    public static String testProjectDescription;
    public static String testProjectType;
    public static String testAccountName = "";
    public static String testAccountUserName = "";
    public static String testAccountPassword;
    public static int delay = 5;
    public static Map<Integer, String> DBFeaturesTreeElements;
    public static Node gitHubFileTree;
    public static Node editorPageFileTree;

    public static void dragAndDropWithActions(WebElement fromElement, WebElement toElement) throws Exception{
        Actions builder = new Actions(driver);
        Action dragAndDrop = builder.clickAndHold(fromElement)
                .moveToElement(toElement)
                .release(toElement)
                .build();
        dragAndDrop.perform();
    }

    public static void sendKeysWithActions(WebElement element, String text) throws Exception{
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click();
        actions.sendKeys(text);
        actions.build().perform();
    }

    public static void sendKeyWithActions(WebElement element, CharSequence key) throws Exception{
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click();
        actions.sendKeys(key);
        actions.build().perform();
    }

    public static void sendKeyWithActions(CharSequence key) throws Exception{
        Actions actions = new Actions(driver);
        actions.sendKeys(key);
        actions.build().perform();
    }

    public static void clickWithActions(WebElement element) throws Exception{
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click();
        actions.build().perform();
    }

    public static void doubleClickWithActions(WebElement element) throws Exception {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.doubleClick();
        actions.build().perform();
    }

    public static void selectLine(WebElement element) throws Exception {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.HOME);
        actions.keyDown(Keys.LEFT_SHIFT);
        actions.sendKeys(Keys.END);
        actions.keyUp(Keys.LEFT_SHIFT);
        actions.build().perform();
    }

    public static void
    sendKeyWithAWT(int key) throws Exception {
        Robot r = new Robot();
        r.keyPress(key);
        r.keyRelease(key);
    }

    public static String getDate(){
        return new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
    }
}
