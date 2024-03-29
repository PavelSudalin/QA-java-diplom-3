package ru.yandex.praktikum;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.pages.MainPage;

@DisplayName("Проверка работы перехода к разделам")
public class RedirectionTest extends TestBase{

    @Before
    public void setUp() {
        Configuration.headless = true;
        optionBrowser("chrome");
        Selenide.open("https://stellarburgers.nomoreparties.site/");
    }
    @Test
    @DisplayName("Переход на вкладку Булки")
    public void switchToTabBun() {
        new MainPage().clickBunButton().checkingTransitionToBun();
    }
    @Test
    @DisplayName("Переход на вкладку Соусы")
    public void switchToTabSauces() {
        new MainPage().clickSauceButton().checkingTransitionToSauce();
    }
    @Test
    @DisplayName("Переход на вкладку Начинки")
    public void switchToTabToppings() {
        new MainPage().clickIngredientsButton().checkingTransitionToIngredients();
    }

    @After
    public void teardown() {
        Selenide.closeWebDriver();
    }
}
