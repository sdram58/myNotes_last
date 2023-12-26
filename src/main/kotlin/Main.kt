import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application


class AppState{
    val text =  mutableStateOf("")
    val buttonEnabled:Boolean
        get() = text.value.isNotEmpty()

}

@Composable
@Preview
fun App(appState: AppState) {



    MaterialTheme {
        Column {
            TextField(
                value = appState.text.value,
                onValueChange = { newTex -> appState.text.value = newTex }
            )
            Text(buildMessage(appState.text.value))
            Button(
                enabled = appState.buttonEnabled,
                onClick = {
                appState.text.value = ""
            }) {
                Text("Clean")
            }
        }

    }
}

fun buildMessage(text: String): String = if (text.isNotEmpty()) "Hello $text" else ""

fun main() {
    val appState = AppState()

    application {
        Window(onCloseRequest = ::exitApplication, title = "Application") {
            App(appState)
        }
    }
}
