package ejercicio3

fun List<Medico>.filtrarPorEspecialidad(especialidad: Especialidad): List<Medico> =
    this.filter { it.especialidad == especialidad }

fun List<Paciente>.filtrarPorCiudad(ciudad: String): List<Paciente> =
    this.filter { it.direccion.ciudad.equals(ciudad, ignoreCase = true) }
