package lesson4;
//        Практическое задание 4 JUnit Geekbrains

//        1.Напишите функцию, вычисляющую площадь треугольника по трём сторонам( int a, int b, int c).Разместите класс
//        с функцией в src/main / java.
//        2.Разместите тесты на эту функцию в классе src / test / java /.../TriangleTest.java.
//        3.Настройте генерацию отчёта и по желанию —логирование.

//        Студент Билалов Ильдар, 2022г

public class Triangle {

    public static Double areaOfTriangle(int a, int b, int c) {
        double pp = (a + b + c)/2.0;                                        //pp-полупериметр
        Double s = Math.sqrt(pp * (pp - a) * (pp - b) * (pp - c));
        return s;
    }
    public static boolean isTriangle(int a, int b, int c) {
        return ((a + b > c) && (b + c > a) && (c + a > b));
    }

}
