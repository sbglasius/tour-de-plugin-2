package tour

class Rider {
    String name
    URL image
    Integer weight
//    @BindingFormat('yyyy-MM-dd')
    Date born

    String toString() {
        name
    }

    static constraints = {
        weight nullable: true
    }

    static belongsTo = [team: Team]
}
