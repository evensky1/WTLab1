package com.bsuir.poit.oopbasics.secondtask.comparators;

import com.bsuir.poit.oopbasics.secondtask.Book;
import java.util.Comparator;

public class BookAuthorThenTitleThenPriceComparator implements Comparator<Book> {

    private Comparator<Book> comparator;

    public BookAuthorThenTitleThenPriceComparator() {
        comparator = new BookAuthorComparator()
            .thenComparing(new BookTitleComparator())
            .thenComparing(new BookPriceComparator());
    }

    @Override
    public int compare(Book b1, Book b2) {
        return comparator.compare(b1, b2);
    }
}
