package com.readerscorner.model;


public class Book {

    private Integer bookId;
    private String title;
    private String author;

    public Book(final Integer bookId,
                final String title,
                final String author) {
        super();
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(final Integer bookId) {
        this.bookId = bookId;
    }

    public final String getTitle() {
        return title;
    }

    public final void setTitle(final String title) {
        this.title = title;
    }

    public final String getAuthor() {
        return author;
    }

    public final void setAuthor(final String author) {
        this.author = author;
    }

    @Override
    public String toString() {
	return "Book [bookId =" + bookId + ", title=" + title + ", author=" + author + "]";
    }
}
