import kotlinx.coroutines.*
import java.time.Instant
import java.time.format.DateTimeFormatter
import kotlin.random.Random

fun main(){
    println("Hi")

    runBlocking {
        launch {
            val a = aRemoteValue()
            println("A: $a")
        }
        val b = aRemoteValue()
        println("B: $b")

        val deferred = async {
            delay(1000)
            "Async result"
        }

        println("\n\n Waiting for result...")
        println("Result: ${ deferred.await() }" ) // Espera y obtiene el resultado
        println("Result2: ${ aRemoteValueWithAwait().await() }" ) // Espera y obtiene el resultado
    }
}

suspend fun aRemoteValue():Int{
    val n1 = DateTimeFormatter.ISO_INSTANT.format(Instant.now())
    println("Request a remote value: $n1")
    delay(3500)
    val n2 = DateTimeFormatter.ISO_INSTANT.format(Instant.now())
    println("New value ____________: $n2")
    return Random.nextInt()
}

suspend fun aRemoteValueWithAwait():Deferred<Int>{
    return coroutineScope {
        async{
            val n1 = DateTimeFormatter.ISO_INSTANT.format(Instant.now())
            println("Request a remote value 2: $n1")
            delay(3500)
            val n2 = DateTimeFormatter.ISO_INSTANT.format(Instant.now())
            println("New value 2 ____________: $n2")
            Random.nextInt()
        }
    }
}