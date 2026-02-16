package ejercicio3

class Hospital {
    private val medicos = mutableListOf<Medico>()
    private val pacientes = mutableListOf<Paciente>()

    // Exponer listas solo lectura
    fun obtenerMedicos(): List<Medico> = medicos.toList()
    fun obtenerPacientes(): List<Paciente> = pacientes.toList()

    // Agregar
    fun agregarMedico(medico: Medico) {
        medicos.add(medico)
    }

    fun agregarPaciente(paciente: Paciente) {
        pacientes.add(paciente)
    }

    // Eliminar por identificación (return true si eliminó algo)
    fun eliminarMedico(identificacion: String): Boolean =
        medicos.removeIf { it.identificacion == identificacion }

    fun eliminarPaciente(identificacion: String): Boolean =
        pacientes.removeIf { it.identificacion == identificacion }

    // Total salarios por especialidad
    fun totalSalariosPorEspecialidad(): Map<Especialidad, Double> =
        medicos.groupBy { it.especialidad }
            .mapValues { (_, lista) -> lista.sumOf { it.salario } }

    // Médico con más antigüedad = menor añoIngreso
    fun medicoConMasAntiguedad(): Medico? =
        medicos.minByOrNull { it.anioIngreso }
}
