grails.config.locations = [ "file:${userHome}/.grails/tour-de-plugin-config.groovy"]

environments {
    development {
        grails.mail.host = 'localhost'
        def port = com.icegreen.greenmail.util.ServerSetupTest.SMTP.port
        grails.mail.port = port
        grails.plugin.greenmail.ports.smtp = port
    }
    test {
        grails.mail.host = 'localhost'
        grails.mail.port = com.icegreen.greenmail.util.ServerSetupTest.SMTP.port
    }
    production {
        greenmail.disabled = true
        grails {
            mail {
                host = "smtp.gmail.com"
                port = 465
                username = "youracount@gmail.com"
                password = "yourpassword"
                props = ["mail.smtp.auth"                  : "true",
                         "mail.smtp.socketFactory.port"    : "465",
                         "mail.smtp.socketFactory.class"   : "javax.net.ssl.SSLSocketFactory",
                         "mail.smtp.socketFactory.fallback": "false"]
            }
        }
    }
}
