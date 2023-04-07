
fun main(args: Array<String>) {

    // Como crear una lambda
    val myLambda : (String) -> Int = {
        it.length
    }

    val myLambda2 : (String) -> Int = { texto ->
        texto.length * 2
    }

    // Como invocar una lambda
    val resultadoDeLambda = myLambda("Hola Platzi")
    println(resultadoDeLambda)

    // Como usar una lambda como parámetro
    val listaDeString = listOf("A","B","C")

    val resultadoLambdaSinVariable = listaDeString.map { texto ->
        texto.length * 2
    }
    println(resultadoLambdaSinVariable)

    val resultadoLambda= listaDeString.map(myLambda2)
    println(resultadoLambda)

    val lambdaAlex: (String) -> String = { "$it lambda" }
    val lambdaAlex2: (String, String) -> String = { one: String, two: String -> "$one $two lambda" }

    println(lambdaAlex("Alex"))
    println(lambdaAlex2("Alex", "Naupay"))

}
