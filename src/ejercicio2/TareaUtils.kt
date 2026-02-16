package ejercicio2

fun mostrarEstado(tarea: Tarea) {
    val msg = when (val e = tarea.estado) {
        EstadoTarea.Pendiente ->
            "'${tarea.titulo}' está pendiente (prioridad: ${tarea.prioridad}, nivel ${tarea.prioridad.nivel})."

        is EstadoTarea.EnProgreso ->
            "'${tarea.titulo}' está en progreso: ${e.porcentaje}% (prioridad: ${tarea.prioridad})."

        is EstadoTarea.Completada ->
            "'${tarea.titulo}' fue completada el ${e.fechaFinalizacion} (prioridad: ${tarea.prioridad})."

        is EstadoTarea.Cancelada ->
            "'${tarea.titulo}' fue cancelada. Motivo: ${e.motivo} (prioridad: ${tarea.prioridad})."
    }

    println(msg)
}