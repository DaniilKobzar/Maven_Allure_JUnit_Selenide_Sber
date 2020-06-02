package PageObj;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DemoBusinessSBPage {

    @Step("Step {step}. Проверить отображение элемента с текстом \"Иванов Иван Иванович\"")
    public void checkSuccessBusinessOnlineLogin(int step){
        String textToCheck = $(by("data-test-id", "HeaderProfileWidget__userName")).getText();
        assertTrue(textToCheck.contains("Иванов Иван Иванович"));
    }

    @Step("Закрываем ненужную вкладку браузера")
    public void closeNeedlessTab(){
        switchTo().window(0).close();
        switchTo().window(0);
    }

    @Step("Step {step}. Кликнуть на: {webElement}")
    public void clickOnWebElement(int step, String webElement){
        $$(byText(""+webElement+"")).find(Condition.visible).click();
    }

    @Step("Step {step}. Кликнуть на \"Войти в демо режим\"")
    public void clickOnDemoMode(int step){
        $(By.xpath("//a[@href='https://sbi.sberbank.ru:9444/ic/dcb/login.html?demoMode&version=3.0']")).click();
    }

}
