import java.io.File

class CSV(
    private val previousX: List<Triple<String, Double, Double>>,
    private val previousY: List<Triple<String,Double, Double>>,
) {
    private var data = ""
    fun generateData(){
        data += "xL,yL,item,time\n"
        for (i in previousX.indices){
            data += "${previousX[i].second},${previousY[i].second},${previousX[i].first},${previousX[i].third}\n"
        }
    }
    fun saveData(){
        val file = File("results.csv")
        file.delete()
        val outputStream = file.outputStream()
        outputStream.use {
            val writer = it.bufferedWriter()
            writer.write(data)
            writer.flush()
        }
    }
}