package CoreLogic;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AllureSteps {


    @Step("Step 1. Перейти на сайт \"https://www.sberbank.ru/ru/person\"")
    public void openWebsite(){
        open("https://www.sberbank.ru/ru/");
    }

    @Step("Step 2. Проверить отображение элемента с текстом и номером лицензии на главной странице")
    public void checkLicenseTextOnMainPage() {
        String availableText = $(By.xpath("//div[@class='footer__info']//p[contains(text(),'лицензия')]")).getText();
        assertTrue(availableText.contains("Генеральная лицензия на осуществление банковских операций от 11 августа 2015 года. Регистрационный номер — 1481."));
    }

    @Step("Step 2. в поле \"поиск\" указать: {word} и нажать enter")
    public void typeWordToSearch(String word){
        $(By.xpath("//div[@class='ya-site-form-search__button ya-site-form-search_visible ']")).click();
        $(By.className("ya-site-form__input-text")).setValue(word).pressEnter();
    }


    @Step("Step 3. Из списка вариантов выбрать ссылку с текстом: {searchResults} и перейти по ней")
    public void clickOnSearchResults(String searchResults){
        $(By.xpath("(//yass-span[contains(.,'"+searchResults+"')])[1]")).click();
    }

    @Step("Step 4. Кликнуть на: {webElement}")
    public void clickOnWebElement(String webElement){
        $$(byText(""+webElement+"")).find(Condition.visible).click();
    }

    @Step("Step 2. кликнуть внизу страницы на: {webElement}")
    public void clickOnWebElementBank(String webElement){
        $$(byText(""+webElement+"")).find(Condition.visible).click();
    }

    @Step("Step 5. Нажать кнопку: {webElement}")
    public void clickOnWebElementSend(String webElement) {
        $$(byText("" + webElement + "")).find(Condition.visible).click();
    }

    @Step("Step 2. кликнуть внизу страницы на: {webElement}")
    public void clickOnWebElementVacancy(String webElement) {
        $$(byText("" + webElement + "")).find(Condition.visible).click();

    }

    @Step("Step 4. Кликнуть на вакансию: {webElement}")
    public void clickOnWebElementSearchVacancy(String webElement){
        $$(byText(""+webElement+"")).find(Condition.visible).click();
    }

    @Step("Step 5. Кликнуть на \"Войти в демо режим\"")
    public void clickOnDemoMode(){
        $(By.xpath("//a[@href='https://sbi.sberbank.ru:9444/ic/dcb/login.html?demoMode&version=3.0']")).click();
    }

    @Step("Step 3. Ввести в поле \"поиск вакансий\" - {vacancyName}")
    public void searchVacancy(String vacancyName){
        $(By.className("career__search-input")).setValue(""+vacancyName+"").pressEnter();
    }

    @Step("Закрываем ненужную вкладку браузера")
    public void closeNeedlessTab(){
        switchTo().window(0).close();
        switchTo().window(0);
    }

    @Step("Скролим страницу вниз")
    public void scrollToBottomOfPage(){
        Selenide.executeJavaScript("window.scrollBy(0,10000)");
    }

    @Step("Закрываем всплывающее окно")
    public void closePopUp(){
        $(By.xpath("//a[@class='close']")).click();
    }

    @Step("Step 3. Внизу страницы информации о банке есть текст \"Страница была вам полезна?\" кликнуть на ответ \"да\"")
    public void clickOnLike(){
        $(By.xpath("//i[contains(@class,'like-form__icon-like')]//*[local-name()='svg']")).click();
    }

    @Step("Step 4. В поле для отзыва ввести текст")
    public void typeOpinionText(){
        $(By.xpath("//textarea[@placeholder='Что мы могли бы улучшить?']")).setValue("Все здорово!");
    }

    @Step("Step 4. Проверить отображение элемента с текстом \"Демо-версия\"")
    public void checkSuccessSbolLogin(){
        String textToCheck = $(By.xpath("//div[@class='simulator-title']")).getText();
        assertTrue(textToCheck.contains("Демо-версия"));
    }

    @Step("Step 6. Проверить отображение элемента с текстом \"Иванов Иван Иванович\"")
    public void checkSuccessBusinessOnlineLogin(){
        String textToCheck = $(by("data-test-id", "HeaderProfileWidget__userName")).getText();
        assertTrue(textToCheck.contains("Иванов Иван Иванович"));
    }

//    еще один вариант просто делать скриншоты, явно указывая в шагах теста метод makeScreenshot("Имя_файла")
//    public String getCurrentDateAndTime() {
//        DateFormat dateFormat = new SimpleDateFormat("HH.mm.ss");
//        Date today = Calendar.getInstance().getTime();
//        String date = dateFormat.format(today);
//        return date;
//    }
//
//    public void makeScreenshot(String fileName) {
//        try {
//            Allure.addAttachment(fileName + ".png", new FileInputStream(screenshot(fileName+getCurrentDateAndTime())));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }}
}
