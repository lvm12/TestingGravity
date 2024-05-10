import kotlin.math.*

data class CartesianVector(
    val x: Double,
    val y: Double,
){
    fun toPolarVector(): PolarVector {
        val magnitude = sqrt(x.pow(2) + y.pow(2))
        val angle = atan2(y, x)
        return PolarVector(
            magnitude = magnitude,
            direction = angle
        )
    }
}

data class PolarVector(
    val magnitude: Double,
    val direction: Double,
){
    fun toCartesianVector(): CartesianVector {
        return CartesianVector(
            x = magnitude*cos(direction),
            y = magnitude*sin(direction),
        )
    }
}