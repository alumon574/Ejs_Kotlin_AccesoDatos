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
        val numPuntos = ficheroXML.createElement("NumeroDePuntos")
        var punto = ficheroXML.createElement("Punto")
        val latidud = ficheroXML.createElement("Latitud")
        val longitud = ficheroXML.createElement("Longitud")
        root.appendChild(rutaContainer)
        rutaContainer.appendChild(nombreRuta)
        nombreRuta.appendChild(ficheroXML.createTextNode(ruta.nom))
        nombreRuta.appendChild(desnivell)
        desnivell.appendChild(ficheroXML.createTextNode(ruta.desnivell.toString()))
        nombreRuta.appendChild(desnivellAcumulat)
        desnivellAcumulat.appendChild(ficheroXML.createTextNode(ruta.desnivellAcumulat.toString()))
        nombreRuta.appendChild(numPuntos)
        numPuntos.appendChild(ficheroXML.createTextNode(ruta.llistaDePunts.size.toString()))
        for (i in 0 until ruta.size()) {
            numPuntos.appendChild(punto)
            punto.setAttribute("numPunto","${i+1}")
            punto.appendChild(latidud)
            latidud.appendChild(ficheroXML.createTextNode(ruta.getPuntLatitud(i).toString()))
            punto.appendChild(longitud)
            longitud.appendChild(ficheroXML.createTextNode(ruta.getPuntLongitud(i).toString()))
        }
    }
    val source = DOMSource(ficheroXML)
    val print = StreamResult("src/main/resources/xml3.xml")
    val transformer = TransformerFactory.newInstance().newTransformer()

    transformer.transform(source, print)
}

