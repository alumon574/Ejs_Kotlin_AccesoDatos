package Tema4

import Tema3.Ruta
import java.io.EOFException
import java.io.FileInputStream
import java.io.ObjectInputStream
import java.sql.DriverManager

fun main() {
    val url = "jdbc:sqlite:src/main/resources/Tema4.sqlite"
    val con = DriverManager.getConnection(url)
    val statement = con.createStatement()

    val deSerializador = ObjectInputStream(FileInputStream("src/main/resources/rutes.obj"))
    val listaRutas = deSerializador.readObject() as MutableList<Ruta>
    var numPunto = 0
    try {
        for (i in 0 until listaRutas.size) {
            val statement1 = "INSERT INTO Rutes(nombre_ruta, desnivel, desnivel_acumulado) VALUES (\"${listaRutas.get(i).nom}\",${listaRutas.get(i).desnivell},${listaRutas.get(i).desnivellAcumulat})"
            println(statement1)
            statement.executeUpdate(statement1)
            val numRuta = statement.executeQuery("SELECT MAX(numero_ruta) from Rutes")
            numRuta.next()
            for (j in 0 until listaRutas[i].llistaDePunts.size){
                numPunto++
                val statement2 = "INSERT INTO Punts values ($numRuta,$numPunto,\"${listaRutas[i].llistaDePunts[j].nom}\",${listaRutas[i].llistaDePunts[j].coord.latitud},${listaRutas[i].llistaDePunts[j].coord.longitud})"
                println(statement2)
                statement.executeUpdate(statement2)
            }
        }
    }
    catch (eof:EOFException){
        deSerializador.close()
    }
}

