package ru.geekbrains.lesson4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class TriangleTests {

    static final Logger log = LoggerFactory.getLogger(TriangleTests.class);

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    @DisplayName("Тест по проверке вычиселения площади треугольника по формуле Герона")
    @Test
    void testSquare(){
        log.info("\t\t\tSTART WORK TEST");

        double value = Triangle.square(14,12,12);
        double scale = Math.pow(10, 2);
        double act_res = Math.ceil(value * scale) / scale;
        double exp_res = 68.23;

        Assertions.assertEquals(exp_res, act_res);

        log.info("\t\t\tEND WORK TEST");
    }

    @DisplayName("Тест по проверке вычиселения площади треугольника по формуле Герона")
    @RepeatedTest(5)
    void testSquareRepeated(){
        log.info("\t\t\tSTART WORK TEST");

        double a = (int) (Math.random() * 20);
        double b = (int) (Math.random() * 20);
        double c = (int) (Math.random() * 20);
        double p = (a + b + c) / 2;

        double act_res = Triangle.square(a,b,c);
        double exp_res = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        Assertions.assertEquals(exp_res, act_res);

        log.info("\t\t\tEND WORK TEST");
    }

    @DisplayName("Негативный тест по проверке вычиселения площади треугольника по формуле Герона")
    @ParameterizedTest(name="#{index}- Test with Argument={arguments}")
    @CsvSource({"1, 2, 12"})
    void testSquareNegative(double a, double b, double c){
        log.info("\t\t\tSTART WORK TEST");

        double res = Triangle.square(a,b,c);

        Assertions.assertFalse(isNumeric(String.valueOf(res)));

        log.info("\t\t\tEND WORK TEST");
    }
}
