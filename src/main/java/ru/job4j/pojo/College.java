package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Konstantin Petrosovich Andreevich");
        student.setGroup("YA12");
        student.setDateOfReceipt(new Date());

        System.out.println("Student " + student.getName() + " is in the group "
                + student.getGroup() + " with " + student.getDateOfReceipt());
    }
}
