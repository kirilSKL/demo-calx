import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

var result = mutableStateOf<Int>(0)
var operatiom = mutableStateOf<Int>(0)  // 0 +  1 - 2 * 3 /

@OptIn(ExperimentalUnitApi::class)
@Composable
fun Calc() {
    var resultImpl = remember { result }
    MaterialTheme {
        Column {
            Row (modifier = Modifier.padding(horizontal = 20.dp)){
                Text("${resultImpl.value}", fontSize = TextUnit(50f, TextUnitType.Sp), modifier =  Modifier.fillMaxWidth())
                Text("${resultImpl.value}")
            }
            Row {
                ButtonKyrill("+")
                ButtonKyrill("-")
                ButtonKyrill("*")
                ButtonKyrill("/")
            }
            Row {
                ButtonKyrill("1")
                ButtonKyrill("2")
                ButtonKyrill("3")
                ButtonKyrill("4")
            }
            Row {
                ButtonKyrill("5")
                ButtonKyrill("6")
                ButtonKyrill("7")
                ButtonKyrill("8")
            }
            Row {
                ButtonKyrill("9")
                ButtonKyrill("0")
                ButtonKyrill("del")
                ButtonKyrill("=")
            }
        }



    }
}
var isADone = false
@OptIn(ExperimentalUnitApi::class)
@Composable
fun ButtonKyrill(num: String) {
    Box(
        modifier = Modifier
            .size(150.dp)
            .padding(20.dp)
            .clip(shape = RoundedCornerShape(20.dp, 20.dp, 20.dp, 20.dp))
            .background(Color.Gray)
            .clickable {
                when(num) {
                    "+" -> {
                        isADone = true
                        operatiom.value = 0
                    }

                    "-" -> {
                        isADone = true
                        operatiom.value = 1
                    }

                    "*" -> {
                        isADone = true
                        operatiom.value = 2
                    }

                    "/" -> {
                        isADone = true
                        operatiom.value = 3
                    }

                    "=" -> {
                        isADone = false
                        when (operatiom.value) {
                            0 -> {
                                result.value = a.toInt() + b.toInt()
                            }

                            1 -> {
                                result.value = a.toInt() - b.toInt()
                            }

                            2 -> {
                                result.value = a.toInt() * b.toInt()
                            }

                            3 -> {
                                result.value = a.toInt() / b.toInt()
                            }
                        }
                    }

                    "del" -> {
                        a = "0"
                        b = "0"
                        result.value = 0
                }


                     "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" -> {
                        if (!isADone) {
                            a = a+num
                        }else {
                            b = b+num
                            }

                        }
                    }
                }

    ) {
        Text("$num", fontSize = TextUnit(50f, TextUnitType.Sp), modifier =  Modifier.align(Alignment.Center))
    }
}

var a = "0"
var b = "0"


fun main() = application() {
    val a = rememberWindowState(width = 605.dp, height = 900.dp)
    Window(onCloseRequest = ::exitApplication, state = a) {
        Calc()
    }
}