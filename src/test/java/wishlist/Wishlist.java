package wishlist;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Wishlist {
    WebDriver driver;
    WebElement wishlistLink;

    @Given("the user opens the homepage")
    public void userGoToShopPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://fakestore.testelka.pl");
    }

    @When("the user clicks on the {string} category")
    public void theUserClicksOnTheCategory(String categoryName) {
        WebElement categoryElement = driver.findElement(By.xpath("//h2[contains(., '" + categoryName + "')]/parent::a"));
        categoryElement.click();
    }

    @And("the user searches for the trip {string}")
    public void theUserSearchesForTheTrip(String tripName) {
        WebElement tripElement = driver.findElement(By.xpath("//*[@id=\"main\"]/ul/li[1]/a[1]"));
        tripElement.click();
    }

    @And("the user adds the trip to the wishlist")
    public void theUserAddsTheTripToTheWishlist() {
        WebElement wishList = driver.findElement(By.xpath("//*[@id=\"product-386\"]/div[2]/div[2]/div/a"));
        try {
            WebElement storeNotice = driver.findElement(By.className("woocommerce-store-notice"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';", storeNotice);
        } catch (Exception e) {
            // ignore if not present
        }
        wishList.click();
        // Wait for the confirmation of adding to the wishlist
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".yith-wcwl-wishlistaddedbrowse")));
    }

    @And("the user sees a confirmation message that the trip was added to the wishlist")
    public void theUserSeesAConfirmationMessageThatTheTripWasAddedToTheWishlist() {
        WebElement confirmationMessage = driver.findElement(By.cssSelector(".yith-wcwl-wishlistaddedbrowse .feedback"));

        // Check if the message text is "Produkt dodany!"
        String confirmationText = confirmationMessage.getText();
        Assert.assertEquals("Produkt dodany!", confirmationText);

    }

    @And("the user navigates to the wishlist")
    public void theUserNavigatesToTheWishlist() {
        driver.get("https://fakestore.testelka.pl/wishlist/");
    }

    @Then("the trip {string} should be in the wishlist")
    public void theTripShouldBeInTheWishlist(String expectedTripName) {

        // Fetch all product names
        List<WebElement> productNames = driver.findElements(By.cssSelector("td.product-name a"));

        System.out.println("=== Products found in the wishlist ===");
        for (WebElement product : productNames) {
            System.out.println("Found: " + product.getText());
        }

        boolean productFound = productNames.stream()
                .anyMatch(product -> product.getText().equalsIgnoreCase(expectedTripName));

        Assert.assertTrue("Trip '" + expectedTripName + "' was not found in the wishlist", productFound);
    }

    @And("the user verifies that the {string} button is visible for the trip")
    public void theUserVerifiesThatTheButtonIsVisibleForTheTrip(String Remove) {
WebElement removeButton = driver.findElement(By.cssSelector(".remove.remove_from_wishlist"));
String removeText = removeButton.getText();
Assert.assertEquals("×", removeText);

    }

    @And("the user closes the browser")
    public void theUserClosesTheBrowser() {
        driver.quit();
    }
}
