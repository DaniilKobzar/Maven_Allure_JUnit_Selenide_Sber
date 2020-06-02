package PageObj;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AboutBankPage {

    private String bankInfo_textLink = "//label[1]//span[1]";

    private String myOpinion_textLabel = "//textarea[contains(@placeholder,'Будем рады любому вашему комментарию или предложению')]";


    @Step("Step {step}. Внизу страницы информации о банке есть текст \"Страница была вам полезна?\" кликнуть на ответ \"да\"")
    public void clickOnLike(int step){
        $(By.xpath(bankInfo_textLink)).click();
    }

    @Step("Step {step}. В поле для отзыва ввести текст")
    public void typeOpinionText(int step){
        $(By.xpath(myOpinion_textLabel)).setValue("Все здорово!");
    }

    @Step("Step {step}. Кликнуть на: {webElement}")
    public void clickOnWebElement(int step, String webElement){
        $$(byText(""+webElement+"")).find(Condition.visible).click();
    }

}
