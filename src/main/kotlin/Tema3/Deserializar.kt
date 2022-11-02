package Tema3

import java.io.EOFException
import java.io.FileInputStream
import java.io.ObjectInputStream
import java.lang.reflect.ParameterizedType
import java.util.Random

fun deserializar(): MutableList<Ruta> {
    val deSerializador = ObjectInputStream(FileInputStream("src/main/resources/rutes.obj"))
    val listaRutas = deSerializador.readObject() as MutableList<Ruta>

    return listaRutas
}