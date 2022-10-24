package Tema3

import java.io.EOFException
import java.io.FileInputStream
import java.io.ObjectInputStream

fun deserializar(): MutableList<Ruta> {
    val deSerializador = ObjectInputStream(FileInputStream("src/main/resources/rutes.obj"))
    var listaRutas:MutableList<Ruta> = deSerializador.readObject() as MutableList<Ruta>

    try {
        while (true){
           listaRutas  = deSerializador.readObject() as MutableList<Ruta>

            //for (ruta in listaRutas)
              //  ruta.mostrarRuta()
        }
    }catch (eof:EOFException){
        deSerializador.close()
    }
    return listaRutas
}