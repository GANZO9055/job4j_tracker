package ru.job4j.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " передвигается по рельсам.");
    }

    @Override
    public void refuel() {
        System.out.println(getClass().getSimpleName() + " заправляется в депо.");
    }

    @Override
    public void repair() {
        System.out.println(getClass().getSimpleName() + " обслуживается в цеху.");
    }
}
