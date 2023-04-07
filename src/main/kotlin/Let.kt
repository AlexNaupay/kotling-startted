fun main(args: Array<String>) {
    var nombre: String? = null
    nombre?.let { valor ->
        println("El nombre no es nulo, es $valor")
    }
    nombre = "Giuseppe"
    val result = nombre.let(lambdas)
    println(result)

    pairs()
    with()
    run()
    apply()
    also()
}


val lambdas:(String)->String = {"El nombre no es nulo, ES $it"}

fun with(){
    val colores = listOf("Azul","Amarillo","Rojo")
    with(colores) {
        println("Nuestros colores son $this")
        println("Esta lista tiene una cantidad de colores de ${this.size} . $size")
    }
}

fun run(){
    val moviles = mutableListOf("Google Pixel 2XL", "Google Pixel 4a", "Huawei Redmi 9", "Xiaomi mi a3")
        .run {
            removeIf { movil -> movil.contains("Google") }
            this
        }
    println(moviles)
}

fun also(){
    val moviles = mutableListOf("Google Pixel 2XL", "Google Pixel 4a", "Huawei Redmi 9", "Xiaomi mi a3").also {
            lista -> println("El valor original de la lista es $lista")
    }.asReversed()
    println(moviles)
}

fun apply(){
    val moviles = mutableListOf("Google Pixel 2XL", "Google Pixel 4a", "Huawei Redmi 9", "Xiaomi mi a3").apply {
        removeIf { movil -> movil.contains("Google") }
    }
    println(moviles)

    val colores : MutableList<String>? = mutableListOf("Amarillo","Azul","Rojo")
    colores?.apply {
        println("Nuestros colores son $this")
        println("la cantidad de colores es $size")
    }
}

fun pairs(){
    var numero : Int? = null
    val mensajePar : (Int) -> String = { "$it es par" }

    for (i in (0..20)) {
        if (i % 2 == 0)
            numero = i
        else
            numero = null

        numero?.let {
            println(mensajePar(i))
        }
    }
}