package Tema4

import Tema3.Ruta
import java.io.FileInputStream
import java.io.ObjectInputStream

fun main() {

    val deSerializador = ObjectInputStream(FileInputStream("src/main/resources/rutes.obj"))
    val listaRutas = deSerializador.readObject() as MutableList<Ruta>


}