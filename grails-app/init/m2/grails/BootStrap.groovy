package m2.grails

import m2.grails.Users
import m2.grails.Role
import m2.grails.UsersRole

class BootStrap {

    def init = {
        servletContext ->
            if(Role.count == 0) {
                def roleAdmin = new Role(authority: 'ROLE_ADMIN').save(flush: true, failOnError: true)
                def roleUser = new Role(authority: 'ROLE_USER').save(flush: true, failOnError: true)

                def adminInstance = new Users(username: 'admin', password: 'password').save(flush: true, failOnError: true)
                def user1Instance = new Users(username: 'andy', password: 'password123!', accountLocked: false).save(flush: true, failOnError: true)
                def user2Instance = new Users(username: 'mario', password: 'password123!', accountLocked: false).save(flush: true, failOnError: true)

                UsersRole.create adminInstance, roleAdmin, true
                UsersRole.create user1Instance, roleAdmin, true
                UsersRole.create user2Instance, roleAdmin, true
            }
    }
    
    def destroy = {
    }
}
