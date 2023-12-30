import kotlinx.coroutines.Delay
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

data class Note(
    val title: String,
    val description: String,
    val type: Type
){
    enum class Type{
        TEXT,
        AUDIO
    }
}

suspend fun getNotes(): List<Note> = withContext(Dispatchers.IO) {
    delay(2000)
    (1..10).map {
        Note(
            title = "Title $it",
            description = "Description $it",
            type = if (it % 3 == 0) Note.Type.AUDIO else Note.Type.TEXT
        )
    }

}

