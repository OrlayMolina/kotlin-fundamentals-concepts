package ejercicio3

data class Paciente(
    val nombre: String,
    val identificacion: String,
    val genero: Genero,
    val email: String? = null,
    val telefono: String,
    val direccion: Direccion
)
