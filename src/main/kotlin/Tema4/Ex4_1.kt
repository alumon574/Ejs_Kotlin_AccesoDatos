package Tema4

import java.sql.DriverManager

fun main() {
    val url = "jdbc:sqlite:src/main/resources/Tema4.sqlite"

    val connection = DriverManager.getConnection(url)

    val statement = connection.createStatement()
    statement.executeUpdate("CREATE TABLE Rutes(numero_ruta INTEGER PRIMARY KEY AUTOINCREMENT , nombre_ruta TEXT, desnivel INTEGER, desnivel_acumulado INTEGER)")
    statement.executeUpdate("CREATE TABLE  Punts(numero_ruta INTEGER, numero_punto INTEGER, nombre_punto TEXT, latitud REAL, longitud REAL,PRIMARY KEY (numero_ruta,numero_punto),FOREIGN KEY (numero_ruta) REFERENCES Rutes(numero_ruta) )")

    connection.close()
}