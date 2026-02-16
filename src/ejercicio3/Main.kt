package ejercicio3

fun main() {
    val hospital = Hospital()

    // Médicos
    hospital.agregarMedico(
        Medico(
            nombre = "Laura Gómez",
            identificacion = "M001",
            genero = Genero.FEMENINO,
            email = "laura.gomez@hospital.com",
            especialidad = Especialidad.CARDIOLOGIA,
            salario = 12000.0,
            anioIngreso = 2014
        )
    )

    hospital.agregarMedico(
        Medico(
            nombre = "Carlos Pérez",
            identificacion = "M002",
            genero = Genero.MASCULINO,
            email = null,
            especialidad = Especialidad.PEDIATRIA,
            salario = 9500.0,
            anioIngreso = 2010
        )
    )

    hospital.agregarMedico(
        Medico(
            nombre = "Diana Ruiz",
            identificacion = "M003",
            genero = Genero.FEMENINO,
            email = "diana.ruiz@hospital.com",
            especialidad = Especialidad.PEDIATRIA,
            salario = 9800.0,
            anioIngreso = 2018
        )
    )

    // Pacientes
    hospital.agregarPaciente(
        Paciente(
            nombre = "Juan Medina",
            identificacion = "P001",
            genero = Genero.MASCULINO,
            email = "juan.medina@gmail.com",
            telefono = "3001234567",
            direccion = Direccion("Calle 10 # 5-20", "Bogotá", "110111")
        )
    )

    hospital.agregarPaciente(
        Paciente(
            nombre = "Ana Torres",
            identificacion = "P002",
            genero = Genero.FEMENINO,
            email = null,
            telefono = "3107654321",
            direccion = Direccion("Cra 50 # 20-30", "Medellín", "050021")
        )
    )

    hospital.agregarPaciente(
        Paciente(
            nombre = "Pedro Salazar",
            identificacion = "P003",
            genero = Genero.OTRO,
            email = null,
            telefono = "3200000000",
            direccion = Direccion("Av 3 # 40-10", "Bogotá", "110221")
        )
    )

    println("=== Médicos ===")
    hospital.obtenerMedicos().forEach {
        val emailSeguro = it.email ?: "(sin email)"
        println("- ${it.nombre} | ${it.especialidad} | ingreso ${it.anioIngreso} | email: $emailSeguro")
    }

    println("\n=== Pacientes ===")
    hospital.obtenerPacientes().forEach {
        val emailSeguro = it.email ?: "(sin email)"
        println("- ${it.nombre} | ${it.direccion.ciudad} | tel ${it.telefono} | email: $emailSeguro")
    }

    println("\n=== Total salarios por especialidad ===")
    hospital.totalSalariosPorEspecialidad().forEach { (esp, total) ->
        println("$esp -> $total")
    }

    println("\n=== Médico con más antigüedad ===")
    val masAntiguo = hospital.medicoConMasAntiguedad()
    println(masAntiguo?.let { "${it.nombre} (ingreso ${it.anioIngreso})" } ?: "No hay médicos")

    println("\n=== Extensión: filtrar médicos por PEDIATRIA ===")
    val pediatras = hospital.obtenerMedicos().filtrarPorEspecialidad(Especialidad.PEDIATRIA)
    pediatras.forEach { println("- ${it.nombre}") }

    println("\n=== Extensión: filtrar pacientes por ciudad Bogotá ===")
    val bogota = hospital.obtenerPacientes().filtrarPorCiudad("Bogotá")
    bogota.forEach { println("- ${it.nombre} (${it.direccion.calle})") }

    println("\n=== Eliminar médico M003 y paciente P002 ===")
    println("Medico eliminado: ${hospital.eliminarMedico("M003")}")
    println("Paciente eliminado: ${hospital.eliminarPaciente("P002")}")

    println("\nMédicos restantes: ${hospital.obtenerMedicos().size}")
    println("Pacientes restantes: ${hospital.obtenerPacientes().size}")
}
