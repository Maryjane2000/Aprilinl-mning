import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class MyStepdefs {

    WebDriver driver;

    @Given("I have opened {string} browser")
    public void iHaveOpenedBrowser(String browser) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\milli\\Desktop\\/Selenium/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://login.mailchimp.com/signup/");
    }

    @Given("I write an email")
    public void iWriteAnEmail() {
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("viydonuspe@vusra.com");
    }

    @Given("I write a username")
    public void iWriteAUsername() {
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("123456677@mail.com");
    }

    @Given("I write a password")
    public void iWriteAPassword() {
        WebElement password = driver.findElement(By.id("new_password"));
        password.sendKeys("!1AdpL6789");
    }

    @When("I click the sign in button")
    public void iClickTheSignInButton() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,3000)", "");

        WebElement cookie = driver.findElement(By.id("onetrust-reject-all-handler"));
        cookie.click();

        WebElement button = driver.findElement(By.id("create-account"));
        button.click();
    }

    @Then("I get the result if the account is created or not")
    public void iGetTheResultIfTheAccountIsCreatedOrNot() {
        WebElement a = driver.findElement(By.cssSelector("h1[class='!margin-bottom--lv3 no-transform center-on-medium']"));
        assertEquals("Check your email", a.getText());
    }

    @Given("I write a username with more than {int} characters")
    public void iWriteAUsernameWithMoreThanCharacters(int more) {
        //Username with more than 100,characters(115)
        WebElement username115 = driver.findElement(By.name("username"));
        username115.sendKeys("12fjbjvst797tgvxry008525fvkdazew4r690hivdxrsxbSSASDFGHJKLoijuhgVFCDHBf123456TCVNBNVDDRFGf1MJkhgbGyhj1245FGJKmnhfhfJ");

    }

    @When("I click the sign in button again")
    public void iClickTheSignInButtonAgain() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,5000)", "");

        WebElement cookie = driver.findElement(By.id("onetrust-reject-all-handler"));
        cookie.click();

        WebElement button = driver.findElement(By.id("create-account"));
        button.click();
    }

    @Then("I get the result from a username with more than {int} characters")
    public void iGetTheResultFromAUsernameWithMoreThanCharacters(int more) {
        WebElement b = driver.findElement(By.cssSelector("span [class='invalid-error']"));
        assertEquals("Enter a value less than 100 characters long", b.getText());
    }

    @Given("I write an email that already exist")
    public void iWriteAnEmailThatAlreadyExist() {
        //Already existing email
        WebElement emailx = driver.findElement(By.id("email"));
        emailx.sendKeys("viydonuspe@vusra.com");
    }

    @When("I click the sign in button{int}")
    public void iClickTheSignInButton(int arg0) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,3000)", "");

        WebElement cookie = driver.findElement(By.id("onetrust-reject-all-handler"));
        cookie.click();

        WebElement button = driver.findElement(By.id("create-account"));
        button.click();
    }

    @Then("I get the result if email already exist")
    public void iGetTheResultIfEmailAlreadyExist() {

        WebElement c = driver.findElement(By.cssSelector("h1[class='!margin-bottom--lv3 no-transform center-on-medium']"));
        assertEquals("Check your email", c.getText());

        WebElement d = driver.findElement(By.cssSelector("span [class='invalid-error']"));
        assertEquals("Another user with this username already exists. Maybe it's your evil twin. Spooky.", d.getText());

        WebElement e = driver.findElement(By.cssSelector("h1[class='!margin-bottom--lv3 no-transform center-on-medium']"));
        assertEquals("Check your email", e.getText());

    }

    @Given("I write a username that already exist")
    public void iWriteAUsernameThatAlreadyExist() {
        //Already existing username
        WebElement usernamex = driver.findElement(By.name("username"));
        usernamex.sendKeys("Tiger123Fjip");
    }


    @Given("I write a password that already exist")
    public void iWriteAPasswordThatAlreadyExist() {
        //Already existing password
        WebElement passwordx = driver.findElement(By.id("new_password"));
        passwordx.sendKeys("!1AdpL6789");
    }


    @Given("I do not write an email")
    public void iDoNotWriteAnEmail() {
        //No email
        WebElement emailno = driver.findElement(By.id("email"));
        emailno.sendKeys("");
    }

    @Then("I get the result")
    public void iGetTheResult() {
        WebElement result = driver.findElement(By.cssSelector("span class='invalid-error'"));
        assertEquals("Please enter a value", result.getText());
    }

    @After
    public void teardown() {
        driver.quit();
    }


}
