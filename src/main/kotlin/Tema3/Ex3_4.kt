package Tema3

import javax.swing.*
import java.awt.*
import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.NodeList
import javax.xml.parsers.DocumentBuilderFactory


class Finestra : JFrame() {

    init {
        val dbFactory = DocumentBuilderFactory.newInstance()
        val dBuilder = dbFactory.newDocumentBuilder()
        val doc = dBuilder.parse("src/main/resources/xml3.xml")

        val root = doc.documentElement
        val rutes = root.childNodes
        var puntos: NodeList

        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setTitle("Punts d'una ruta")
        setSize(400, 300)
        setLayout(BorderLayout())

        val panell1 = JPanel(FlowLayout())
        val panell2 = JPanel(BorderLayout())
        add(panell1, BorderLayout.NORTH)
        add(panell2, BorderLayout.CENTER)

        val llistaRutes = arrayListOf<String>()
        // sentències per a omplir l'ArrayList anterior amb el nom de les rutes
        for (i in 0 until rutes.length) {
            val ruta = rutes.item(i)
            val nom = ruta.firstChild.textContent
            llistaRutes.add(nom)
        }

        val combo = JComboBox(llistaRutes.toArray())
        panell1.add(combo)

        panell2.add(JLabel("Llista de punts de la ruta:"), BorderLayout.NORTH)
        val area = JTextArea()
        panell2.add(area)

        combo.addActionListener {
            // accions quan s'ha seleccionat un element del combobox,
            // i que han de consistir en omplir el JTextArea
            puntos = rutes.item(combo.selectedIndex).childNodes.item(3).childNodes

            area.text = ""
            for (i in 0 until puntos.length) {
                val punt = puntos.item(i).childNodes
                val nombre = punt.item(0).textContent
                val latitud = punt.item(1).textContent
                val longitud = punt.item(2).textContent
                area.text += "$nombre  ($latitud,$longitud) \n"
            }
        }
    }
}

fun main(args: Array<String>) {
    EventQueue.invokeLater {
        Finestra().isVisible = true
    }
}