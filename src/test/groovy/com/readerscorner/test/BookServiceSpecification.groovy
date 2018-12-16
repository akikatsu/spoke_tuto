package com.readerscorner.test

import com.readerscorner.impl.BookServiceImpl
import com.readerscorner.model.Book
import com.readerscorner.service.BookService
import com.readerscorner.repository.BookRepository

import spock.lang.Specification
import groovy.util.logging.Slf4j

@Slf4j
class BookServiceSpecification extends Specification {

    BookService bookService
    BookRepository bookRepository

    def setupSpec() {
        log.debug("setupSpec() - Runs once per Specification")
    }

    def setup() {
        log.debug("setup() - Run before every feature method")
        bookService = new BookServiceImpl()
        bookRepository = Stub(BookRepository)
        bookService.setBookRepository(bookRepository)
        
        bookRepository.getBook(_) >> { int id ->
            if (id == 1) {
                def b = new Book(1, 'Srujana', 'Spock Tut')
                log.debug(b.toString())
                return b
            } else if (id == 2) {
                def b = new Book(2, 'Eugen', 'JUnit Tut')
                log.debug(b.toString())
                return b
            } else if (id == 3) {
                log.debug("Book with this ID does not exists");
                return null
            } else if (id <= 0) {
		throw new IllegalArgumentException("Invalid Book ID")
	    }
        }
    }

    def "retrieved book object is not null"() {
        log.debug("Feature method 1 - retrieved book object is not null start")
        expect:
            bookService.retrieveBookDetails(id) != null

        where:
            id << [1, 2]
    }

    def "retrieved book object is null"() {
        log.debug("Feature method - 2 retrieved book object is null - start")
        expect:
            bookService.retrieveBookDetails(id) == null

        where:
            id << 3
    }

    def "book id must be greater then 0"() {
	log.debug("Feature method 3 - book id must be greater then 0 - start")
	given:
	    // NA
        when:
	    bookService.retrieveBookDetails(-3)
	then:
	    thrown(IllegalArgumentException)
    }

    def cleanup() {
        log.debug("Cleanup method - Runs after every feature method.")
    }

    def cleanupSpec() {
        log.debug("cleanupSpec() - Runs only once per specification")
    }
}
