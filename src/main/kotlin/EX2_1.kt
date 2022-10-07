import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream


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
}

fun main() {
    val file = File("src/main/resources/penyagolosa.bmp")
    fitxerImagen(file).negative()
    fitxerImagen(file).obscure()
}



