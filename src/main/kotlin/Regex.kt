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
