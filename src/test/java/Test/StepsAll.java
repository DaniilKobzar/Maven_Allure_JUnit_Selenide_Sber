package Test;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class StepsAll {


    @Step("Step {step}. Перейти на сайт \"https://www.sberbank.ru/ru/person\"")
    public void openWebsite(int step){
        open("https://www.sberbank.ru/ru/");
    }

    @Step("Step {step}. Кликнуть на: {webElement}")
    public void clickOnWebElement(int step, String webElement){
        $$(byText(""+webElement+"")).find(Condition.visible).click();
    }

    @Step("Step {step}. Кликнуть на \"Войти в демо режим\"")
    public void clickOnDemoMode(int step){
        $(By.xpath("//a[@href='https://sbi.sberbank.ru:9444/ic/dcb/login.html?demoMode&version=3.0']")).click();
    }

    @Step("Закрываем ненужную вкладку браузера")
    public void closeNeedlessTab(){
        switchTo().window(0).close();
        switchTo().window(0);
    }

    @Step("Скролим страницу вниз")
    public void scrollToBottomOfPage(){
        Selenide.executeJavaScript("window.scrollBy(0,10000)");
    }


}
