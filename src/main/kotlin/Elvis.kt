class Person(name: String){

}

fun main(args: Array<String>) {

    var nombre : String? = null
    val caracteresDeNombre = nombre?.length ?: 0

    println(caracteresDeNombre)

    val person = Person("Alex")

    println( person ?: "Juan" )

}