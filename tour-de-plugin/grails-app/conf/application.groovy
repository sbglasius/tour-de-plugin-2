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

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'tour.de.plugin.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'tour.de.plugin.UserRole'
grails.plugin.springsecurity.authority.className = 'tour.de.plugin.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']],
	[pattern: '/dbconsole/**',   access: ['ROLE_DB_CONSOLE']],
	[pattern: '/greenmail/**',   access: ['permitAll']],
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]
grails.plugin.springsecurity.roleHierarchy = '''
   ROLE_ADMIN > ROLE_USER
   ROLE_ADMIN > ROLE_DB_CONSOLE
'''
