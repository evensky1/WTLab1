package com.bsuir.poit.oopbasics.secondtask.comparators;

import com.bsuir.poit.oopbasics.secondtask.Book;
import java.util.Comparator;

public class BookPriceComparator implements Comparator<Book> {

    @Override
    public int compare(Book b1, Book b2) {
        return b1.getPrice() - b2.getPrice();
    }
}
