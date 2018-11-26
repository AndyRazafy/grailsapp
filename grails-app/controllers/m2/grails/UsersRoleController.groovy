package m2.grails

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class UsersRoleController {

    UsersRoleService usersRoleService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond usersRoleService.list(params), model:[usersRoleCount: usersRoleService.count()]
    }

    def show(Long id) {
        respond usersRoleService.get(id)
    }

    def create() {
        respond new UsersRole(params)
    }

    def save(UsersRole usersRole) {
        if (usersRole == null) {
            notFound()
            return
        }

        try {
            usersRoleService.save(usersRole)
        } catch (ValidationException e) {
            respond usersRole.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'usersRole.label', default: 'UsersRole'), usersRole.id])
                redirect usersRole
            }
            '*' { respond usersRole, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond usersRoleService.get(id)
    }

    def update(UsersRole usersRole) {
        if (usersRole == null) {
            notFound()
            return
        }

        try {
            usersRoleService.save(usersRole)
        } catch (ValidationException e) {
            respond usersRole.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'usersRole.label', default: 'UsersRole'), usersRole.id])
                redirect usersRole
            }
            '*'{ respond usersRole, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        usersRoleService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'usersRole.label', default: 'UsersRole'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'usersRole.label', default: 'UsersRole'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
