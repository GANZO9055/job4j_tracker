package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Ехать");
    }

    @Override
    public void passengers(int numberPassengers) {
        System.out.println("Количество пассажиров: " + numberPassengers);
    }

    @Override
    public int priceFuel(int numberFuel) {
        return numberFuel * 2;
    }
}
