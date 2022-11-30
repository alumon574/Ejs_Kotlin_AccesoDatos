package Tema4

import Tema3.Ruta
import java.io.EOFException
import java.io.FileInputStream
import java.io.ObjectInputStream
import java.sql.DriverManager

fun main() {
    val url = "jdbc:sqlite:Tema4.sqlite"
    val con = DriverManager.getConnection(url)
    val statement = con.createStatement()

    val deSerializador = ObjectInputStream(FileInputStream("src/main/resources/rutes.obj"))
    val listaRutas = deSerializador.readObject() as MutableList<Ruta>

    try {
        for (i in 0 until listaRutas.size) {
            // statement.executeUpdate("INSERT INTO Rutes values (\"${i + 1}\",\"${listaRutas.get(i).nom}\",\"${listaRutas.get(i).desnivell}\",\"${listaRutas.get(i).desnivellAcumulat}\")")
            for (j in 0 until listaRutas.get(i).llistaDePunts.size)
                statement.executeUpdate("INSERT INTO Punts values (${i+1},${j+1},\"${listaRutas.get(i).getPunt(j).nom}\",${listaRutas.get(i).getPunt(j).coord.latitud},${listaRutas.get(i).getPunt(j).coord.longitud}")
        }
    }
    catch (eof:EOFException){
        deSerializador.close()
    }
}

