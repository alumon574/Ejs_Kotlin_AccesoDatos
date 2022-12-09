package Tema3

import java.io.*

fun main() {
    val deSerializador = ObjectInputStream(FileInputStream("src/main/resources/rutes.obj"))
    val file = DataInputStream(FileInputStream("src/main/resources/rutes.dat"))
    val serializador = ObjectOutputStream(FileOutputStream("src/main/resources/rutes.obj"))
    val listaPuntos = ArrayList<PuntGeo>()
    val rutas = mutableListOf<Ruta>()

    while (file.available() > 0) {
        var nombreRuta = file.readUTF()
        var desnivell = file.readInt()
        var desnivellAcumulat = file.readInt()
        var numPunts = file.readInt()
        for (i in 1..numPunts) {
            var nombrePunto = file.readUTF()
            var longitud = file.readDouble()
            var latitud = file.readDouble()
            var coord = Coordenadas(longitud, latitud)
            var puntGeo = PuntGeo(nombrePunto, coord)
            listaPuntos.add(puntGeo)
        }
        val ruta = Ruta(nombreRuta, desnivell, desnivellAcumulat, listaPuntos.toMutableList())
        ruta.mostrarRuta()
        rutas.add(ruta)
        listaPuntos.clear()

    }
    serializador.writeObject(rutas)
    file.close()

}