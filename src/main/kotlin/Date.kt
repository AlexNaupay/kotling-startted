import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.*

fun main(){
    val dateTime = parseDateTime("2025-03-06T11:53:26.000-05:00")
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss", Locale.getDefault())

    println(dateTime?.format(formatter))
}

fun parseDateTime(dateTimeString: String): ZonedDateTime? {
    return try {
        val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME
        ZonedDateTime.parse(dateTimeString, formatter)
    } catch (e: Exception) {
        // Handle parsing errors (e.g., invalid format)
        e.printStackTrace()
        null
    }
}