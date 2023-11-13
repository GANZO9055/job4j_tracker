package ru.job4j.cast;

public class Bus implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " двигается по скоростным трассам.");
    }

    @Override
    public void refuel() {
        System.out.println(getClass().getSimpleName() + " заправляется в автопарке.");
    }

    @Override
    public void repair() {
        System.out.println(getClass().getSimpleName() + " ремонтируется в автомастерской.");
    }
}
