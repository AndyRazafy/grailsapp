package m2.grails

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class ScoreInterceptorSpec extends Specification implements InterceptorUnitTest<ScoreInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test score interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"score")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
