package PageObj;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AboutBankPage {

    @Step("Step {step}. Внизу страницы информации о банке есть текст \"Страница была вам полезна?\" кликнуть на ответ \"да\"")
    public void clickOnLike(int step){
        $(By.xpath("//i[contains(@class,'like-form__icon-like')]//*[local-name()='svg']")).click();
    }

    @Step("Step {step}. В поле для отзыва ввести текст")
    public void typeOpinionText(int step){
        $(By.xpath("//textarea[@placeholder='Что мы могли бы улучшить?']")).setValue("Все здорово!");
    }

}
