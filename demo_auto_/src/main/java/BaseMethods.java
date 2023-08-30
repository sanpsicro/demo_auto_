import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public interface BaseMethods {

    public void clickBy(By by);

    public void waitForCondition(ExpectedCondition<WebElement> condition, int waitTime);


}
