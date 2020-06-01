package PageObj;


import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasePage {

    public String startPageUrl = "https://www.sberbank.ru/ru/";
    public String licenseTextXp = "//div[@class='footer__info']//p[contains(text(),'лицензия')]";
    public String searchButtonXp = "//div[@class='ya-site-form-search__button ya-site-form-search_visible ']";
    public String searchFieldXp = "ya-site-form__input-text";

    @Step("Step {step}. Проверить отображение элемента с текстом и номером лицензии на главной странице")
    public void checkLicenseTextOnMainPage(int step) {
        String availableText = $(By.xpath(licenseTextXp)).getText();
        assertTrue(availableText.contains("Генеральная лицензия на осуществление банковских операций от 11 августа 2015 года. Регистрационный номер — 1481."));
    }

    @Step("Step {step}. в поле \"поиск\" указать: {word} и нажать enter")
    public void typeWordToSearch(int step, String word){
        $(By.xpath("//div[@class='ya-site-form-search__button ya-site-form-search_visible ']")).click();
        $(By.className("ya-site-form__input-text")).setValue(word).pressEnter();
    }

    @Step("Step {step}. Кликнуть на: {webElement}")
    public void clickOnAboutBank(int step){
        String aboutBank = "//div[contains(@class,'kit-col kit-col_xs_12 kit-col_md_7 kit-col_lg_7 footer__subfooter-col')]//li[2]//a[1]";
        $(byXpath(aboutBank)).scrollIntoView(true);
        $(byXpath(aboutBank)).click();
    }

}
