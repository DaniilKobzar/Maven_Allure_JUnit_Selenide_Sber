package PageObj;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchVacancyPage {

    @Step("Step {step}. Ввести в поле \"поиск вакансий\" - {vacancyName}")
    public void searchVacancy(int step, String vacancyName){
        $(By.className("career__search-input")).setValue(""+vacancyName+"").pressEnter();
    }

}
