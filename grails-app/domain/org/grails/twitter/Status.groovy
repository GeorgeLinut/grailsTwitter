package org.grails.twitter

import org.grails.twitter.auth.Person

class Status {

    String message
    Person author
    Date dateCreated
    static belongsTo = Person

    static constraints = {
        message size: 2..20,blank: false
    }
}
