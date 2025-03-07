import java.util.regex.Pattern

fun main(){
    val name = "Ximena M31 Gómez ! fgf"
    println(isValidName(name))
    println(isValidNameWithSpaces(name))

    println("DNI: "+isValidDni("70029654"))

    val matchAll = ".*\\p{Punct}+.*".toRegex().matches(name)
    val matchSubs = "\\p{Punct}+".toRegex().find(name) // kotlin
    val subsJava = Pattern.compile("\\p{Punct}+").matcher(name).find()

    println("----------------------")
    println("matches: $matchAll")
    println("matchSubs: ${matchSubs?.groupValues}")
    println("subsJava: $subsJava")
    println("----------------------")

    println("Password: " + isValidPassword("alexhalexh1A<ñAAsefsef"))
    println("Password punct: " + Pattern.compile("\\p{Punct}+").matcher("ñ").find())
    println("Freq: " + Pattern.compile("[0-9]{2,3}(\\.[0-9]+)?").matcher("90").matches() )

    println(startsWithIsoDate("2025-03-06T13:42:37.000-05:00,0.00,0.00,5.00,true,true"))

}

fun startsWithIsoDate(string: String): Boolean {
    return "^[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}:[0-9]{2}".toRegex().containsMatchIn(string)
}

fun isValidName(name: String): Boolean {
    return if (name.isNotEmpty() && name.length < 70) {
        // Pattern.compile("^[A-Z]+").matcher(name).matches()  // Wrong
        !Pattern.compile(".*\\p{Punct}+.*").matcher(name).matches()
    } else {
        println("false init")
        false
    }
}

fun isValidDni(dni: String): Boolean {
    return if (dni.isNotEmpty()) {
        Pattern.compile("[0-9]{8}").matcher(dni).matches()
    } else {
        false
    }
}

fun isValidNameWithSpaces(name: String): Boolean {
    return "^([A-Z][a-z0-9]*\\s?)+\$".toRegex().matches(name)
}

fun isValidPassword(password: String): Boolean {
    return if (password.isNotEmpty() && password.length >= 10) {
        Pattern.compile("\\d+").matcher(password).find() // Digit
                && Pattern.compile("[a-z]+").matcher(password).find() // Lower
                && Pattern.compile("[A-Z]+").matcher(password).find() // Upper
                && Pattern.compile("\\p{Punct}+").matcher(password).find() // Special
    } else {
        false
    }
}
