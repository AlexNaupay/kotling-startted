import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun getLettersFlow(): Flow<String> {
    return flow {
        for (a in listOf("A","B", "C", "X")){
            delay(500)
            emit(a)
        }
    }
}


fun getNumbersFlow(): Flow<Int> = flow {
    for (i in 1..5) {
        delay(500)
        emit(i)
    }
}

fun main() = runBlocking {
    // Flujo que emite números del 1 al 5
    val numberFlow = flow {
        for (i in 1..5) {
            delay(500) // Simula una operación asíncrona
            emit(i)    // Emite el valor
        }
    }

    launch {
        getLettersFlow().collect{ println("Letter: $it") }
    }


    getNumbersFlow().collect { println(it) }
    numberFlow.collectLatest { println("Latest:$it") }
    // Recolectar el flujo
    numberFlow.collect { number ->
        println("Número recibido: $number")
    }

    println("Flujo completado")
}