package lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class BBCMainPageSearchTest extends TKabstractTest {
// ТК4  проверка поля поиска главной страницы
    @Test
    @Tag("lesson6")
    void MainPageSearchTest() {
        new BBCMainPage(getdriver()).inputSearch();
        Assertions.assertTrue(getdriver().getTitle().equals("BBC - Search results for Macron"), "отфильтрованная страница с поиском не открылась");
    }
}
