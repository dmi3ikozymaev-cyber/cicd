package tests;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.net.URL;

public class BaseTest {
  protected WebDriver driver;

  @BeforeMethod
  public void setUp() throws Exception {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");

    String remoteUrl = System.getenv("SELENIUM_REMOTE_URL");
    driver = new RemoteWebDriver(new URL(remoteUrl), options);
  }

  public void openMainPage() {
    Allure.step("Открыть страницу auto.drom.ru");
    driver.get("https://auto.drom.ru");
    String url = driver.getCurrentUrl();
    Assert.assertEquals(url, "https://auto.drom.ru/");
  }

  public void checkTextButton(String selector, String text) {
    Allure.step("Проверить текст в кнопке");
    WebElement button = driver.findElement(By.cssSelector(selector));
    String buttonText = button.getText();
    Assert.assertEquals(buttonText, text);
  }

  public void checkTextMotoButton() {
    Allure.step("Проверить текст в кнопке Мото");
    WebElement button = driver.findElement(By.cssSelector("a[href='https://auto.drom.ru/moto/']"));
    String buttonText = button.getText();
    Assert.assertEquals(buttonText, "Мото1");
  }

  @AfterMethod
  public void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }
}
