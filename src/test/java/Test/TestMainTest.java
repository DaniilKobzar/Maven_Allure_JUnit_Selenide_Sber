package Test;

import PageObj.*;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.WebDriverRunner.*;

public class TestMainTest {

    private StepsAll steps = new StepsAll();
    private BasePage basePage = new BasePage();
    private SearchPage searchPage = new SearchPage();
    private DemoSBPage demoSBPage = new DemoSBPage();
    private DemoBusinessSBPage demoBusinessSBPage = new DemoBusinessSBPage();
    private AboutBankPage aboutBankPage = new AboutBankPage();
    private SearchVacancyPage searchVacancyPage = new SearchVacancyPage();



    @BeforeAll
    public static void setUp() {
        Configuration.timeout = 5000;
        Configuration.headless = false;
        clearBrowserCache();
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true));
    }



    @AfterEach
    public void afterEach(){
        attachScreenshot("Last screenshot");
    }

    @Attachment(value = "{attachName}", type = "image/png")
    public static byte[] attachScreenshot(String attachName) {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }


    @AfterAll
    public static void tearDown() {
        SelenideLogger.removeListener("allure");
        closeWebDriver();
    }


    @Test
    @DisplayName("1 Проверка перехода на сайт \"https://www.sberbank.ru/ru/person\"")
    @Description(value = "Загрузка страницы и проверка текста с лицензией")
    @Epic("Смок тесты")
    @Severity(value = SeverityLevel.BLOCKER)
    public void openWebsite (){
        steps.openWebsite(1);
        basePage.checkLicenseTextOnMainPage(2);
    }

    @Test
    @DisplayName("2 Переход в \"Демо-версию Сбербанк Онлайн\"")
    @Description(value = "Пытаемся войти в \"Демо-версию Сбербанк Онлайн\"")
    @Epic("Регресс тесты")
    @Feature("Тестирование онлайн кабинетов")
    @Severity(value = SeverityLevel.CRITICAL)
    public void findAndLoginDemoCabinet (){
        steps.openWebsite(1);
        basePage.typeWordToSearch(2, "Демо-версия Сбербанк Онлайн");
        searchPage.clickOnSearchResults(3,"Демо-версия Сбербанк Онлайн");
        steps.closeNeedlessTab();
        demoSBPage.closePopUp();
        demoSBPage.checkSuccessSbolLogin(4);
    }

    @Test
    @DisplayName("3 Переход в \"Демо-версию Сбербанк Бизнес Онлайн\"")
    @Description(value = "Пытаемся войти в \"Демо-версию Сбербанк Бизнес Онлайн\"")
    @Epic("Регресс тесты")
    @Feature("Тестирование онлайн кабинетов")
    @Severity(value = SeverityLevel.CRITICAL)
    public void findAndLoginBusinessDemoCabinet (){
        steps.openWebsite(1);
        basePage.typeWordToSearch(2,"Бизнес онлайн");
        searchPage.clickOnSearchResults(3,"Сбербанк Бизнес Онлайн");
        steps.closeNeedlessTab();
        steps.clickOnWebElement(4, "Демо-доступ");
        //steps.clickOnDemoMode(5); //этот шаг больше не актуален, сайт изменился, этой страницы нет.
        demoBusinessSBPage.checkSuccessBusinessOnlineLogin(5);
    }

    @Test
    @Flaky
    @DisplayName("4 Поиск вакансии -Java разработчик-")
    @Description(value = "Ищем вакансию для Java разработчика")
    @Epic("Регресс тесты")
    @Severity(value = SeverityLevel.NORMAL)
    public void searchVacancy () {
        steps.openWebsite(1);
        steps.scrollToBottomOfPage();
        steps.clickOnWebElement(2, "Вакансии");
        searchVacancyPage.searchVacancy(3, "Java разработчик");
        steps.closeNeedlessTab();
        steps.clickOnWebElement(4,"Java разработчик");
    }

    @Test
    @DisplayName("5 Перейти в раздел \"о банке\" , оценить статью и отправить отзыв")
    @Description(value = "Пишем текст для оценки страницы")
    @Epic("Смок тесты")
    @Severity(value = SeverityLevel.NORMAL)
    public void rateBank (){
        steps.openWebsite(1);
        basePage.clickOnAboutBank(2);
        steps.scrollToBottomOfPage();
        aboutBankPage.clickOnLike(3);
        aboutBankPage.typeOpinionText(4);
        steps.clickOnWebElement(5,"Отправить");
    }

}


