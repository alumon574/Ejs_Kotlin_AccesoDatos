package Tema3

import org.json.JSONObject
import org.json.JSONTokener
import java.io.FileReader


fun main() {
    val readerJson = FileReader("src/main/resources/rutes.obj")

    val root = JSONTokener(readerJson).nextValue() as JSONObject


}
