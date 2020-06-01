package PageObj;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AboutBankPage {

    @Step("Step {step}. Внизу страницы информации о банке есть текст \"Страница была вам полезна?\" кликнуть на ответ \"да\"")
    public void clickOnLike(int step){
        $(By.xpath("//label[1]//span[1]")).click();
    }

    @Step("Step {step}. В поле для отзыва ввести текст")
    public void typeOpinionText(int step){
        $(By.xpath("//textarea[contains(@placeholder,'Будем рады любому вашему комментарию или предложению')]")).setValue("Все здорово!");
    }

}
