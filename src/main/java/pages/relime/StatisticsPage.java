package pages.relime;

import com.unitedsofthouse.ucucumberpackage.typesfactory.factory.TypeFactory;
import com.unitedsofthouse.ucucumberpackage.typesfactory.types.*;
import org.openqa.selenium.support.*;
import org.springframework.context.annotation.*;

/**
 * Created by kozlov on 6/30/2016.
 */
public class StatisticsPage extends RelimePage {
    public StatisticsPage() {
        TypeFactory.containerInitHTMLElements(this);
    }

    @Lazy
    @FindBy(xpath = ".//*[text()='General project statistics']")
    public Label generalProjectStatisticsLabel;
}
