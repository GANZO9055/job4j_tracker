package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int b) {
        return b - x;
    }

    public int divide(int c) {
        return x / c;
    }

    public int sumAllOperation(int d) {
        return sum(d) + multiply(d) + minus(d) + divide(d);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);

        Calculator test = new Calculator();
        int rsl = test.sumAllOperation(10);
        System.out.println(rsl);

        int testOne = minus(6);
        System.out.println(testOne);

        int testTwo = test.multiply(4);
        System.out.println(testTwo);

        int testThree = test.divide(2);
        System.out.println(testThree);
    }
}
