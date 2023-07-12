import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme {
        Box(Modifier.fillMaxSize().background(Color.Blue)) {
            Column {
                Row(Modifier.fillMaxWidth().height(190.dp).background(Color.Red), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                   repeat(10) {
                        Box(Modifier.size(80.dp).padding(10.dp).background(Color.Black).clip(shape = RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp)).clickable {  })
                    }

                    Box(
                        modifier = Modifier
                            .size(size = 100.dp)
                            .clip(shape = RoundedCornerShape(size = 12.dp))
                            .background(color = Color.Green)
                    ) {
                    }

                }
                Row(Modifier.fillMaxWidth().height(90.dp).background(Color.Yellow)) {  }
                Row(Modifier.fillMaxWidth().height(90.dp).background(Color.Black)) {  }
                Row(Modifier.fillMaxWidth().height(90.dp).background(Color.Gray)) {  }
            }
        }
    }
}

    fun main() = application {
        Window(onCloseRequest = ::exitApplication) {

        }
    }

