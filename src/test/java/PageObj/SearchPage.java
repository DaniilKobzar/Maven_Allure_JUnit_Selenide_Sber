package PageObj;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    @Step("Step {step}. Из списка вариантов выбрать ссылку с текстом: {searchResults} и перейти по ней")
    public void clickOnSearchResults(int step, String searchResults) {
        $(By.xpath("(//yass-span[contains(.,'" + searchResults + "')])[1]")).click();
    }
}
