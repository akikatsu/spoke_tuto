package com.readerscorner.impl;

import com.readerscorner.model.Book;
import com.readerscorner.repository.BookRepository;
import com.readerscorner.service.BookService;


public class BookServiceImpl implements BookService {

    BookRepository bookRepository;

    public void setBookRepository(final BookRepository bRepository) {
	this.bookRepository = bRepository;
    }

    @Override
    public Book retrieveBookDetails(final Integer id) {
	return bookRepository.getBook(id);
    }
}
