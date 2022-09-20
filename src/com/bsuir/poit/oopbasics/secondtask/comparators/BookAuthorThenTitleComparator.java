package com.bsuir.poit.oopbasics.secondtask.comparators;

import com.bsuir.poit.oopbasics.secondtask.Book;
import java.util.Comparator;

public class BookAuthorThenTitleComparator implements Comparator<Book> {

    private Comparator<Book> comparator;

    public BookAuthorThenTitleComparator() {
        comparator = new BookAuthorComparator().thenComparing(new BookTitleComparator());
    }

    @Override
    public int compare(Book b1, Book b2) {
        return comparator.compare(b1, b2);
    }
}
