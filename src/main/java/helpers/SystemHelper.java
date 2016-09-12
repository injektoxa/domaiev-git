package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.PageInstance;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.lang.RandomStringUtils;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class SystemHelper extends PageInstance {
    public static final String URL;
    public static final String DOMAIN;
    public static final String BROWSER;
    public static String USERNAME;
    public static String PASSWORD;
    public static String TARGETCYCLE;
    public static String MAINWINDOWHANDLER;
    public static final int TIMEOUT;
    public static String DATABASEIP;
    public static String DATABASELOGIN;
    public static String DATABASEPASS;
    public static String DEFAULTGITACCOUNT;
    public static String DEFAULTJIRAACCOUNT;
    public static String DEFAULTPROJECT;
    public static String DEFAULTSMOKEPROJECT;
    public static String DEFAULTREGRESSIONPROJECTONE;
    public static String DEFAULTREGRESSIONPROJECTTWO;
    public static String DEFAULTGIT;
    public static String SMOKEGIT;
    public static String GUIDUSER="";
    public static Map<String,String> _inputdata;
    public static Map<String,String> firstValues = new HashMap<>();

    static {
        HashMap<String, String> ARPConfig = read();
        URL = ARPConfig.get("url");
        DOMAIN = ARPConfig.get("domain");
        USERNAME = ARPConfig.get("login");
        PASSWORD = ARPConfig.get("password");
        BROWSER = ARPConfig.get("browser");
        TARGETCYCLE = ARPConfig.get("targetTestCycle");
        DATABASEIP = ARPConfig.get("databaseIP");
        DATABASELOGIN = ARPConfig.get("databaseLogin");
        DATABASEPASS = ARPConfig.get("databasePass");
        DEFAULTPROJECT = ARPConfig.get("defaultProject");
        DEFAULTSMOKEPROJECT = ARPConfig.get("defaultSmokeProject");
        DEFAULTREGRESSIONPROJECTONE = ARPConfig.get("defaultRegressionProjectOne");
        DEFAULTREGRESSIONPROJECTTWO = ARPConfig.get("defaultRegressionProjectTwo");
        DEFAULTGITACCOUNT = ARPConfig.get("defaultVCSAcc");
        DEFAULTJIRAACCOUNT = ARPConfig.get("defaultTTSAcc");
        DEFAULTGIT = ARPConfig.get("GIT");
        SMOKEGIT = ARPConfig.get("smokeGIT");
        TIMEOUT = 30;
    }

    public static String getGUIDUSER() {
        return _inputdata.get("GUID");
    }

    public static HashMap<String, String> read() {
        XMLConfiguration config = null;
        HashMap<String, String> map = new HashMap<>();
        try {
            config = new XMLConfiguration("ARP_Configuration.xml");
            String env = System.getProperty("env");
            String user = System.getProperty("user");
            map.put("url", config.getString(env + "." + user + "." + "url"));
            map.put("domain", config.getString(env + "." + user + "." + "domain"));
            map.put("backdoor", config.getString(env + "." + user + "." + "//backdoor"));
            map.put("login", config.getString(env + "." + user + "." + "login"));
            map.put("password", config.getString(env + "." + user + "." + "password"));
            map.put("profile", config.getString(env + "." + user + "." + "profile"));
            map.put("browser", config.getString(env + "." + user + "." + "browser"));
            map.put("targetTestCycle", config.getString(env + "." + user + "." + "targetTestCycle"));
            map.put("databaseIP", config.getString(env + "." + user + "." + "databaseIP"));
            map.put("databaseLogin", config.getString(env + "." + user + "." + "databaseLogin"));
            map.put("databasePass", config.getString(env + "." + user + "." + "databasePass"));
            map.put("task", config.getString(env + "." + user + "." + "task"));
            map.put("defaultProject", config.getString(env + "." + user + "." + "defaultProject"));
            map.put("defaultSmokeProject", config.getString(env + "." + user + "." + "defaultSmokeProject"));
            map.put("defaultRegressionProjectOne", config.getString(env + "." + user + "." + "defaultRegressionProjectOne"));
            map.put("defaultRegressionProjectTwo", config.getString(env + "." + user + "." + "defaultRegressionProjectTwo"));
            map.put("defaultVCSAcc", config.getString(env + "." + user + "." + "defaultVCSAcc"));
            map.put("defaultTTSAcc", config.getString(env + "." + user + "." + "defaultTTSAcc"));
            map.put("GIT", config.getString(env + "." + user + "." + "GIT"));
            map.put("smokeGIT", config.getString(env + "." + user + "." + "smokeGIT"));
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setImplicitlyWait(int timeout) {
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    public static void Reset_Values() {
        _inputdata = new HashMap<String,String>();
        _inputdata.put("GUID", ("П"+UUID.randomUUID().toString())); // Поставил "П" для того чтобы рандомное отчество начиналось с этой буквы, т.к. тест падает
        _inputdata.put("DATE", new Date().toString());
    }

    public static String GET_VALUE(String value) {
        if (!_inputdata.containsKey(value)) {
            if (value.contains("GUIDUSER")){
                GUIDUSER = String.valueOf("П")+UUID.randomUUID().toString();  // Поставил "П" для того чтобы рандомное отчество начиналось с этой буквы, т.к. тест падает если не совпадают инициалы
                _inputdata.put(value, GUIDUSER);
            }
                //else if(value.toLowerCase().contains("mail"))
                //   _inputdata.put(value,RandomStringUtils.randomAlphanumeric(10)+"@mail.com");
            else if (value.contains("RandMail"))
                _inputdata.put(value, RandomStringUtils.randomAlphanumeric(10) + "@mail.com");
            else if (value.contains("TagRand"))                                   // random value for tag
                _inputdata.put(value, RandomStringUtils.randomNumeric(10));
            else
                _inputdata.put(value, value);
        }
        return _inputdata.get(value);
    }

    public static void waitAppearanceByXpath(WebDriver driver, int delay, int limit, String xpath) throws Exception{
        for (int i=0; i < limit; i++) {
            try {
                WebElement el = driver.findElement(By.xpath(xpath));
                if (el.isDisplayed()) {
                    Thread.sleep(300);
                    return;
                }
            }
            catch (Exception e) {}
            finally {
                Thread.sleep(delay);
            }
        }
        return;
    }

    public static void waitAppearanceByElement(WebDriver driver, int delay, int limit, WebElement el) throws Exception{
        for (int i=0; i < limit; i++) {
            try {
                if (el.isDisplayed()) {
                    Thread.sleep(300);
                    return;
                }
            }
            catch (Exception e) {}
            finally {
                Thread.sleep(delay);
            }
        }
        return;
    }

}