package com.sample

import spock.lang.Specification
import groovy.util.logging.Slf4j

@Slf4j
class PublisherSpec extends Specification {

    Publisher publisher = null
    Subscriber subscriber  = Mock()
    Subscriber subscriber2 = Mock()

    def setup() {
        publisher = new Publisher()
        publisher.subscribers << subscriber
        publisher.subscribers << subscriber2
    }

    def "should send messages to all subscribers"() {
        when:
            publisher.send("hello")

        then:
            1 * subscriber.receive("hello")
            1 * subscriber2.receive("hello")
	    publisher.messageCount == 1
    }
}
