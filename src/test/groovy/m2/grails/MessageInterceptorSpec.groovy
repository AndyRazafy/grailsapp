package m2.grails

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class MessageInterceptorSpec extends Specification implements InterceptorUnitTest<MessageInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test message interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"message")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
