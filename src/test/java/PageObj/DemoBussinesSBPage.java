package PageObj;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DemoBussinesSBPage {

    @Step("Step {step}. Проверить отображение элемента с текстом \"Иванов Иван Иванович\"")
    public void checkSuccessBusinessOnlineLogin(int step){
        String textToCheck = $(by("data-test-id", "HeaderProfileWidget__userName")).getText();
        assertTrue(textToCheck.contains("Иванов Иван Иванович"));
    }

}
