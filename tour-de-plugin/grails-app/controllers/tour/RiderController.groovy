package tour

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER'])
class RiderController {
    static scaffold = Rider
}
