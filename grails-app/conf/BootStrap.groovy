import grails.util.Environment
import org.grails.twitter.auth.Authority
import org.grails.twitter.auth.Person
import org.grails.twitter.auth.PersonAuthority


class BootStrap {

    def init = { servletContext ->
        /* If there are no Persons in the record. */
        if (!Person.count()) {
            createData()
        }
    }
    def destroy = {
    }

    private void createData() {
        def userRole = new Authority(authority: 'ROLE_ADMIN').save()

        /* The default password for all user. No need to encode here to avoid double encoding. */
        String password = 'password'

        [yancy: 'Yancy Vance Paredes', john: 'John Doe', jane: 'Jane Smith'].each { userName, realName ->
            def user = new Person(username: userName, realName: realName, password: password, enabled: true).save()
            PersonAuthority.create user, userRole, true
        }
    }
}
