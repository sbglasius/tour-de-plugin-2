package tour.de.plugin

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration

class Application extends GrailsAutoConfiguration implements ExternalConfig {
    static void main(String[] args) {
        GrailsApp.run(Application, args)
    }
}