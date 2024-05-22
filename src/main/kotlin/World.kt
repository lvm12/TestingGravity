const val G = 6.6743e-11

data class World(
    var started: Boolean = false,
    var items: List<Item> = emptyList(),
    val deltaT: Double = 10.0,
){
    private var extraLogging: Boolean = false
    var previousX: MutableList<Triple<String,Double, Double>> = mutableListOf()
    var previousY: MutableList<Triple<String, Double, Double>> = mutableListOf()
    var t = 0.0
    fun extraLogging() {
        extraLogging = true
    }
    fun next(){
        t += deltaT
        items.forEach { item ->
            previousX.add(Triple(item.name, item.position.x, t))
            previousY.add(Triple(item.name, item.position.y, t))

            println("${item.name} at ${item.position}")
            println("${item.name} acceleration: ${item.acceleration.magnitude()}")

            if (extraLogging){
                println("${item.name} force: ${item.force.magnitude()}")
                println("${item.name} velocity: ${item.velocity}")
            }

            val forces = items.map {
                calculateForce(central = item, satellite = it)
                //println("force: $force")
            }
            val sumForces = forces.sumOf()
            item.force = sumForces
            item.calculate(deltaT)
        }
        println("Time passed: $t")
    }
    private fun calculateForce(central: Item, satellite: Item): CartesianVector{
        if (central.position == satellite.position) return CartesianVector(0.0,0.0)
        //Returns a vector to show the distance between the two,
        val r = satellite.position - central.position
        //println(satellite.position)
        //println(central.position)
        //println("Distance: $r")
        //    G*M*m
        //F = -----
        //     r^2
        val f = (G * central.mass * satellite.mass)/(r.magnitudeSquared())
        return r.norm()*f
    }
    fun start(){
        started = true
        while(started){
            next()
        }
    }
    fun repeat(n: Int){
        repeat(n){
            next()
        }
    }
    fun repeatUntil(
        case: (world: World) -> Boolean
    ){
        while (!case(this)) {
            next()
        }
    }
}