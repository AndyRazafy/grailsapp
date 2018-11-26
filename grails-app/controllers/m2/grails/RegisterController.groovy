package m2.grails

import grails.plugin.springsecurity.annotation.Secured
import grails.plugin.springsecurity.ui.RegisterCommand

@Secured(['permitAll'])
class RegisterController extends grails.plugin.springsecurity.ui.RegisterController {
    def register(RegisterCommand registerCommand) {

        if (!request.post) {
            return [registerCommand: new RegisterCommand()]
        }

        if (registerCommand.hasErrors()) {
            return [registerCommand: registerCommand]
        }

        Users users = new Users(username: registerCommand.username, password: registerCommand.password, accountLocked: false).save()
        Role role = Role.findById((Long) 2)
        UsersRole.create users, role, true

        redirect view: "/index"
    }
}
