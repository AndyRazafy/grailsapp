package m2.grails

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class UsersInterceptorSpec extends Specification implements InterceptorUnitTest<UsersInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test users interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"users")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
