package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
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

  @AfterMethod
  public void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }
}
