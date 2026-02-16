package ejercicio2

import ejercicio2.EstadoTarea
import ejercicio2.Prioridad

data class Tarea(
    val titulo: String,
    val descripcion: String?,
    val prioridad: Prioridad,
    val estado: EstadoTarea
)
