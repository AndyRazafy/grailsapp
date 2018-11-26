package m2.grails

import grails.gorm.services.Service

@Service(UsersRole)
interface UsersRoleService {

    UsersRole get(Serializable id)

    List<UsersRole> list(Map args)

    Long count()

    void delete(Serializable id)

    UsersRole save(UsersRole usersRole)

}