import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SearchPage extends SeleniumUtils{

   By magnifyingGlass = new By.ById("search");
   By inputFieldSearch = new By.ById("cli_shellHeaderSearchInput");
   By searchSuggestions = By.xpath("//*[@id='universal-header-search-auto-suggest-ul']//li[1]");
   By priceLabel = By.xpath("//span[@data-automation-test-id='buy-box-price']");
   By getVSEnterpriseSubs = By.xpath("//a[normalize-space()='Get a Visual Studio Enterprise subscription']");

   public static String itemValue;
   public static String itemValueInSubscription;

   public void performASearch(String valueToSearch)
   {
      waitForCondition(ExpectedConditions.visibilityOfElementLocated(magnifyingGlass),60);
      seleniumUtils.findElement(magnifyingGlass).click();

      waitForCondition(ExpectedConditions.visibilityOfElementLocated(inputFieldSearch),60);
      seleniumUtils.findElement(inputFieldSearch).sendKeys(valueToSearch);


   }

   public void selectFirstValue()
   {
      waitForCondition(ExpectedConditions.visibilityOfElementLocated(searchSuggestions),60);
      clickBy(searchSuggestions);
   }

   public  void getPrice()
   {
      waitForCondition(ExpectedConditions.visibilityOfElementLocated(priceLabel),60);
      itemValue =  seleniumUtils.findElement(priceLabel).getText();

   }

   public void validatePricesAreDifferent()
   {
      String newPriceLabel;
      waitForCondition(ExpectedConditions.visibilityOfElementLocated(getVSEnterpriseSubs),60);
      seleniumUtils.findElement(getVSEnterpriseSubs).click();

      waitForCondition(ExpectedConditions.visibilityOfElementLocated(priceLabel),60);
      newPriceLabel = seleniumUtils.findElement(priceLabel).getText();

      Assertions.assertThat(itemValue).isNotEqualTo(newPriceLabel);
   }

}
