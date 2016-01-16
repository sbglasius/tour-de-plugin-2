package tour.de.plugin

class UpdateJob {
    static triggers = {
      simple repeatInterval: 5000l // execute job once in 5 seconds
    }

    def execute() {
        println "Executing ${new Date()}"
    }
}
