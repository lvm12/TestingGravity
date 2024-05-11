abstract class Item(
    open var name: String,
    open var position: CartesianVector,
    open var mass: Double,
    open var velocity: CartesianVector,
    open var distance: Double,
    open var force: CartesianVector,
    open var acceleration: CartesianVector,
){
    fun calculate(t: Double = 10.0){
        acceleration = force/mass
        velocity = acceleration*t + velocity
        position = velocity*t + position
    }
}