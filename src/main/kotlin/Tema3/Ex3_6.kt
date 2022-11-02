package Tema3

import com.squareup.moshi.JsonAdapter

import javax.swing.*
import java.awt.*
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.File

class FinestraJSON : JFrame() {


    init {
        val json = File("src/main/resources/rutas.json").readText()
        // sentències per a omplir llistaRutes
        val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
        val tipoLista = Types.newParameterizedType(List::class.java, Ruta::class.java)
        val adapter:JsonAdapter<List<Ruta>> = moshi.adapter(tipoLista)
        val listaRutas = adapter.fromJson(json)


        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setTitle("JSON: Punts d'una ruta")
        setSize(400, 300)
        setLayout(BorderLayout())

        val panell1 = JPanel(FlowLayout())
        val panell2 = JPanel(BorderLayout())
        add(panell1, BorderLayout.NORTH)
        add(panell2, BorderLayout.CENTER)

        var nomsLlistaRutes = arrayListOf<String>()
        // sentències per a omplir l'ArrayList anterior amb el nom de les rutes
        for (i in listaRutas!!.indices) {
            nomsLlistaRutes.add(listaRutas[i].nom)
        }
        val combo = JComboBox(nomsLlistaRutes.toArray())
        panell1.add(combo)

        panell2.add(JLabel("Llista de punts de la ruta:"), BorderLayout.NORTH)
        val area = JTextArea()
        panell2.add(area)

        combo.addActionListener {
            // accions quan s'ha seleccionat un element del combobox,
            // i que han de consistir en omplir el JTextArea
            val ruta = listaRutas[combo.selectedIndex]
            area.text=""
            for (i in 0 until ruta.size()){
                area.text+= "${ruta.getPuntNom(i)}  (${ruta.getPuntLongitud(i)} , ${ruta.getPuntLatitud(i)})\n"
            }
        }
    }
}

fun main(args: Array<String>) {
    EventQueue.invokeLater {
        FinestraJSON().isVisible = true
    }
}