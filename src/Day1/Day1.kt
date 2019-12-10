package Day1

import java.io.File

fun main() {
    // Code for silver star
    var inputFile = File("src/Day1/Day1PuzzleInput.txt")
    var puzzleInput = mutableListOf<Int>()

    inputFile.forEachLine { puzzleInput.add(it.toInt()) }

    var moduleFuelCalculator = ModuleFuelCalculator()
    var solution = puzzleInput.fold(0, {
            result, moduleMass ->
        result + moduleFuelCalculator.calculate(moduleMass)
    })

    println("Solution silver star: $solution")

    // Code for gold star
    var preciseModuleFuelCalculator = PreciseModuleFuelCalculator()
    var solutionGoldStar = puzzleInput.fold(0, {
            result, moduleMass ->
        result + preciseModuleFuelCalculator.calculate(moduleMass)
    })

    println("Solution gold star: $solutionGoldStar")
}