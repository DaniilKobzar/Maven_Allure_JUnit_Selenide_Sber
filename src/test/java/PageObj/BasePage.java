package PageObj;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasePage {

    public String startPageUrl = "https://www.sberbank.ru/ru/";

    public String licenseText_text = "//div[@class='footer__info']//p[contains(text(),'лицензия')]";

    private String aboutBank_textLink = "//div[contains(@class,'kit-col kit-col_xs_12 kit-col_md_7 kit-col_lg_7 footer__subfooter-col')]//li[2]//a[1]";

    public String search_button = "//div[@class='ya-site-form-search__button ya-site-form-search_visible ']";

    public String search_textLabel = "ya-site-form__input-text";

    @Step("Step {step}. Перейти на сайт \"https://www.sberbank.ru/ru/person\"")
    public void openWebsite(int step){
        open(startPageUrl);
    }

    @Step("Step {step}. Проверить отображение элемента с текстом и номером лицензии на главной странице")
    public void checkLicenseTextOnMainPage(int step) {
        String availableText = $(By.xpath(licenseText_text)).getText();
        assertTrue(availableText.contains("Генеральная лицензия на осуществление банковских операций от 11 августа 2015 года. Регистрационный номер — 1481."));
    }

    @Step("Step {step}. в поле \"поиск\" указать: {word} и нажать enter")
    public void typeWordToSearch(int step, String word){
        $(By.xpath(search_button)).click();
        $(By.className(search_textLabel)).setValue(word).pressEnter();
    }

    @Step("Step {step}. Кликнуть на: {webElement}")
    public void clickOnAboutBank(int step){
        $(byXpath(aboutBank_textLink)).scrollIntoView(true);
        $(byXpath(aboutBank_textLink)).click();
    }

    @Step("Скролим страницу вниз")
    public void scrollToBottomOfPage(){
        Selenide.executeJavaScript("window.scrollBy(0,10000)");
    }

    @Step("Step {step}. Кликнуть на: {webElement}")
    public void clickOnWebElement(int step, String webElement){
        $$(byText(""+webElement+"")).find(Condition.visible).click();
    }

}
