package Tema3

import java.io.DataInputStream
import java.io.FileInputStream
import java.io.RandomAccessFile

fun main() {
    val file = DataInputStream(FileInputStream("src/main/resources/rutes.dat"))
    while (file.available() > 0) {
        println("Ruta: ${file.readUTF()}")
        println("Desnivell: ${file.readInt()}")
        println("Desnivell acumulat: ${file.readInt()}")
        val numPuntos = file.readInt()
        println("Te $numPuntos punts")
        for (i in 1 .. numPuntos) {
            println("Punt $i: ${file.readUTF()} (${file.readDouble()},${file.readDouble()})")
        }
        println()
    }
    file.close()
}