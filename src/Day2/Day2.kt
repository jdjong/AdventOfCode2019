package Day2

import java.io.File

fun main() {
    // Code for silver star
    var inputFile = File("src/Day2/Day2PuzzleInput")
    var puzzleInput = inputFile.readText().split(",").map { it.toInt() }
    var puzzleInputAltered = puzzleInput.toMutableList()
    puzzleInputAltered[1] = 12
    puzzleInputAltered[2] = 2
    var solution = IntCodeProgram(puzzleInputAltered).execute()[0]

    println("Solution silver star: $solution")
}