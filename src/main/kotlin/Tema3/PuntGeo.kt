package Tema3

import java.io.Serializable

class PuntGeo (var nom:String, var coord:Coordenadas):Serializable{
    companion object{
        private const val serialVersionUID: Long = 1
    }
}