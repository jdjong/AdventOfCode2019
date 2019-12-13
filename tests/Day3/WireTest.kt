package Day3

import io.kotlintest.matchers.shouldEqual
import io.kotlintest.properties.row
import io.kotlintest.specs.StringSpec

class WireTest : StringSpec({
    "given two wires when testing overlap then the expected distance is returned" {
        listOf(
            row(listOf("R75","D30","R83","U83","L12","D49","R71","U7","L72"), listOf("U62","R66","U55","R34","D71","R55","D58","R83"), 159),
            row(listOf("R98","U47","R26","D63","R33","U87","L62","D20","R33","U53","R51"), listOf("U98","R91","D20","R16","D67","R40","U7","R15","U6","R7"), 135)
        ).map { (wire1Input: List<String>, wire2Input: List<String>, result: Int) ->
            var wire1 = Wire(wire1Input)
            var wire2 = Wire(wire2Input)

            wire1.getClosestOverlapDistanceToCenterPort(wire2) shouldEqual result
        }
    }
}) {
}