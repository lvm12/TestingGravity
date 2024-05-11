data class CircleItem(
    override var name: String,
    var radius: Double,
    override var mass: Double,
    override var velocity: CartesianVector,
    override var position: CartesianVector,
    override var acceleration: CartesianVector,
    override var force: CartesianVector
): Item(
    name = name,
    distance = radius,
    velocity = velocity,
    mass = mass,
    position = position,
    acceleration = acceleration,
    force = force
)