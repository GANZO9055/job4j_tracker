package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item dateAndTime = new Item();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String dateAndTimeFormat = dateAndTime.getCreated().format(formatter);
        System.out.println(dateAndTimeFormat);
        System.out.println(dateAndTime);
    }
}
