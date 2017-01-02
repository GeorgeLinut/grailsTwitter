package org.grails.twitter

import org.grails.twitter.auth.Person

class StatusController {

    def springSecurityService

    def index() {
        def messages = currentUserTimeLine()
        return [messages: messages]
    }

    def follow(){
        def per = Person.get(params.id)
        if (per){
            def currentUser=lookupPerson()
            currentUser.addToFollowed(per)
            currentUser.save()
        }
        redirect action: 'index'
    }

    def updateStatus = {
        def status = new Status(message: params.message)
        status.author = lookupPerson()
        status.save()
        def messages = currentUserTimeLine()
        render template: 'messages', collection: messages, var: 'message'
    }

    private currentUserTimeLine() {
        def per = lookupPerson();
        def messages = Status.withCriteria {
            or {
                author {
                    eq 'username', per.username
                }
                if (per.followed){
                    inList 'author',per.followed
                }
            }
            maxResults 10
            order 'dateCreated', 'desc'
        }
        messages
    }

    private lookupPerson() {
        Person.get(springSecurityService.principal.id)
    }
}
