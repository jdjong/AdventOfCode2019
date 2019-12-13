package Day3

import kotlin.math.abs

class Wire(manhattanInstructions: List<String>) {
    var coordinates = mutableListOf<Pair<Int, Int>>()
    var currentX = 0
    var currentY = 0

    init {
        manhattanInstructions.forEach {
            instruction ->
            run {
                var direction = instruction.substring(0, 1)
                var nrOfSteps = instruction.substring(1).toInt()

                for (step in 1..nrOfSteps) {
                    if (direction == "R") {
                        currentX += 1
                        coordinates.add(Pair(currentX, currentY))
                    }
                    else if (direction == "L") {
                        currentX -= 1
                        coordinates.add(Pair(currentX, currentY))
                    }
                    else if (direction == "U") {
                        currentY += 1
                        coordinates.add(Pair(currentX, currentY))
                    }
                    else if (direction == "D") {
                        currentY -= 1
                        coordinates.add(Pair(currentX, currentY))
                    }
                    else {
                        throw IllegalArgumentException("Direction is unknown: $direction")
                    }
                }
            }
        }
    }

    private fun getOverlaps(otherWire: Wire) : List<Pair<Int, Int>> {
        var result = mutableListOf<Pair<Int, Int>>()
        coordinates.forEach {
            coordinate ->
            run {
                result.addAll(otherWire.coordinates.filter { it == coordinate })
            }
        }

        return result
    }

    private fun getClosestOverlap(otherWire: Wire) : Pair<Int, Int>? {
        var coordinatesOfOverlaps = getOverlaps(otherWire)

        return coordinatesOfOverlaps.minBy { abs(it.first) + abs(it.second) }
    }

    fun getClosestOverlapDistanceToCenterPort(otherWire: Wire) : Int {
        var closestOverlapPoint = getClosestOverlap(otherWire)
        return abs(closestOverlapPoint?.first ?: 0) + abs(closestOverlapPoint?.second ?: 0)
    }
}