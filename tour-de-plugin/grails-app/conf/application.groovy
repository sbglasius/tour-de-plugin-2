grails.config.locations = [ "file:${userHome}/.grails/tour-de-plugin-config.groovy"]
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
