package ru.job4j.cast;

public class Transport {
    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle train = new Train();
        Vehicle bus = new Bus();

        Vehicle[] transports = new Vehicle[]{plane, train, bus};
        for (Vehicle transport : transports) {
            transport.move();
            transport.refuel();
            transport.repair();
        }
    }
}
