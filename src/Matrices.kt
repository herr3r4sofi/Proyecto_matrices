class Examen(val nombres: Array<String>) {
    private val plantilla = arrayOf('a', 'c', 'b', 'a', 'd', 'b', 'b', 'c', 'a', 'a', 'b', 'd')
    private val respuestas = Array(4) { CharArray(12) }
    private val notas = FloatArray(4)
    private var contador = 0

    fun leerRespuestas(respuestasEstudiante: CharArray) {
        if (contador < 4) {
            respuestas[contador] = respuestasEstudiante
            contador++
        }
    }

    fun calculaNota() {
        for (i in respuestas.indices) {
            var correctas = 0
            for (j in respuestas[i].indices) {
                if (respuestas[i][j] == plantilla[j]) {
                    correctas++
                }
            }
            val nota = (correctas * 100.0 / 12).toFloat()
            notas[i] = nota
        }
    }

    fun promedioGrupo(): Float {
        var suma = 0f
        for (nota in notas) {
            suma += nota
        }
        return suma / notas.size
    }

    fun mayorNota(): String {
        var maxNota = notas[0]
        var indiceMax = 0
        for (i in notas.indices) {
            if (notas[i] > maxNota) {
                maxNota = notas[i]
                indiceMax = i
            }
        }
        return nombres[indiceMax]
    }

    override fun toString(): String {
        var resultado = ""
        for (i in nombres.indices) {
            val estado = when {
                notas[i] >= 70 -> "Aprobó"
                notas[i] >= 60 -> "Aplazó"
                else -> "Reprobó"
            }
            resultado += "Estudiante: ${nombres[i]} Respuestas: ${respuestas[i].joinToString(" ")} Nota: ${notas[i]} $estado\n"
        }
        resultado += "Promedio del grupo: ${promedioGrupo()}\n"
        resultado += "El estudiante con mayor nota es ${mayorNota()}.\n"
        return resultado
    }
}

fun main() {
    val nombres = arrayOf("Marta", "Pedro", "Juan", "María")

    val respuestasMarta = charArrayOf('a', 'c', 'b', 'a', 'd', 'b', 'b', 'c', 'a', 'a', 'b', 'd')
    val respuestasPedro = charArrayOf('b', 'c', 'b', 'd', 'd', 'b', 'b', 'a', 'b', 'd', 'b', 'd')
    val respuestasJuan = charArrayOf('c', 'c', 'b', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'b', 'c')
    val respuestasMaria = charArrayOf('c', 'c', 'b', 'a', 'd', 'b', 'b', 'c', 'a', 'a', 'b', 'c')
    val examen = Examen(nombres)
    examen.leerRespuestas(respuestasMarta)
    examen.leerRespuestas(respuestasPedro)


}