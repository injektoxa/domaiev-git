package pages.relime;

import com.unitedsofthouse.ucucumberpackage.tools.Waiters;
import com.unitedsofthouse.ucucumberpackage.typesfactory.factory.TypeFactory;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;

import java.util.List;

/**
 * Created by kozlov on 5/24/2016.
 */
public class ProfilePage extends RelimePage {

    public final String CREDENTIALS_ROW_ACCOUNT = ".//dt/span[1]";
    public final String CREDENTIALS_ROW_NAME = ".//dd/span";
    public final String CREDENTIALS_ROW_DELETE = "./button";
    public final String CREDENTIALS_FORM_UPDATE = ".//button[1]";
    public final String CREDENTIALS_FORM_CANCEL = ".//button[2]";
    public final String CREDENTIALS_FORM_ACCOUNT_FIELD = ".//input[contains(@id, 'AccountName')]";
    public final String CREDENTIALS_FORM_NAME_FIELD = ".//input[contains(@id, 'UserName')]";
    public final String CREDENTIALS_FORM_PASSWORD_FIELD = ".//input[contains(@id, 'Password')]";

    public ProfilePage() {
        TypeFactory.containerInitHTMLElements(this);
    }

    @Lazy
    @FindBy(xpath = ".//div[@class='user-content']")
    public PlaceHolder profileUserInfo;

    @Override
    protected WebElement elementForLoading() throws Exception {
        return loadingElement;
    }

    @Lazy
    @FindBy(xpath = ".//ld-credentials//div[contains(@class, 'accordion-heading')]")
    public List<Label> credentialsTableRows;

    @Lazy
    @FindBy(xpath = ".//ul[contains(@class, 'pagination')]/li")
    public List<WebElement> accountTablePages;

    @Lazy
    @FindBy(xpath = "(.//div[@id='credentials-section']//button[contains(@class, 'btn-create')])[1]")
    public Button createNewCredentialButton;

    @Lazy
    @FindBy(xpath = ".//rl-credentials-form[contains(@class, 'create-form-holder')]")
    public PlaceHolder createNewCredentialForm;

    @Lazy
    @FindBy(xpath = ".//rl-credentials-form[not(contains(@class, 'create-form-holder'))]")
    public PlaceHolder editCredentialForm;

    @Lazy
    @FindBy(xpath = ".//div[contains(@class, 'error-block')]/span")
    public List<Label> profileFieldWarnings;

    public Label findRowInAccountPanel(String account, String userName) throws Exception {
        for (Label p : credentialsTableRows) {
            if(p.findElement(By.xpath(CREDENTIALS_ROW_ACCOUNT)).getText().equals(account)
                    &&p.findElement(By.xpath(CREDENTIALS_ROW_NAME)).getText().equals(userName)){
                return p;
            }
        }
        return null;
    }

    /*public Label findRowInAccountPanel(String account, String userName) throws Exception {
        Waiters.waitAppearanceOf(5, this.credentialsTableRows.get(0).getWrappedElement());
        if(this.accountTablePages!=null&& this.accountTablePages.size()>3) {
            boolean firstPage = true;
            this.accountTablePages.get(1).click();
            outer:
            while(true) {
                for (int i = 0; i < this.accountTablePages.size(); i++) {
                    WebElement e = this.accountTablePages.get(i);
                    String s1 = e.getText();
                    String s2 = e.getAttribute("class");
                    if (e.getAttribute("class").contains("active") && !this.accountTablePages.get(i + 1).getText().equals(">")) {
                        if(!firstPage) {
                            this.accountTablePages.get(i + 1).click();
                        }
                        else{
                            firstPage = false;
                        }
                        Thread.sleep(500);
                        for (Label row : this.credentialsTableRows) {
                            String s = row.findElement(By.xpath(this.ACCOUNT)).getText();
                            boolean accountCorrect = s.equals(account);
                            s = row.findElement(By.xpath(this.NAME)).getText();
                            boolean nameCorrect = s.equals(userName);
                            if (accountCorrect && nameCorrect) {
                                return row;
                            }
                        }
                    }
                    else if(e.getAttribute("class").contains("active") && this.accountTablePages.get(i + 1).getText().equals(">")){
                        break outer;
                    }
                }
            }
        }
        else{
            for (Label row : this.credentialsTableRows) {
                String s = row.findElement(By.xpath(this.ACCOUNT)).getText();
                boolean accountCorrect = s.equals(account);
                s = row.findElement(By.xpath(this.NAME)).getText();
                boolean nameCorrect = s.equals(userName);
                if (accountCorrect && nameCorrect) {
                    return row;
                }
            }
        }
        return null;
    }*/
}
