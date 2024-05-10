data class CircleItem(
    override var name: String,
    var radius: Double,
    override var mass: Double,
    override var velocity: CartesianVector,
    override var x: Double,
    override var y: Double
): Item(
    name = name,
    distance = radius,
    velocity = velocity,
    mass = mass,
    x = x,
    y = y
)