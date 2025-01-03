const val PI = 3.1416

// https://github.com/Gvetri/curso-kotlin-desde-cero.git

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    var name: String = "Alex"
    val integerLong: Long = 1256

    println("PI:$PI")
    println("Name: $name")
    println("Long: $integerLong")

    val message = if (name.length > 3) "large" else "short"

    val set = setOf("a","b","c")

    println(set)

    fun miFuncion(nombre: String, apellido: String) = nombre + apellido

    println( miFuncion("Alex", "Naupay"))

    val FIRMWARE_VERSION_PATTERN = Regex("""[0-9]{1,2}\.[0-9]{1,3}""").toPattern()

    val receivedData = "1.45"
    if (FIRMWARE_VERSION_PATTERN.matcher(receivedData).matches()){
        println(receivedData)
    }


}