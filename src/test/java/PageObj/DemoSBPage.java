package PageObj;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DemoSBPage {

    @Step("Закрываем всплывающее окно")
    public void closePopUp(){
        $(By.xpath("//a[@class='close']")).click();

    }

    @Step("Step {step}. Проверить отображение элемента с текстом \"Демо-версия\"")
    public void checkSuccessSbolLogin(int step){
        String textToCheck = $(By.xpath("//div[@class='simulator-title']")).getText();
        assertTrue(textToCheck.contains("Демо-версия"));
    }

}
