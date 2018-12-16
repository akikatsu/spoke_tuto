package com.mock

import spock.lang.Specification
import groovy.util.logging.Slf4j

@Slf4j
class StaticSampleSpec extends Specification {

    def "StaticSample geMessage"() {
     when:
         def message = StaticSample.getMessage()
     then:
         message == "execute StaticSample.getMessage"
            
    }
    
    def "StaticSample geMessage mock"() {
        given:
            GroovySpy(StaticSample, global: true)
            StaticSample.getMessage() >> "static method mocked"
        
        when:
            def message = StaticSample.getMessage()
        then:
            message == "static method mocked"
    }
}
