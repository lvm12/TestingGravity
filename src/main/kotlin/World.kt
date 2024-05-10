import kotlin.math.pow

const val G = 0.66743e-11

data class World(
    var started: Boolean = false,
    var items: List<Item> = emptyList(),
    val throttleTime: Double = 500.0
){
    var x = 0.0
    fun repeat(n: Int){
        repeat(n){
            next()
        }
        x = 0.0
    }
    fun next(){
        println("$x seconds passed")
        println("${items[0].name} at (${items[0].x}, ${items[0].y})")
        println("${items[1].name} at (${items[1].x}, ${items[1].y})")
        items = items.map {
            applyWorld(it, items)
        }
        x += throttleTime/1000
    }
    fun stop(){
        started = false
    }
    fun start(){
        started = true
        val previous = CartesianVector(
            x = 1e-100,
            y = 1e-100,
        )
        while (started){
            next()
            val current = CartesianVector(
                x = items[0].x,
                y = items[0].y
            )
            if (current == previous) break
        }
        x = 0.0
    }
    private fun applyWorld(item: Item, items: List<Item>): Item {
        val t = throttleTime/1000
        val velocities = items.map {
            findVelocity(item, it)
        }

        val yChange = velocities.sumOf {
            if (!it.y.isNaN() && it.y.isFinite()) it.y
            else 0.0
        }
        println("yChange: $yChange")
        val xChange = velocities.sumOf {
            if (!it.x.isNaN() && it.x.isFinite()) it.x
            else 0.0
        }
        println("xChange: $xChange")
        val sx = xChange*t
        println("sx: $sx")
        val sy = yChange*t
        println("sy: $sy")
        val totalSx = sx + item.x
        println("totalSx: $totalSx")
        val totalSy = sy + item.y
        println("totalSy: $totalSy")
        return item.apply {
            velocity = CartesianVector(
                y = yChange,
                x = xChange
            )
            x = totalSx
            y = totalSy
        }
    }
    private fun findVelocity(a: Item, b: Item): CartesianVector{
        if (a == b) return CartesianVector(0.0, 0.0)
        val t = throttleTime/1000
        //val yDistance = b.y - a.y
        //val yDistanceSquared = yDistance.pow(2)
        //println("yDistanceSquared: $yDistanceSquared")
        val xDistance = b.x - a.x
        println("b.x: ${b.x}, a.x: ${a.x}")
        val xDistanceSquared = xDistance.pow(2)
        println("xDistanceSquared: $xDistanceSquared")

        val top = G*a.mass*b.mass
        println("top: $top")
        //val yForce = top/yDistanceSquared
        //println("yForce: $yForce")
        val xForce = top/xDistanceSquared
        println("xForce: $xForce")
        //val yA = yForce/a.mass
        //println("yA: $yA")
        val xA = xForce/a.mass
        println("xA: $xA")

        //var yV = yA * t
        //println("yV: $yV")
        var xV = xA * t
        println("xV: $xV")
        //if(yDistance< 0) yV = -yV
        if (xDistance< 0) xV = -xV

        if (xV.isNaN() /*|| yV.isNaN()*/) return CartesianVector(0.0,0.0)
        return CartesianVector(
            y = 0.0,
            x = xV,
        )
    }
}