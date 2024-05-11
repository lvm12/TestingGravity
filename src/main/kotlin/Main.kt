fun main(){
    val world = World(
        items = listOf(
//            CircleItem(
//                name = "Earth",
//                radius = 6.3781e+6,
//                mass = 5.9722e+24,
//                position = CartesianVector(0.0,0.0),
//                velocity = CartesianVector(0.0,0.0),
//                force = CartesianVector(0.0,0.0),
//                acceleration = CartesianVector(0.0,0.0),
//            ),
//            CircleItem(
//                name = "Mars",
//                radius = 3.3962e+6,
//                mass = 6.42e+23,
//                position =CartesianVector(
//                    2.25e+11,
//                    0.0
//                ),
//                velocity = CartesianVector(0.0,0.0),
//                acceleration = CartesianVector(0.0,0.0),
//                force = CartesianVector(0.0,0.0)
//            )
            CircleItem(
                name = "Mass 1",
                radius = 1.0,
                mass = 1.0,
                position = CartesianVector(0.0,0.0),
                velocity = CartesianVector(0.0,0.0),
                acceleration = CartesianVector(0.0,0.0),
                force = CartesianVector(0.0,0.0),
            ),
            CircleItem(
                name = "Mass 2",
                radius = 1.0,
                mass = 1.0,
                position = CartesianVector(1.0,0.0),
                velocity = CartesianVector(0.0,0.0),
                acceleration = CartesianVector(0.0,0.0),
                force = CartesianVector(0.0,0.0),
            )
        )
    )
    val num = readln()
    if (num == "0") while (true){
        readln()
        world.next()
    }else if (num == "1"){
        world.repeat(2500)
    }else world.start()
}