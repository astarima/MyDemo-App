package steps;

import io.appium.java_client.AppiumBy;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import setup.StartStopServer;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Steps extends StartStopServer {

    @Before("@setUp")
    public void setup() {
        runServer();
    }

    @After("@setUp")
    public void stop() {
        tearDown();
    }

    @Given("User is on {string} page")
    public void user_is_on_page(String page) {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"" + page + "\")")).isDisplayed();
    }

    @Given("User is on Login page")
    public void user_is_on_login_page() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.widget.ImageView\").instance(0)")).click();
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"Log In\")")).isDisplayed();
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"Log In\")")).click();
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"Login\")")).isDisplayed();

    }

    @Given("User is logged in")
    public void user_is_logged_in() {
        WebElement name = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().description(\"Username input field\")"));
        name.sendKeys("bob@example.com");
        WebElement password = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().description(\"Password input field\")"));
        password.sendKeys("10203040");
        driver.findElement(AppiumBy.accessibilityId("Login button")).click();

    }

    @Given("User puts item in a cart and goes to checkout page")
    public void user_put_item_in_a_cart_and_go_to_checkout_page() throws InterruptedException {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"Sauce Labs Backpack\")")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").instance(36)")).click();
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"Add To Cart\")")).click();
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.widget.ImageView\").instance(2)")).click();
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"Proceed To Checkout\")")).click();
        Thread.sleep(1000);
    }

    @When("User clicks {string} button")
    public void user_click_button(String button) {
        driver.findElement(AppiumBy.accessibilityId(button)).click();
    }

    @And("User clicks sort by button")
    public void user_click_sort_by_button() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.widget.ImageView\").instance(2)")).click();

    }

    @Then("First product title is {string}")
    public void first_product_title_is(String title) {
        String element = driver.findElements(AppiumBy.androidUIAutomator(
                "description(\"store item text\")")).get(0).getText();
        assertEquals(element, title);

    }


    @When("User clicks menu button")
    public void user_click_menu_button() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.widget.ImageView\").instance(0)")).click();
    }

    @Then("Log in is visible")
    public void isVisible() {
        String element = driver.findElement(AppiumBy.androidUIAutomator("text(\"Log In\")")).getText();
        assertEquals(element, "Log In");

    }

    @When("User clicks Log in button")
    public void user_click_log_in_button() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "text(\"Log In\")")).click();
    }


    @When("User enters valid username")
    public void user_enter_valid_username() {
        WebElement name = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().description(\"Username input field\")"));
        name.sendKeys("bob@example.com");
    }

    @And("User enters valid password")
    public void user_enter_valid_password() {
        WebElement password = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().description(\"Password input field\")"));
        password.sendKeys("10203040");
    }

    @And("User clicks Login button")
    public void user_click_login_button() {
        driver.findElement(AppiumBy.accessibilityId("Login button")).click();

    }


    @When("User enters not valid Username")
    public void user_enter_not_valid_username() {
        WebElement name = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().description(\"Username input field\")"));
        name.sendKeys("simas@example.com");
    }

    @And("User enters not valid Password")
    public void user_enter_not_valid_password() {
        WebElement password = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().description(\"Password input field\")"));
        password.sendKeys("123456789");
    }

    @Then("User gets error message")
    public void user_get_error_message() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"Provided credentials do not match any user in this service.\")")).isDisplayed();

    }

    @When("User enters locked out user credentials")
    public void user_enter_locked_out_user_credentials() {
        WebElement name = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().description(\"Username input field\")"));
        name.sendKeys("alice@example.com");

    }

    @Then("User gets error message Sorry")
    public void user_get_error_message_sorry() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"Sorry, this user has been locked out.\")"));

    }

    @Then("Log out is visible")
    public void is_visible() {
        String element = driver.findElement(AppiumBy.androidUIAutomator("text(\"Log Out\")")).getText();
        assertEquals(element, "Log Out");

    }


    @When("User clicks Log Out button")
    public void user_click_log_out_button() throws InterruptedException {
        driver.findElement(AppiumBy.androidUIAutomator(
                "text(\"Log Out\")")).click();


    }

    @Then("User gets a message")
    public void user_get_a_message() throws InterruptedException {
        driver.findElement(AppiumBy.androidUIAutomator(
                "text(\"Are you sure you sure you want to logout?\")")).isDisplayed();
        Thread.sleep(1000);

    }

    @When("User clicks Logout button")
    public void user_click_logout_button() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().resourceId(\"android:id/button1\")")).click();

    }

    @Then("User gets popup with a message")
    public void user_get_popup_with_a_message() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "text(\"You are successfully logged out.\")")).isDisplayed();

    }

    @When("User clicks “OK“")
    public void user_click_OK() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().resourceId(\"android:id/button1\")")).click();

    }

    @When("User clicks Cancel")
    public void user_click_cancel() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().resourceId(\"android:id/button2\")")).click();

    }


    @When("User fills in shipping address fields")
    public void user_fill_in_shipping_address_fields() throws InterruptedException {
        Thread.sleep(1000);
        List<WebElement> input = driver.findElements(AppiumBy.className("android.widget.EditText"));
        input.get(0).sendKeys("Rebecca Winter");
        input.get(1).sendKeys("Mandorley 112");
        input.get(3).sendKeys("Truro");
        input.get(4).sendKeys("Cornwall");
        input.get(5).sendKeys("89750");
        input.get(6).sendKeys("United Kingdom");

    }

    @When("User clicks the To Payment button")
    public void user_click_the_to_payment_button() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"To Payment\")")).click();

    }

    @Then("User is navigated to the Checkout page")
    public void user_is_navigated_to_the_checkout_page() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"Checkout\")")).isDisplayed();

    }


    @When("User fills in the payment method fields")
    public void user_fill_in_the_payment_method_fields() {
        List<WebElement> paymentInput = driver.findElements(AppiumBy.androidUIAutomator("className(android.widget.EditText)"));
        paymentInput.get(0).sendKeys("Rebecca Winter");
        paymentInput.get(1).sendKeys("3258 1265 7568 789");
        paymentInput.get(2).sendKeys("03/25");
        paymentInput.get(3).sendKeys("123");
    }

    @And("User clicks the Review Order button")
    public void user_click_the_review_order_button() {
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Review Order\")")).click();
    }

    @Then("User is navigated to the review order page")
    public void user_is_navigated_to_the_review_order_page() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"Review your order\")")).isDisplayed();
    }

    @When("User checks all details are correct")
    public void user_check_all_details_are_correct() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"Delivery Address\")")).isDisplayed();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"Payment Method\")")).isDisplayed();

    }

    @And("User clicks the Place Order button")
    public void user_click_the_place_order_button() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"Place Order\")")).click();
    }

    @Then("User received a message")
    public void user_received_a_message() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"Checkout Complete\")")).isDisplayed();
    }

    @When("User clicks the Continue Shopping button")
    public void user_click_the_continue_shopping_button() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"Continue Shopping\")")).click();
    }

    @Then("User is redirected to the main shopping page")
    public void user_is_redirected_to_the_main_shopping_page() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"Products\")")).isDisplayed();
    }
}
