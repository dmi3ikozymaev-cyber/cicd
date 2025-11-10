package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest {

  @Test
  public void checkAutoButtonText() {
    driver.get("https://auto.drom.ru");
    WebElement button = driver.findElement(By.cssSelector("a[href='https://auto.drom.ru/']"));
    String buttonText = button.getText();
    Assert.assertEquals(buttonText, "Автомобили");
  }

  @Test
  public void checkSpectButtonText() {
    driver.get("https://auto.drom.ru");
    WebElement button = driver.findElement(By.cssSelector("a[href='https://auto.drom.ru/spec/']"));
    String buttonText = button.getText();
    Assert.assertEquals(buttonText, "Авто");
  }
}
