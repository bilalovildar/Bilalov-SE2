package lesson4;

import lesson4.Triangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class TriangleTest {
    int a = 3;
    int b = 4;
    int c = 5;
    Logger logger = LoggerFactory.getLogger(TriangleTest.class);   //логирование с помощью logback-classic + logback.xml

    @Test
    @DisplayName("Проверка что стороны >0")
    @Tag("lesson4")
    public void assume() {                                            //запускаем вначале
        assumeTrue(a > 0);
        assumeTrue(b > 0);
        assumeTrue(c > 0);
        logger.info("Проверка что стороны >0");
    }
    @Test
    @DisplayName("Проверка формулы площади треугольника")
    @Tag("lesson4")
    public void areaofTriangleTest() {
        assertEquals(6.0, Triangle.areaOfTriangle(a, b, c), "площадь не верная");
        assertTrue(Triangle.isTriangle(a, b, c), "Не треугольник");
        assertFalse(!Triangle.isTriangle(a, b, c), "Не треугольник");     //то же самое, реверс
        assertNotNull(Triangle.areaOfTriangle(a, b, c));
        logger.info("Проверка формулы площади треугольника");
    }
    @Test
    @DisplayName("Проверка что будет Исключение в случае введения string")
    @Tag("lesson4")
    void testException(){
        Assertions.assertThrows(NullPointerException.class, ()-> getException(), "нет исключения");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Integer.parseInt("rtrt");
        });
        logger.info("Проверка что будет Исключение в случае введения string вместо int ");
    }

    private String getException() throws NullPointerException{
        if(true) throw new NullPointerException();
        return "result";
    }
}

