package Tema3

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.File


fun main() {
    val listaRutas = deserializar()
    val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    val tipoLista = Types.newParameterizedType(List::class.java, Ruta::class.java)
    val rutasDeserializadas: JsonAdapter<List<Ruta>> = moshi.adapter(tipoLista)
    val json = rutasDeserializadas.toJson(listaRutas)
    File("src/main/resources/rutas.json").writeText(json)
}
