package tests;

import org.testng.annotations.Test;

public class MainPageTest extends BaseTest {

  @Test(description = "Проверка кнопки Автомобили")
  public void checkAutoButtonText() {
    openMainPage();
    checkTextButton("a[href='https://auto.drom.ru/']", "Автомобили");
  }

  @Test(description = "Проверка кнопки Спецтехника")
  public void checkSpectButtonText() {
    openMainPage();
    checkTextButton("a[href='https://auto.drom.ru/spec/']", "Автомобили");
    checkTextMotoButton();
  }
}
