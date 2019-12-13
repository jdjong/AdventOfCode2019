package Day3

import java.io.File

fun main() {
    // Code for silver star
    var inputFile = File("src/Day3/Day3PuzzleInput.txt")
    var puzzleInput = inputFile.readLines()
    var puzzleInputWire1 = puzzleInput[0].split(",")
    var puzzleInputWire2 = puzzleInput[1].split(",")

    println(puzzleInputWire1)
    println(puzzleInputWire2)

    var solution = Wire(puzzleInputWire1).getClosestOverlapDistanceToCenterPort(Wire(puzzleInputWire2))

    println("Solution silver star: $solution")

    // Code for gold star
}