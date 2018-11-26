package m2.grails

class Resultat {

    Date date = new Date()

    static hasMany = [score: Score]

    static constraints = {
        date nullable: false, blank: false
    }
}
