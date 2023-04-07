const val PI = 3.1416


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

}