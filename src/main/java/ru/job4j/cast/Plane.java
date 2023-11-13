package ru.job4j.cast;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летает по воздуху.");
    }

    @Override
    public void refuel() {
        System.out.println(getClass().getSimpleName() + " заправляется на аэродроме.");
    }

    @Override
    public void repair() {
        System.out.println(getClass().getSimpleName() + " обслуживается в ангаре.");
    }
}
