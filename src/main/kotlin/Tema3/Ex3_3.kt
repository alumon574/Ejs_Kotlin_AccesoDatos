package Tema3

import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult

fun main() {
    val rutas: MutableList<Ruta> = deserializar()
    val creaDOM = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument()
    val root = creaDOM.createElement("Rutes")



    creaDOM.appendChild(root)

    for (ruta in rutas) {
        val rutaContainer = creaDOM.createElement("Ruta")
        val nombreRuta = creaDOM.createElement("NombreRuta")
        val desnivell = creaDOM.createElement("desnivell")
        val desnivellAcumulat = creaDOM.createElement("DesnivellAcumulat")
        val puntos = creaDOM.createElement("Puntos")

        root.appendChild(rutaContainer)
        rutaContainer.appendChild(nombreRuta)
        nombreRuta.appendChild(creaDOM.createTextNode(ruta.nom))
        rutaContainer.appendChild(desnivell)
        desnivell.appendChild(creaDOM.createTextNode(ruta.desnivell.toString()))
        rutaContainer.appendChild(desnivellAcumulat)
        desnivellAcumulat.appendChild(creaDOM.createTextNode(ruta.desnivellAcumulat.toString()))
        rutaContainer.appendChild(puntos)
        for (i in 0 until ruta.size()) {
            val punto = creaDOM.createElement("Punto")
            puntos.appendChild(punto)
            punto.setAttribute("num", "${i + 1}")
            val nombrePunto = creaDOM.createElement("Nombre")
            punto.appendChild(nombrePunto)
            nombrePunto.appendChild(creaDOM.createTextNode(ruta.getPuntNom(i)))
            val latidud = creaDOM.createElement("Latitud")

            punto.appendChild(latidud)
            latidud.appendChild(creaDOM.createTextNode(ruta.getPuntLatitud(i).toString()))
            val longitud = creaDOM.createElement("Longitud")
            punto.appendChild(longitud)
            longitud.appendChild(creaDOM.createTextNode(ruta.getPuntLongitud(i).toString()))
        }
    }
    val source = DOMSource(creaDOM)
    val print = StreamResult("src/main/resources/xml3.xml")
    val transformer = TransformerFactory.newInstance().newTransformer()

    transformer.transform(source, print)
}

