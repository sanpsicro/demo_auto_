
import io.github.bonigarcia.wdm.*;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Predicate;

public class SeleniumUtils implements BaseMethods{

    public static WebDriver seleniumUtils;

    static{
        WebDriverManager driver = new ChromeDriverManager();

        driver.setup();

        seleniumUtils = driver.create();

        seleniumUtils.manage().window().maximize();
        seleniumUtils.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);

        System.out.println(System.getenv("DbName"));

    }
    public SeleniumUtils()
    {

    }


    @Override
    public void waitForCondition(ExpectedCondition<WebElement> condition, int waitTime)
    {
        WebDriverWait wait = new WebDriverWait(seleniumUtils, waitTime);

        wait.until(seleniumUtils->condition);

    }

    public void waitForCondition(ExpectedCondition<Boolean> condition)
    {
        WebDriverWait wait = new WebDriverWait(seleniumUtils, 60);

        wait.until(seleniumUtils->condition);

    }



    @Override
    public void clickBy(By by)
    {

        WebDriverWait wait = new WebDriverWait(seleniumUtils, 60);

        wait.until(driver->
        {
            try{

                seleniumUtils.findElement(by).click();
                return true;
            }
            catch(StaleElementReferenceException | ElementClickInterceptedException e){
                return false;
        }

        });


    }


}
