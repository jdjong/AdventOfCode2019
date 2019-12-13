package Day2

class IntCodeProgram(memory: List<Int>) {
    private val numberOfValuesInInstruction = 4

    var isProgramTerminated = false
    private var instructionPointer = 0
    private var resultMemory = memory.toMutableList()

    fun execute(): List<Int> {
        while (!isProgramTerminated)
        {
            executeNextCodeSegment()
            instructionPointer += numberOfValuesInInstruction
        }

        return resultMemory;
    }

    private fun executeNextCodeSegment() {
        var optCode = resultMemory[instructionPointer]

        if (optCode == 1)
            resultMemory[resultMemory[instructionPointer + 3]] = resultMemory[resultMemory[instructionPointer + 1]] + resultMemory[resultMemory[instructionPointer + 2]]
        else if (optCode == 2)
            resultMemory[resultMemory[instructionPointer + 3]] = resultMemory[resultMemory[instructionPointer + 1]] * resultMemory[resultMemory[instructionPointer + 2]]
        else if (optCode == 99)
            isProgramTerminated = true
        else
            throw IllegalArgumentException("Code is not a valid IntCode. Optcode at position $instructionPointer after running equals $optCode while valid values are 1, 2 and 99")
    }
}