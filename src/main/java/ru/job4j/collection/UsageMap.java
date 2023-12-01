package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> mail = new HashMap<>();
        mail.put("konstantin@gmail.com", "Maslihov Konstantin Andreevich");
        mail.put("dima1996@mail.ru", "Maslov Dmitriy Andreevich");
        mail.put("dima1996@mail.ru", "Maslov Dima Andrey");

        for (String key : mail.keySet()) {
            String value = mail.get(key);
            System.out.println(key + " : " + value);
        }
    }
}
