package ru.geekbrains.lesson4;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TriangleTests {

    static final Logger log = LoggerFactory.getLogger(TriangleTests.class);

    @DisplayName("Тест по проверке вычиселения площади треугольника по формуле Герона")
    @Test
    void testSquare(){
        log.info("\t\t\tSTART WORK TEST");

        double act_res = Triangle.square(14,12,12);
        double exp_res = 68.23;

        Assertions.assertEquals(exp_res, act_res);

        log.info("\t\t\tEND WORK TEST");
    }

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
}
