package m2.grails

class Message {

    Date date
    String contenu

    Users expediteur
    Users destinataire

    static constraints = {
        contenu nullable: false, blank: false
        expediteur nullable: false, blank: false
        destinataire nullable: false, blank: false
        expediteur nullable: false
        destinataire nullable: false
    }
}
