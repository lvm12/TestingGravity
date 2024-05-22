import kotlin.math.pow

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
        val u = velocity
        //F = ma
        // a F/m
        acceleration = force/mass
        //a = (v-u)/t
        //at = v-u
        //v = u + at
        velocity = acceleration*t + u
        //s = ut + 1/2 at^2
        //Therefore, the new position is the formula plus the old position
        position = u*t + (1.0/2.0)*acceleration*t.pow(2) + position
    }
}