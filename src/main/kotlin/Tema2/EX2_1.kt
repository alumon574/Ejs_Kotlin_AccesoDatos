import java.io.File


class fitxerImagen(fEnt: File) {
    var f = File("")

    init {
        if (fEnt.extension == "bmp" && fEnt.exists())
            f = fEnt
        else println("Error de fichero")
    }

    fun negative() {
        val fOut = File("src/main/resources/penyagolosa_neg.bmp")
        val bytes = f.readBytes()
        val metadatos = bytes.take(54)
        fOut.writeBytes(metadatos.toByteArray())
        val pixelsOrigin = bytes.sliceArray(54 until bytes.size)
        for (i in pixelsOrigin.indices)
            pixelsOrigin[i] = (255 - pixelsOrigin[i]).toByte()
        fOut.appendBytes(pixelsOrigin)
    }

    fun obscure(){
        val fOut = File("src/main/resources/penyagolosa_dark.bmp")
        val bytes = f.readBytes()
        val metadata = bytes.take(54)
        fOut.writeBytes(metadata.toByteArray())
        val originalPixels = bytes.sliceArray(54 until bytes.size)
        fOut.appendBytes(originalPixels.map { (it.toUByte()/2u).toByte() }.toByteArray())
    }

    fun mezclar(){
        val fOut = File("src/main/resources/mezcla.bmp")
        val fIn = File("src/main/resources/triangulo.bmp")
        val fIn2 = File("src/main/resources/cuadrado.bmp")

        val leeCuadrado = fIn2.readBytes()
        val leeTrangulo = fIn.readBytes()

        for (i in leeCuadrado.indices){
            if (leeTrangulo[i]>=0)
                leeCuadrado[i]=leeTrangulo[i]
        }
        fOut.writeBytes(leeCuadrado)
    }
}

fun main() {
    val file = File("src/main/resources/penyagolosa.bmp")
    fitxerImagen(file).mezclar()
}



