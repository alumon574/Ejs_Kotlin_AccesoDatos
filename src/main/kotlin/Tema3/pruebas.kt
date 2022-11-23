package Tema3

import javax.xml.parsers.DocumentBuilderFactory

/*fun main() {
var currentFile = File.listRoots()[0]
    var index = 1


    do {
        printHeader(currentFile)
        for (file in currentFile.listFiles()!!){
            println( "$index- $file ${when {file.isDirectory -> " <Directory>" else -> "" }}" +
                    " ${when {file.isFile -> "${file.length().ToMB()}MB " else -> "" }}" +
                     checkPermission(file) + "\t"+ lastModification(file)
            )
            index++
        }

        printFooter()
        index = readln().toInt()

        if (index!=-1) {
            if (index == 0) {
                currentFile = currentFile.parentFile
                continue
            }

            currentFile = currentFile.listFiles()!![index - 1]

            index = 1
        }
    }while (index!=-1)

}
private fun lastModification(file: File?):String{
    if (file != null) {
        if (file.isFile){
            return Date(file.lastModified()).toString()
        }
    }
    return ""
}
private fun checkPermission(file: File?):String{
    var Permisions = ""
    if (file != null && file.isFile) {
        when {file.canRead() -> Permisions+="R"
            else -> Permisions+="-"}
        when {file.canWrite() -> Permisions+="W"
            else -> Permisions+="-"}
        when {file.canExecute() -> Permisions+="X"
            else -> Permisions+="-"}

    }
    return Permisions
}
private fun printFooter() {
    println("--------------------------------------------")
    println("Escribe el indice al que quieras moverte:")
}

private fun printHeader(currentFile: File?) {
    println("Lista de ficheros del archivo $currentFile")
    println("--------------------------------------------")
    println("-1 para terminar")
    println("0- Directorio padre")
}
*/