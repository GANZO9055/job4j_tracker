package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book bookOne = new Book("One", 16);
        Book bookTwo = new Book("Two", 20);
        Book bookThree = new Book("Clean code", 14);
        Book bookFour = new Book("Four", 8);
        Book[] books = new Book[4];
        books[0] = bookOne;
        books[1] = bookTwo;
        books[2] = bookThree;
        books[3] = bookFour;
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println("Book " + book.getName()
                    + ", quantity of pages " + book.getQuantity());
        }
        System.out.println();
        System.out.println("Replace book with index 0 and 3");
        Book replace;
        replace = books[0];
        books[0] = books[3];
        books[3] = replace;
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println("Book " + book.getName()
                    + ", quantity of pages " + book.getQuantity());
        }
        System.out.println();
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if ("Clean code".equals(book.getName())) {
                System.out.println("Clean code");
            }
        }
    }
}
