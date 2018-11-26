package m2.grails

import grails.gorm.services.Service

@Service(Resultat)
interface ResultatService {

    Resultat get(Serializable id)

    List<Resultat> list(Map args)

    Long count()

    void delete(Serializable id)

    Resultat save(Resultat resultat)

}