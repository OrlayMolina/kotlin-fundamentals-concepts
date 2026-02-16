package ejercicio3

open class Persona(
    val nombre: String,
    val identificacion: String,
    val genero: Genero,
    val email: String? = null // puede ser nulo
)
