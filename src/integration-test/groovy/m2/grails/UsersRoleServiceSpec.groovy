package m2.grails

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class UsersRoleServiceSpec extends Specification {

    UsersRoleService usersRoleService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new UsersRole(...).save(flush: true, failOnError: true)
        //new UsersRole(...).save(flush: true, failOnError: true)
        //UsersRole usersRole = new UsersRole(...).save(flush: true, failOnError: true)
        //new UsersRole(...).save(flush: true, failOnError: true)
        //new UsersRole(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //usersRole.id
    }

    void "test get"() {
        setupData()

        expect:
        usersRoleService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<UsersRole> usersRoleList = usersRoleService.list(max: 2, offset: 2)

        then:
        usersRoleList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        usersRoleService.count() == 5
    }

    void "test delete"() {
        Long usersRoleId = setupData()

        expect:
        usersRoleService.count() == 5

        when:
        usersRoleService.delete(usersRoleId)
        sessionFactory.currentSession.flush()

        then:
        usersRoleService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        UsersRole usersRole = new UsersRole()
        usersRoleService.save(usersRole)

        then:
        usersRole.id != null
    }
}
