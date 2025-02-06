import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    // Flujo que emite IDs de usuario
    val userIdFlow = flow {
        val userIds = listOf(1, 2, 3)
        userIds.forEach { id ->
            delay(1000) // Espera 1 segundo antes de emitir el siguiente ID
            emit(id)    // Emite el ID
        }
    }

    // Función que simula la obtención de pedidos de un usuario
    suspend fun getOrdersForUser(userId: Int): List<String> {
        delay(500) // Simula una operación asíncrona
        return when (userId) {
            1 -> listOf("Order 1A", "Order 1B")
            2 -> listOf("Order 2A", "Order 2B", "Order 2C")
            3 -> listOf("Order 3A")
            else -> emptyList()
        }
    }

    // Combinar los flujos con flatMapLatest
    val ordersFlow = userIdFlow.flatMapLatest { userId ->
        flow {
            val orders = getOrdersForUser(userId)
            emit(orders)
        }
    }

    // Recolectar el flujo de pedidos
    ordersFlow.collect { orders ->
        println("Pedidos recibidos: $orders")
    }

    println("Flujo completado")
}