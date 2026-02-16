package ejercicio3

class Medico(
    nombre: String,
    identificacion: String,
    genero: Genero,
    email: String? = null,
    val especialidad: Especialidad,
    val salario: Double,
    val anioIngreso: Int
) : Persona(nombre, identificacion, genero, email)
