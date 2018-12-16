package com.readerscorner.service;

import com.readerscorner.model.Book;

public interface BookService {

    public Book retrieveBookDetails(final Integer bookId);

}
