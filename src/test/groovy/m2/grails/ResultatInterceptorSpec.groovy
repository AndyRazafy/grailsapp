package m2.grails

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class ResultatInterceptorSpec extends Specification implements InterceptorUnitTest<ResultatInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test resultat interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"resultat")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
