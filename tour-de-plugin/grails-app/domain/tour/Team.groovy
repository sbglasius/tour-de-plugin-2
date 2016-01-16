package tour

class Team {
    String name
    String description
    Country country

    String toString() {
        name
    }

    static constraints = {
        description nullable: true
        country nullable: true
    }

    static hasMany = [riders: Rider]

    static mapping = {
        description type: 'text'
    }
}
