package com.readerscorner.repository;

import com.readerscorner.model.Book;

public interface BookRepository {

    public Book getBook(final Integer bookId);

}

