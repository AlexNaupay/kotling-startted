import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking


fun main(args: Array<String>){
    runBlocking {
        getUserOrdersFlow().collect{ println(it) }
    }

}
@OptIn(ExperimentalCoroutinesApi::class)
fun getUserOrdersFlow(): Flow<List<String>> {
    return getUserIdFlow()
        .flatMapLatest{ userId ->
            println(userId)
            flow {
                val orders = getOrdersForUser(userId) // Obtiene los pedidos del usuario
                emit(orders) // Emite la lista de pedidos
            }
        }
}

fun getUserIdFlow(): Flow<Int> = flow {
    val userIds = listOf(1, 2, 3) // IDs de usuario
    userIds.forEach { id ->
        delay(2000) // Espera 1 segundo antes de emitir el siguiente ID
        emit(id)    // Emite el ID
    }
}

suspend fun getOrdersForUser(userId: Int): List<String> {
    delay(500) // Simula una operación asíncrona (por ejemplo, una llamada a una API)
    return when (userId) {
        1 -> listOf("Order 1A", "Order 1B")
        2 -> listOf("Order 2A", "Order 2B", "Order 2C")
        3 -> listOf("Order 3A")
        else -> emptyList()
    }
}