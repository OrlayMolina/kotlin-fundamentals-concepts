package ejercicio2

fun main() {
    val tareas = mutableListOf(
        Tarea("Pagar servicios", "Luz y agua", Prioridad.MEDIA, EstadoTarea.Pendiente),
        Tarea("Preparar presentación", "Slides reunión", Prioridad.ALTA, EstadoTarea.EnProgreso(60)),
        Tarea("Actualizar CV", null, Prioridad.BAJA, EstadoTarea.Completada("2026-02-10")),
        Tarea("Deploy producción", "Release v2.3", Prioridad.CRITICA, EstadoTarea.Pendiente),
        Tarea("Comprar mercado", "Frutas y verduras", Prioridad.BAJA, EstadoTarea.Cancelada("No hubo tiempo")),
        Tarea("Revisar alertas monitoreo", "Dashboards red", Prioridad.CRITICA, EstadoTarea.EnProgreso(15))
    )

    println("=== 1) Estado de todas las tareas ===")
    tareas.forEach(::mostrarEstado)

    println("\n=== 2) Filtrar: prioridad ALTA o CRITICA y NO canceladas ===")
    tareas
        .filter { it.prioridad in setOf(Prioridad.ALTA, Prioridad.CRITICA) }
        .filter { it.estado !is EstadoTarea.Cancelada }
        .forEach { println("- ${it.titulo} (${it.prioridad})") }

    println("\n=== 3) Contar cuántas tareas hay en cada estado (groupBy) ===")
    val conteoPorEstado = tareas
        .groupBy {
            when (it.estado) {
                EstadoTarea.Pendiente -> "Pendiente"
                is EstadoTarea.EnProgreso -> "EnProgreso"
                is EstadoTarea.Completada -> "Completada"
                is EstadoTarea.Cancelada -> "Cancelada"
            }
        }
        .mapValues { it.value.size }

    conteoPorEstado.forEach { (estado, cantidad) -> println("$estado: $cantidad") }

    println("\n=== 4) Tarea con mayor prioridad que esté pendiente ===")
    val mayorPendiente = tareas
        .filter { it.estado == EstadoTarea.Pendiente }
        .maxByOrNull { it.prioridad.nivel }

    println(mayorPendiente?.let { "Mayor pendiente: ${it.titulo} (${it.prioridad})" } ?: "No hay tareas pendientes.")

    println("\n=== 5) Destructuring: imprimir solo título y prioridad ===")
    for ((titulo, _, prioridad) in tareas) {
        println("• $titulo - $prioridad")
    }
}
