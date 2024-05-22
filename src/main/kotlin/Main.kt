fun main(){
    val world = World(
        items = listOf(
            CircleItem(
                name = "Earth",
                radius = 6.3781e+6,
                mass = 5.9722e+24,
                position = CartesianVector(0.0,0.0),
                velocity = CartesianVector(0.0,0.0),
                force = CartesianVector(0.0,0.0),
                acceleration = CartesianVector(0.0,0.0),
            ),
            CircleItem(
                name = "ISS",
                radius = 6.3781e+6,
                mass = 419725.0,
                position = CartesianVector(
                    x = 420_000.0 + 6.3781e+6,
                    y = 0.0
                ),
                velocity = CartesianVector(
                    0.0,
                    7567.0
                ),
                force = CartesianVector(0.0,0.0),
                acceleration = CartesianVector(0.0,0.0),
            ),
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
//            CircleItem(
//                name = "Mass 1",
//                radius = 1.0,
//                mass = 1.0,
//                position = CartesianVector(0.0,0.0),
//                velocity = CartesianVector(0.0,0.0),
//                acceleration = CartesianVector(0.0,0.0),
//                force = CartesianVector(0.0,0.0),
//            ),
//            CircleItem(
//                name = "Mass 2",
//                radius = 1.0,
//                mass = 1.0,
//                position = CartesianVector(1.0,0.0),
//                velocity = CartesianVector(0.0,0.0),
//                acceleration = CartesianVector(0.0,0.0),
//                force = CartesianVector(0.0,0.0),
//            )
        ),
        deltaT = 0.5
    )
    val num = readln()
    if (num == "0"){
        world.extraLogging()
        while (true) {
            readln()
            world.next()
        }
    }else if (num == "1"){
        println("Repeat how many times?")

        world.repeat(readln().toInt())
    }

    world.repeatUntil {
        it.t == 5400.0
        //it.items[0].position.x > it.items[1].position.x
    }
    //Produces result of 96130 seconds, or 1.1 days at 10.0 seconds interval
    //Produces result of 96136.0 at 0.5 seconds intervals
    val csv = CSV(
        world.previousX,
        world.previousY
    )
    csv.generateData()
    csv.saveData()
}