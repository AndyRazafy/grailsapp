package m2.grails

import grails.plugin.springsecurity.SpringSecurityService


class ScoreInterceptor {

    SpringSecurityService springSecurityService

    boolean before() {
        if (springSecurityService.isLoggedIn()) {
            true
        }
        else {
            redirect action: 'auth', controller: 'login', params: params
        }
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
