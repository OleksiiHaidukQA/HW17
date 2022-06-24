package HW17JUnit;

import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class SelenideTests extends BaseSetup {
    private final static String Base_URL = "https://www.wikiart.org/ru";
    private final SelenideElement paintingOfaDay = $x("//html/body//main//article/h3/a");
    public static final String DEFAULT_USERNAME = "AleksGayduk@gmail.com";
    public static final String DEFULT_USERNAME_PASSWORD = "Q123q123";

    //1) Открытие браузера. Нажатие на "Картина дня".
    @Test
    public void clickOnPaint() {
        open("https://www.wikiart.org/ru");
        $x("//html/body//main//article/h3/a").click();
        Assertions.assertTrue(true);
        sleep(5000);
    }


    //2) Нажать на кнопку "Источники" под картиной.
    @Test
    public void clickOnDescription() {
        $(new By.ByXPath("/html/body//section[1]/main/div[2]/div[1]/div/a[2]")).click();
        Assertions.assertTrue(true);
    }

    //3) Логин существующего пользователя.
    @Test
    public void loginDefaultUser() {
        $(By.cssSelector(" a.wiki-top-menu-auth")).click();
        $(By.cssSelector("body > div.modal")).click();
        $(DEFAULT_USERNAME).pressTab();
        $(DEFULT_USERNAME_PASSWORD).pressEnter();
        Assertions.assertTrue(true);

    }

    //4) Переключение стрелочки вправо.
    @Test
    public void pressArrow() {
        $(new By.ByXPath("/html/body//section[1]/main//div[2]/a[2])")).click();
        Assertions.fail();
    }

    //5) Нажатие на лого.
    public void pressLogo() {
        $(new By.ByXPath("/html/body/div[2]/header/nav/form/a[2]")).click();
        Assertions.assertTrue(Boolean.parseBoolean(Base_URL));
    }
}