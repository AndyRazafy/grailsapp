package m2.grails

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.plugin.springsecurity.SpringSecurityService

@Secured(['ROLE_ADMIN'])
class UsersController {

    UsersService usersService
    ResultatService resultatService
    ScoreService scoreService
    SpringSecurityService springSecurityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['permitAll'])
    def index() {
        render view: "/users/index"
    }

    @Secured(['permitAll'])
    def list() {
        Users user = springSecurityService.currentUser
        UsersRole userRole = UsersRole.findByUsers(user)

        if(userRole.getRole().getAuthority() == "ROLE_USER") {
            Role role = Role.findByAuthority("ROLE_USER")
            def users = UsersRole.findAllByRole(role).users
            users.remove(user)
            respond view: "/users/list", users, model: [currUser: springSecurityService.currentUser, usersCount: users.size()]
        }
        if(userRole.getRole().getAuthority() == "ROLE_ADMIN") {
            params.max = Math.min(max ?: 10, 100)
            respond usersService.list(params), model: [currUser: springSecurityService.currentUser, usersCount: usersService.count()]
        }
    }

    @Secured(['permitAll'])
    def show(Long id) {
        respond usersService.get(id)
    }

    def create() {
        respond new Users(params)
    }

    def save(Users users) {
        if (users == null) {
            notFound()
            return
        }

        try {
            usersService.save(users)
        } catch (ValidationException e) {
            respond users.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'users.label', default: 'Users'), users.id])
                redirect users
            }
            '*' { respond users, [status: CREATED] }
        }
    }

    @Secured(['permitAll'])
    def edit(Long id) {
        respond usersService.get(id)
    }

    @Secured(['permitAll'])
    def update(Users users) {
        if (users == null) {
            notFound()
            return
        }

        try {
            usersService.save(users)
        } catch (ValidationException e) {
            respond users.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'users.label', default: 'Users'), users.id])
                redirect users
            }
            '*'{ respond users, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        usersService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'users.label', default: 'Users'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'users.label', default: 'Users'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    @Secured(['ROLE_USER'])
    def jouer() {
        Users user1 = Users.get(params.user1)
        Users user2 = Users.get(params.user2)

        if((user1 != null && user2 != null) && (user1 != user2)) {
            Resultat resultat = new Resultat(date: new Date())
            Score score1 = new Score(users: user1, score: (Math.random() * 5), resultat: resultat)
            Score score2 = new Score(users: user2, score: (Math.random() * 5), resultat: resultat)

            resultatService.save(resultat)
            scoreService.save(score1)
            scoreService.save(score2)

            if(score1.score > score2.score) {
                flash.message = "Vous avez gagne la partie. " + user1.username + ": " + score1.score + ", " + user2.username + ": " + score2.score + "."
            }
            if(score1.score == score2.score) {
                flash.message = "Vous etes a egalite. Votre score est de: " + score1.score + "."
            }
            else {
                flash.message = "Vous avez perdu la partie. " + user1.username + ": " + score1.score + ", " + user2.username + ": " + score2.score + "."
            }
        }
        else {
            flash.error = "Impossible de jouer avec " + user2.username
        }

        redirect action: 'list', controller: 'users', params: params
    }

//    def resultats() {
//        Users user = springSecurityService.currentUser
//        Score scores = Score.findByUsers(user)
//
//        respond view: "/users/list", users, model: [currUser: springSecurityService.currentUser, usersCount: usersService.count()]
//    }`
}
