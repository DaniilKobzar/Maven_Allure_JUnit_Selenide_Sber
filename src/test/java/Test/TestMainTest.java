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

    private BasePage basePageSteps = new BasePage();
    private SearchPage searchPageSteps = new SearchPage();
    private DemoSBPage demoSBPageSteps = new DemoSBPage();
    private DemoBusinessSBPage demoBusinessSBPageSteps = new DemoBusinessSBPage();
    private AboutBankPage aboutBankPageSteps = new AboutBankPage();
    private SearchVacancyPage searchVacancyPageSteps = new SearchVacancyPage();



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
        basePageSteps.openWebsite(1);
        basePageSteps.checkLicenseTextOnMainPage(2);
    }

    @Test
    @DisplayName("2 Переход в \"Демо-версию Сбербанк Онлайн\"")
    @Description(value = "Пытаемся войти в \"Демо-версию Сбербанк Онлайн\"")
    @Epic("Регресс тесты")
    @Feature("Тестирование онлайн кабинетов")
    @Severity(value = SeverityLevel.CRITICAL)
    public void findAndLoginDemoCabinet (){
        basePageSteps.openWebsite(1);
        basePageSteps.typeWordToSearch(2, "Демо-версия Сбербанк Онлайн");
        searchPageSteps.clickOnSearchResults(3,"Демо-версия Сбербанк Онлайн");
        demoSBPageSteps.closeNeedlessTab();
        demoSBPageSteps.closePopUp();
        demoSBPageSteps.checkSuccessSbolLogin(4);
    }

    @Test
    @DisplayName("3 Переход в \"Демо-версию Сбербанк Бизнес Онлайн\"")
    @Description(value = "Пытаемся войти в \"Демо-версию Сбербанк Бизнес Онлайн\"")
    @Epic("Регресс тесты")
    @Feature("Тестирование онлайн кабинетов")
    @Severity(value = SeverityLevel.CRITICAL)
    public void findAndLoginBusinessDemoCabinet (){
        basePageSteps.openWebsite(1);
        basePageSteps.typeWordToSearch(2,"Бизнес онлайн");
        searchPageSteps.clickOnSearchResults(3,"Сбербанк Бизнес Онлайн");
        demoBusinessSBPageSteps.closeNeedlessTab();
        demoBusinessSBPageSteps.clickOnWebElement(4, "Демо-доступ");
        //demoBusinessSBPageSteps.clickOnDemoMode(5); //этот шаг больше не актуален, сайт изменился, этой страницы нет.
        demoBusinessSBPageSteps.checkSuccessBusinessOnlineLogin(5);
    }

    @Test
    @Flaky
    @DisplayName("4 Поиск вакансии -Java разработчик-")
    @Description(value = "Ищем вакансию для Java разработчика")
    @Epic("Регресс тесты")
    @Severity(value = SeverityLevel.NORMAL)
    public void searchVacancy () {
        basePageSteps.openWebsite(1);
        basePageSteps.scrollToBottomOfPage();
        basePageSteps.clickOnWebElement(2, "Вакансии");
        searchVacancyPageSteps.searchVacancy(3, "Java разработчик");
        searchVacancyPageSteps.closeNeedlessTab();
        searchVacancyPageSteps.clickOnWebElement(4,"Java разработчик");
    }

    @Test
    @DisplayName("5 Перейти в раздел \"о банке\" , оценить статью и отправить отзыв")
    @Description(value = "Пишем текст для оценки страницы")
    @Epic("Смок тесты")
    @Severity(value = SeverityLevel.NORMAL)
    public void rateBank (){
        basePageSteps.openWebsite(1);
        basePageSteps.clickOnAboutBank(2);
        basePageSteps.scrollToBottomOfPage();
        aboutBankPageSteps.clickOnLike(3);
        aboutBankPageSteps.typeOpinionText(4);
        aboutBankPageSteps.clickOnWebElement(5,"Отправить");
    }

}


