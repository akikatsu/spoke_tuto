package com.readerscorner.test

import com.readerscorner.model.Book

import spock.lang.Specification
import groovy.util.logging.Slf4j

@Slf4j
class BookSpec extends Specification {

    def initBookId = 1
    def initTitle = "spock tut"
    def initAuthor = "aaa"
    Book book

    def setup() {
        book = new Book(initBookId, initTitle, initAuthor)
    }
    
    def "book constractor"() {
        expect:
            assertObject(book, [ initBookId, initTitle, initAuthor])
    }

    def "book getBookId"() {
        expect:
            book.getBookId() == initBookId
    }

    def "book setBookId"() {
        when:
            book.setBookId(2) 
            
        then:
            assertObject(book, [ 2, initTitle, initAuthor])
    }

    def "book getTitle"() {
        expect:
            book.getTitle() == initTitle
    }

    def "book setTitle"() {
        when:
            book.setTitle("from setter") 
            
        then:
            assertObject(book, [ initBookId, "from setter", initAuthor])
    }

    def "book getAuthor"() {
        expect:
            book.getAuthor() == initAuthor
    }

    def "book setAuthor"() {
        when:
            book.setAuthor("from setter") 
            
        then:
            assertObject(book, [ initBookId, initTitle, "from setter"])
    }

    void assertObject(book, list) {
	assert book.@bookId == list[0]
	assert book.@title == list[1]
        assert book.@author == list[2]
    }
}
