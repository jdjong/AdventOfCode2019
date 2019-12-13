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

    // Code for gold star
    for (noun in 0..99) {
        for (verb in 0..99) {
            puzzleInputAltered[1] = noun
            puzzleInputAltered[2] = verb

            if (IntCodeProgram(puzzleInputAltered).execute()[0] == 19690720) {
                var solutionGold = 100 * noun + verb
                println("Solution gold star: $solutionGold")
            }
        }
    }
}