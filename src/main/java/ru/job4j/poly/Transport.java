package ru.job4j.poly;

public interface Transport {
    void drive();

    void passengers(int numberPassengers);

    int priceFuel(int numberFuel);
}
