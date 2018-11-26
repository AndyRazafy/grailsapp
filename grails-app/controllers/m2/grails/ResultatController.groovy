package m2.grails

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

@Secured(['USER_ADMIN'])
class ResultatController {

    ResultatService resultatService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond resultatService.list(params), model:[resultatCount: resultatService.count()]
    }

    @Secured(['permitAll'])
    def show(Long id) {
        respond resultatService.get(id)
    }

    def create() {
        respond new Resultat(params)
    }

    def save(Resultat resultat) {
        if (resultat == null) {
            notFound()
            return
        }

        try {
            resultatService.save(resultat)
        } catch (ValidationException e) {
            respond resultat.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'resultat.label', default: 'Resultat'), resultat.id])
                redirect resultat
            }
            '*' { respond resultat, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond resultatService.get(id)
    }

    def update(Resultat resultat) {
        if (resultat == null) {
            notFound()
            return
        }

        try {
            resultatService.save(resultat)
        } catch (ValidationException e) {
            respond resultat.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'resultat.label', default: 'Resultat'), resultat.id])
                redirect resultat
            }
            '*'{ respond resultat, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        resultatService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'resultat.label', default: 'Resultat'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'resultat.label', default: 'Resultat'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
