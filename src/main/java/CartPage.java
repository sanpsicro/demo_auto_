import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends SeleniumUtils{

   By cart = By.xpath("//a[@id='uhf-shopping-cart']");
   By addToCart = By.xpath("//button[normalize-space()='Add to cart']");
   By allPrices = By.xpath("//span[contains(text(),'$')][not(@class)]");

   public static String itemValue;
   public static String itemValueInSubscription;

   public void goToCart()
   {
      waitForCondition(ExpectedConditions.visibilityOfElementLocated(cart),60);
      clickBy(cart);

   }

   public void addToCart()
   {

      clickBy(addToCart);
   }

   public void validatePrices()
   {
      waitForCondition(ExpectedConditions.visibilityOfElementLocated(allPrices),60);
      List<String> prices = seleniumUtils.findElements(allPrices).stream().map(x->x.getText()).collect(Collectors.toList());

      prices.stream().allMatch(x->x==prices.get(0));
   }

}
