const val G = 6.6743e-11

data class World(
    var started: Boolean = false,
    var items: List<Item> = emptyList(),
    val deltaT: Double = 10.0
){

    fun next(){
        items.forEach {
            println("${it.name} at ${it.position}")
        }
        items.forEach{ item ->
            val forces = items.map {
                val force = calculateForce(central = item, satellite = it)
                println("force: $force")
                force
            }
            val sumForces = forces.sumOf()
            item.force = sumForces
            item.calculate()
        }
    }
    private fun calculateForce(central: Item, satellite: Item): CartesianVector{
        if (central == satellite) return CartesianVector(0.0,0.0)
        val r = satellite.position - central.position
        println(satellite.position)
        println(central.position)
        println("Distance: $r")
        val fv  = (G * central.mass * satellite.mass)/(r.magnitudeSquared())
        return r.norm()*fv
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
}