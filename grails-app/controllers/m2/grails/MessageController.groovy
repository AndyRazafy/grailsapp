package m2.grails

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

@Secured(['ROLE_ADMIN'])
class MessageController {

    MessageService messageService
    SpringSecurityService springSecurityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['permitAll'])
    def index(Integer max) {
        Users user = springSecurityService.currentUser
        Role role = Role.findByAuthority("ROLE_USER")
        def users = UsersRole.findAllByRole(role).users
        users.remove(user)

        params.max = Math.min(max ?: 10, 100)
        respond messageService.list(params), usersList: users, model:[messageCount: messageService.count()]
    }

    def show(Long id) {
        respond messageService.get(id)
    }

    def create() {
        respond new Message(params)
    }

    def save(Message message) {
        if (message == null) {
            notFound()
            return
        }

        try {
            messageService.save(message)
        } catch (ValidationException e) {
            respond message.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'message.label', default: 'Message'), message.id])
                redirect message
            }
            '*' { respond message, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond messageService.get(id)
    }

    def update(Message message) {
        if (message == null) {
            notFound()
            return
        }

        try {
            messageService.save(message)
        } catch (ValidationException e) {
            respond message.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'message.label', default: 'Message'), message.id])
                redirect message
            }
            '*'{ respond message, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        messageService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'message.label', default: 'Message'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'message.label', default: 'Message'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
