import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlin.concurrent.thread

object AppState{
    var state:UiState by mutableStateOf(UiState())

    fun loadNotes() {
        thread {
            state = UiState(loading = true)
            getNotes { notes ->
                state =  UiState(notes = notes, loading = false)
            }
        }
    }

    data class UiState(
        val notes: List<Note>? = null,
        val loading: Boolean = false
    )

}