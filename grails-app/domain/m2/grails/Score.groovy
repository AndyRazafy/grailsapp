package m2.grails

class Score {

    Users users
    int score = Math.random() * 10
    static belongsTo = [resultat: Resultat]

    static constraints = {
        score nullable: false, blank: false
    }
}
