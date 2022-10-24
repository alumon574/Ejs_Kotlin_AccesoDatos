package Tema3

import java.io.EOFException
import java.io.FileInputStream
import java.io.ObjectInputStream

fun main() {
    val deSerializador = ObjectInputStream(FileInputStream("src/main/resources/rutes.obj"))


    try {
        while (true){
            var listaRutas = deSerializador.readObject() as MutableList<Ruta>

            for (ruta in listaRutas)
                ruta.mostrarRuta()
        }
    }catch (eof:EOFException){
        deSerializador.close()
    }
}