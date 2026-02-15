package ejercicio1

fun Producto.valorTotal(): Double = precio * cantidad

fun List<Producto>.resumen(): String {
    val sb = StringBuilder()
    sb.appendLine("Inventario (${this.size} productos):")
    var totalGeneral = 0.0
    for (producto in this) {
        val total = producto.valorTotal()
        totalGeneral += total
        sb.appendLine("   * ${producto.nombre}: \$${producto.precio} x ${producto.cantidad} = \$${"%.2f".format(total)}")
    }
    sb.appendLine("Total inventario: \$${"%.2f".format(totalGeneral)}")
    return sb.toString()
}

fun aplicarDescuento(producto: Producto, porcentaje: Double = 10.0): Producto {
    val factor = 1.0 - (porcentaje / 100.0)
    return producto.copy(precio = Math.round(producto.precio * factor * 100.0) / 100.0)
}

fun main() {

    val productos = mutableListOf(
        Producto("Laptop HP", 1200.00, 5),
        Producto("Mouse Logitech", 35.50, 20),
        Producto("Teclado Mecánico", 89.99, 15),
        Producto("Monitor Samsung 27\"", 350.00, 8),
        Producto("Webcam HD", 65.00, 12)
    )

    println("\n--- Resumen ANTES de aplicar descuentos ---")
    println(productos.resumen())

    println("Aplicando descuento del 10% a '${productos[0].nombre}'...")
    productos[0] = aplicarDescuento(productos[0])

    println("Aplicando descuento del 15% a '${productos[2].nombre}'...")
    productos[2] = aplicarDescuento(productos[2], 15.0)

    println("Aplicando descuento del 20% a '${productos[4].nombre}'...")
    productos[4] = aplicarDescuento(productos[4], 20.0)

    println("\n--- Resumen DESPUÉS de aplicar descuentos ---")
    println(productos.resumen())

    println("--- Valor total individual ---")
    for (p in productos) {
        println("${p.nombre} -> valorTotal() = \$${"%.2f".format(p.valorTotal())}")
    }
}