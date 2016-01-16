import groovy.json.JsonSlurper
import tour.Team
import tour.de.plugin.Role
import tour.de.plugin.User
import tour.de.plugin.UserRole

import javax.servlet.ServletContext

class BootStrap {

    def init = { ServletContext servletContext ->
        if (!Team.count()) {
            println servletContext.getResource('/tourData.json').file
            importTeamData(servletContext.getResourceAsStream('/tourData.json'))
        }

        if (!Role.count() && !User.count()) {
            def adminRole = new Role('ROLE_ADMIN').save()
            def userRole = new Role('ROLE_USER').save()

            def adminUser = new User('admin', 'password').save()
            def regularUser = new User('regular', 'password').save()

            UserRole.create adminUser, adminRole
            UserRole.create regularUser, userRole

            UserRole.withSession {
                it.flush()
                it.clear()
            }

            assert User.count() == 2
            assert Role.count() == 2
            assert UserRole.count() == 2

        }
    }

    void importTeamData(InputStream tourData) {
        def json = new JsonSlurper().parse(tourData)
        json.teams.each { Map team ->
            println "Creating team: $team.name with ${team.riders.size()} riders"
            def newTeam = new Team(name: team.name, description: team.description);
            team.riders.each { Map rider ->
                println "-- adding rider: $rider.name"
                newTeam.addToRiders(rider)
            }
            newTeam.save(failOnError: true)
        }

    }
    def destroy = {
    }
}
