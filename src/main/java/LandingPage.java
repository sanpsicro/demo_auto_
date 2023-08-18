import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;

public class LandingPage extends SeleniumUtils{

   By menuItems = new By.ByXPath("//a[contains(@id,'shellmenu') or contains(@id,'Teams') or contains(@id,'SmallBusiness') or contains(@id,'support')][contains(@class,'c-uhf-nav-link')]");
   By windowsMenu = new By.ByXPath("//a[@id][normalize-space()='Windows'][@class='c-uhf-nav-link']");
   By aboutWindows = new By.ByXPath("//button[normalize-space()='About Windows']");
   By menuUnderAboutWindows = new By.ByXPath("//button[normalize-space()='About Windows']/following-sibling::ul//li//a");
public void goTo()
{
   seleniumUtils.get("https://www.microsoft.com/en-us/");
}

public void validateMenuItems()
{
   String[] menuUserValues = {"Microsoft 365","Windows" ,"Surface" ,"Xbox" ,"Deals" ,"Small Business" ,"Support"};

   waitForCondition(ExpectedConditions.presenceOfElementLocated(menuItems),60);

   List<String> menuValues = seleniumUtils.findElements(menuItems).stream().map(x->x.getText()).collect(Collectors.toList());

   Arrays.stream(menuUserValues).forEach(x->  Assertions.assertThat(menuValues.contains(x)).as("menu value: " + x + " was not found").isTrue());

}

public void selectMenuItemsInboutWindowsAndPrint()
{
   waitForCondition(ExpectedConditions.visibilityOfElementLocated(windowsMenu),60);
   seleniumUtils.findElement(windowsMenu).click();

   waitForCondition(ExpectedConditions.presenceOfElementLocated(aboutWindows),60);

   seleniumUtils.findElement(aboutWindows).click();

   seleniumUtils.findElements(menuUnderAboutWindows).stream().map(y->y.getText()).forEach(x-> System.out.println(x));

}

}
