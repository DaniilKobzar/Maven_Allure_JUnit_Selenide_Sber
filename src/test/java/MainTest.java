import CoreLogic.AllureSteps;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;


import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class MainTest {
    private AllureSteps steps = new AllureSteps();

    @BeforeAll
    public static void setUp() {
        Configuration.timeout = 25000;
        Configuration.headless = false;
        clearBrowserCache();
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true));
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
        steps.openWebsite();
        steps.checkLicenseTextOnMainPage();
    }

    @Test
    @DisplayName("2 Переход в \"Демо-версию Сбербанк Онлайн\"")
    @Description(value = "Пытаемся войти в \"Демо-версию Сбербанк Онлайн\"")
    @Epic("Регресс тесты")
    @Feature("Тестирование онлайн кабинетов")
    @Severity(value = SeverityLevel.CRITICAL)
    public void findAndLoginDemoCabinet (){
        steps.openWebsite();
        steps.typeWordToSearch("Демо-версия Сбербанк Онлайн");
        steps.clickOnSearchResults("Демо-версия Сбербанк Онлайн");
        steps.closeNeedlessTab();
        steps.closePopUp();
        steps.checkSuccessSbolLogin();
    }

    @Test
    @DisplayName("3 Переход в \"Демо-версию Сбербанк Бизнес Онлайн\"")
    @Description(value = "Пытаемся войти в \"Демо-версию Сбербанк Бизнес Онлайн\"")
    @Epic("Регресс тесты")
    @Feature("Тестирование онлайн кабинетов")
    @Severity(value = SeverityLevel.CRITICAL)
    public void findAndLoginBusinessDemoCabinet (){
        steps.openWebsite();
        steps.typeWordToSearch("Бизнес онлайн");
        steps.clickOnSearchResults("Сбербанк Бизнес Онлайн");
        steps.closeNeedlessTab();
        steps.clickOnWebElement("Демо-доступ");
        steps.clickOnDemoMode();
        steps.checkSuccessBusinessOnlineLogin();
    }

    @Test
    @Flaky
    @DisplayName("4 Поиск вакансии -Java разработчик-")
    @Description(value = "Ищем вакансию для Java разработчика")
    @Epic("Регресс тесты")
    @Severity(value = SeverityLevel.NORMAL)
    //@RepeatedTest(1)
    public void searchVacancy () {
        steps.openWebsite();
        steps.scrollToBottomOfPage();
        steps.clickOnWebElementVacancy("Вакансии");
        steps.searchVacancy("Java разработчик");
        steps.closeNeedlessTab();
        steps.clickOnWebElementSearchVacancy("Java разработчик");
    }

    @Test
    @DisplayName("5 Перейти в раздел \"о банке\" , оценить статью и отправить отзыв")
    @Description(value = "Пишем текст для оценки страницы")
    @Epic("Смок тесты")
    @Severity(value = SeverityLevel.NORMAL)
    public void rateBank (){
        steps.openWebsite();
        steps.clickOnWebElementBank("О банке");
        steps.scrollToBottomOfPage();
        steps.clickOnLike();
        steps.typeOpinionText();
        steps.clickOnWebElementSend("Отправить");
    }

}
