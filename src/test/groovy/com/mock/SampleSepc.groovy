package com.mock

import spock.lang.Specification
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import org.powermock.modules.junit4.PowerMockRunnerDelegate
import org.spockframework.runtime.Sputnik
import groovy.util.logging.Slf4j

//import spock.util.mop.ConfineMetaClassChanges
//import org.junit.Rule
//import org.mockito.Mockito
//import org.powermock.api.mockito.PowerMockito
//import org.powermock.core.classloader.annotations.PrepareForTest
//import org.powermock.modules.junit4.rule.PowerMockRule

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(Sputnik.class)
@PrepareForTest([StaticSample.class])
@Slf4j
class SampleSpec extends Specification {


    def sample = null

    def setup() {
    }

    def "sample geMessage"() {
	given:
	    PowerMockito.mockStatic(StaticSample.class)
	    Mockito.when(StaticSample.getMessage()).thenReturn("static method mocked")
	    sample = new Sample()
	
	when:
	    //def message = StaticSample.getMessage()
	    def message = sample.getMessage()
	
	then:
	    message == "static method mocked"
    }
}
