package pages.base;

import com.unitedsofthouse.ucucumberpackage.typesfactory.factory.TypeFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage extends PageInstance {
    protected int timeOut = 60;

    public BasePage() {
        TypeFactory.containerInitHTMLElements(this);
        PageFactory.initElements(driver, this);
    }

    protected abstract WebElement elementForLoading() throws Exception;

    public String toString(){
        return this.getClass().getSimpleName();
    }
}