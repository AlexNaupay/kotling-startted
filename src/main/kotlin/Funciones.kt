
fun main(args: Array<String>) {
    val phrase = "En Platzi nunca paramos de aprender"
    val letraAleatoria = phrase.randomCase()
    println(letraAleatoria)
    println(randomCase2(phrase))
    println(fullName(firstname = "Alex", lastname = "Naupay"))
}

// Extensión
private fun String.randomCase(): String {
    val numeroAleatorio = 0..99
    val resultadoAleatorio = numeroAleatorio.random()
    return if (resultadoAleatorio.rem(2) == 0) this.uppercase() else this.lowercase()
}

fun randomCase2(phrase: String): String{
    val resultadoAleatorio = (0..99).random()
    return if (resultadoAleatorio.rem(2) == 0) phrase.uppercase() else phrase.lowercase()
}

fun fullName(firstname:String, lastname:String = ""):String{
    return "$firstname $lastname".trim()
}