package PageObj;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchVacancyPage {

    private String search_textLabel = "career__search-input";

    @Step("Step {step}. Ввести в поле \"поиск вакансий\" - {vacancyName}")
    public void searchVacancy(int step, String vacancyName){
        $(By.className(search_textLabel)).setValue(""+vacancyName+"").pressEnter();
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

}
