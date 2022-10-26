package Tema3

import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult

fun main() {
    val rutas: MutableList<Ruta> = deserializar()
    val ficheroXML = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument()
    val root = ficheroXML.createElement("Rutes")


    ficheroXML.appendChild(root)

    for (ruta in rutas) {
        val rutaContainer = ficheroXML.createElement("Ruta")
        val nombreRuta = ficheroXML.createElement("NombreRuta")
        val desnivell = ficheroXML.createElement("desnivell")
        val desnivellAcumulat = ficheroXML.createElement("DesnivellAcumulat")
        val puntos = ficheroXML.createElement("Puntos")

        root.appendChild(rutaContainer)
        rutaContainer.appendChild(nombreRuta)
        nombreRuta.appendChild(ficheroXML.createTextNode(ruta.nom))
        rutaContainer.appendChild(desnivell)
        desnivell.appendChild(ficheroXML.createTextNode(ruta.desnivell.toString()))
        rutaContainer.appendChild(desnivellAcumulat)
        desnivellAcumulat.appendChild(ficheroXML.createTextNode(ruta.desnivellAcumulat.toString()))
        rutaContainer.appendChild(puntos)
        for (i in 0 until ruta.size()) {
            val punto = ficheroXML.createElement("Punto")
            puntos.appendChild(punto)
            punto.setAttribute("num", "${i + 1}")
            val nombrePunto = ficheroXML.createElement("Nombre")
            punto.appendChild(nombrePunto)
            nombrePunto.appendChild(ficheroXML.createTextNode(ruta.getPuntNom(i)))
            val latidud = ficheroXML.createElement("Latitud")

            punto.appendChild(latidud)
            latidud.appendChild(ficheroXML.createTextNode(ruta.getPuntLatitud(i).toString()))
            val longitud = ficheroXML.createElement("Longitud")
            punto.appendChild(longitud)
            longitud.appendChild(ficheroXML.createTextNode(ruta.getPuntLongitud(i).toString()))
        }
    }
    val source = DOMSource(ficheroXML)
    val print = StreamResult("src/main/resources/xml3.xml")
    val transformer = TransformerFactory.newInstance().newTransformer()

    transformer.transform(source, print)
}

