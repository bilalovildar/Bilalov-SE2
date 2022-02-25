package lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class LogoTest extends TKabstractTest {
// TK2 проверка ЛОГО сайта , должно возвращать на главную страницу
    @Test
    @Tag("lesson6")
    void clickToSport(){
        new BBCMainPage(getdriver()).navigateToSport();
        Assertions.assertEquals("https://www.bbc.com/sport",getdriver().getCurrentUrl());
    }

    @Test
    @Tag("lesson6")
    void clickToTravel(){
        new BBCMainPage(getdriver()).navigateToTravel();
        Assertions.assertEquals("https://www.bbc.com/travel",getdriver().getCurrentUrl());
    }

    @Test
    @Tag("lesson6")
    void clickToLogo(){
        new BBCMainPage(getdriver()).navigateToLogo();
        Assertions.assertTrue(getdriver().getTitle().equals("BBC - Homepage"), "страница входа недоступна");
    }

}
