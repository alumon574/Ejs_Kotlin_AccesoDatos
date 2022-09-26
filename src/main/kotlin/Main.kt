import java.io.File

fun Long.ToMB():Long{
    return this/(1024*1024)
}

fun main(args: Array<String>) {
    var currentFile = File.listRoots()[0]
    var userIndex = 0
    var index = 1

    do {
        println("Lista de ficheros")
        println("--------------------------------------------")
        println("-1 para terminar")
        println("0- Directorio padre")
        for (file in currentFile.listFiles()){
            println("$index- $file ${if(file.isDirectory) " <Directory>" else ""} ${if(file.isFile)"${file.length().ToMB()}MB" else ""} ")
            index++
        }
        println("Escribe el indice al que quieras moverte")
        index = readln()!!.toInt()
        if (index!=-1) {
            if (index == 0) {
                currentFile = currentFile.parentFile
                continue
            }

            currentFile = currentFile.listFiles()[index - 1]

            index = 1
        }
    }while (index!=-1)

}

/*fun printDirectory(boolean: Boolean): String {
    var directory = ""
    if (boolean==true)
        directory = " <Directory>"
    else directory = ""
    return directory
}*/

