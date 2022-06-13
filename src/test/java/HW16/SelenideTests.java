package HW16;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.*;

//1)Первый тест: открытие сайта, ждем попап и кликаем на крестик//

public class SelenideTests {
    @Test
    public void ClosePopup() throws InterruptedException {
        Configuration.browserSize = "1920x1080";
        open("https://www.wikiart.org/ru");
        Thread.sleep(10000);
        $(new ByXPath("//button[1]")).click();
        $("body > div:nth-child(12) > div > div > div").should(Condition.disappear);

    }

    //2)Второй тест: Нажать на инпут формы поиска и задать параметр поиска "Картины". Нажать Enter//
    @Test
    public void SearchButton() {
        $(new ByXPath("//html/body/div[2]/header/nav/form")).click();
        $("input[type='text']").setValue("Коты").pressEnter();
        $(new ByXPath("//div[@class='gallery ng-scope']")).shouldBe(Condition.visible);

    }

    //3)Третий тест: Нажать на первую картинку по результатам поиска.//
    @Test
    public void FirstImageClick() {
        $(new ByXPath("//html/body//div[1]/section/main//ul/li[1]/img")).click();
        $(new ByXPath("//html/body//section[1]//div[2]/aside/div[1]")).shouldBe(Condition.exist);

    }

    //4)Смена языка на английский//

    @Test
    public void ChangeLanguageEn() {
        $(new ByXPath("//html/body/div[2]/header/nav/div[2]/a")).click();
        $(new ByXPath("//html/body/div[2]/header/nav/div[2]/ul/li[1]/a/h6")).click();
        $(new ByXPath("//html/body/div[2]/header/nav/div[2]/a/b")).shouldBe(Condition.visible);
    }

//5)Клик на баннер в хэдэре//

    @Test
    public void BannerClick() {
        $(new ByXPath("/html/body/div[2]/header/div/a/img")).click();
        $(new ByXPath("/html/body/div[2]/header/div/a/img")).should(Condition.disappear);
    }
}


