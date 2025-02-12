import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

fun main(args: Array<String>) {
    println(ScreenDest.serializer())

    val json = Json.encodeToString(Data(42, "str"))
    println(json)

    val dataList = listOf(Data(42, "str"), Data(12, "test"))
    val jsonList = Json.encodeToString(dataList)
    println(jsonList)

    // abc("asdad")  // Error parameter type

    xyz(Dest.Home)

}

fun abc(ab: ScreenDest){

}

fun xyz(ab: Dest){

}

@Serializable
object ScreenDest

@Serializable
object HomeDest

sealed interface Dest {
    @Serializable
    data object Home : Dest

    @Serializable
    data object Splash : Dest
}

@Serializable
data class Data(val a: Int, val b: String)