package m2.grails

import grails.gorm.DetachedCriteria
import groovy.transform.ToString

import org.codehaus.groovy.util.HashCodeHelper
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@ToString(cache=true, includeNames=true, includePackage=false)
class UsersRole implements Serializable {

    private static final long serialVersionUID = 1

    Users users
    Role role

    @Override
    boolean equals(other) {
            if (other instanceof UsersRole) {
                    other.usersId == users?.id && other.roleId == role?.id
            }
    }

    @Override
    int hashCode() {
        int hashCode = HashCodeHelper.initHash()
    if (users) {
        hashCode = HashCodeHelper.updateHash(hashCode, users.id)
            }
            if (role) {
                hashCode = HashCodeHelper.updateHash(hashCode, role.id)
            }
            hashCode
    }

    static UsersRole get(long usersId, long roleId) {
            criteriaFor(usersId, roleId).get()
    }

    static boolean exists(long usersId, long roleId) {
            criteriaFor(usersId, roleId).count()
    }

    private static DetachedCriteria criteriaFor(long usersId, long roleId) {
            UsersRole.where {
                    users == Users.load(usersId) &&
                    role == Role.load(roleId)
            }
    }

    static UsersRole create(Users users, Role role, boolean flush = false) {
            def instance = new UsersRole(users: users, role: role)
            instance.save(flush: flush)
            instance
    }

    static boolean remove(Users u, Role r) {
            if (u != null && r != null) {
                    UsersRole.where { users == u && role == r }.deleteAll()
            }
    }

    static int removeAll(Users u) {
            u == null ? 0 : UsersRole.where { users == u }.deleteAll() as int
    }

    static int removeAll(Role r) {
            r == null ? 0 : UsersRole.where { role == r }.deleteAll() as int
    }

    static constraints = {
        users nullable: false
            role nullable: false, validator: { Role r, UsersRole ur ->
                    if (ur.users?.id) {
                            if (UsersRole.exists(ur.users.id, r.id)) {
                                return ['userRole.exists']
                            }
                    }
            }
    }

    static mapping = {
            id composite: ['users', 'role']
            version false
    }
}
