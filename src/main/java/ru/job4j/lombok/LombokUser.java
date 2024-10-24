package ru.job4j.lombok;

public class LombokUser {
    public static void main(String[] args) {
        var permission = Permission.userRule()
                .id(1)
                .name("User")
                .addRule("All")
                .addRule("Half")
                .addRule("No")
                .build();
        System.out.println(permission);
    }
}
