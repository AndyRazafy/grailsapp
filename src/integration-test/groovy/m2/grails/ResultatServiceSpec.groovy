package m2.grails

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ResultatServiceSpec extends Specification {

    ResultatService resultatService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Resultat(...).save(flush: true, failOnError: true)
        //new Resultat(...).save(flush: true, failOnError: true)
        //Resultat resultat = new Resultat(...).save(flush: true, failOnError: true)
        //new Resultat(...).save(flush: true, failOnError: true)
        //new Resultat(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //resultat.id
    }

    void "test get"() {
        setupData()

        expect:
        resultatService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Resultat> resultatList = resultatService.list(max: 2, offset: 2)

        then:
        resultatList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        resultatService.count() == 5
    }

    void "test delete"() {
        Long resultatId = setupData()

        expect:
        resultatService.count() == 5

        when:
        resultatService.delete(resultatId)
        sessionFactory.currentSession.flush()

        then:
        resultatService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Resultat resultat = new Resultat()
        resultatService.save(resultat)

        then:
        resultat.id != null
    }
}
