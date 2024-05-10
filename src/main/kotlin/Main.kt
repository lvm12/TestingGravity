import kotlin.math.cos
import kotlin.math.sin

fun main(){
    val world = World(
        items = listOf(
            /*CircleItem(
                name = "Earth",
                radius = 6.3781e+6,
                mass = 5.9722e+24,
                x = 0.0,
                y = 0.0,
                velocity = CartesianVector(0.0,0.0)
            ),
            CircleItem(
                name = "Mars",
                radius = 3.3962e+6,
                mass = 6.42e+23,
                x = 2.25e+11* cos(Math.toRadians(45.0)),
                y = 2.25e+11* sin(Math.toRadians(45.0)),
                velocity = CartesianVector(0.0,0.0)
            )*/
            CircleItem(
                name = "Mass 1",
                radius = 1.0,
                mass = 1.0,
                x = 0.0,
                y = 0.0,
                velocity = CartesianVector(0.0,0.0)
            ),
            CircleItem(
                name = "Mass 2",
                radius = 1.0,
                mass = 1.0,
                x = 1.0,
                y = 0.0,
                velocity = CartesianVector(0.0,0.0)
            )
        )
    )
    val num = readln()
    if (num == "0") while (true){
        readln()
        world.next()
    }else if (num == "1"){
        world.repeat(50000)
    }else world.start()
}