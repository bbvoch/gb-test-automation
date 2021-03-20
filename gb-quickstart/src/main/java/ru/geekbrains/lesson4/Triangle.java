package ru.geekbrains.lesson4;

public class Triangle {

    static double square(double a, double b, double c) {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public static void main(String[] args) {
        System.out.println(square(1,1,12));
    }
}
