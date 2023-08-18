import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LandingPageTests {

    LandingPage landingPage;
    SearchPage searchPage;
    CartPage cartPage;

    @BeforeSuite
    public void setUp()
    {
        landingPage = new LandingPage();
        searchPage = new SearchPage();
        cartPage = new CartPage();

    }

    @Test
    public void performDemoTstcase()
    {
        landingPage.goTo();

        landingPage.validateMenuItems();

        landingPage.selectMenuItemsInboutWindowsAndPrint();

        searchPage.performASearch("Visual Studio");

        searchPage.selectFirstValue();

        searchPage.getPrice();

        searchPage.validatePricesAreDifferent();

        cartPage.addToCart();

        cartPage.validatePrices();
    }


}
