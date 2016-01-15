package tour

class SendEmailController {
    def mailService

    def index() {
        mailService.sendMail {
            to "soeren@glasius.dk"
            from "demouser@glasius.dk"
            subject "Hello Søren"
            text 'Hope GR8Conf India is GR8?'
        }
        render(text: "Mail is sent")
    }
}
