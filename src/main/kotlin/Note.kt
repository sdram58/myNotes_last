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

fun getNotes(onDone: (List<Note>)->Unit) {
    Thread.sleep(2000)
    val list = (1..10).map {
        Note(
            title = "Title $it",
            description = "Description $it",
            type = if (it % 3 == 0) Note.Type.AUDIO else Note.Type.TEXT
        )
    }
    onDone(list)
}

