package com.bsuir.poit.oopbasics.secondtask;

import java.math.BigInteger;
import java.util.Objects;

public class Book implements Comparable<Book> {

    private String title;
    private String author;
    private int price;
    private long isbn;
    private static int edition;

    public Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public Book() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        var temp = (Book) o;

        return Objects.equals(this.title, temp.title)
            && Objects.equals(this.author, temp.author)
            && price == temp.price;
    }

    @Override
    public int hashCode() {
        BigInteger temp = BigInteger.ZERO;
        return temp
            .add(BigInteger.valueOf(title.hashCode()))
            .add(BigInteger.valueOf(author.hashCode()))
            .modPow(BigInteger.valueOf(price != 0 ? price : 43),
                BigInteger.valueOf(Integer.MAX_VALUE))
            .intValue();
    }

    @Override
    public String toString() {
        return String.format(
            "Book [title = %s, author = %s, price = %d, edition = %d]",
            title, author, price, edition
        );
    }

    @Override
    public Object clone() {
        return new Book(title, author, price);
    }

    @Override
    public int compareTo(Book b) {
        return (int) (isbn - b.isbn);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public static int getEdition() {
        return edition;
    }

    public static void setEdition(int edition) {
        Book.edition = edition;
    }
}
