package Day2

class IntCodeProgram(code: List<Int>) {
    private val indexStepSizeToNextCodeSegment = 4

    var isProgramTerminated = false
    private var currentCodeSegment = 0
    private var resultCode = code.toMutableList()

    fun execute(): List<Int> {
        while (!isProgramTerminated)
        {
            executeNextCodeSegment()
            currentCodeSegment += indexStepSizeToNextCodeSegment
        }

        return resultCode;
    }

    private fun executeNextCodeSegment() {
        var optCode = resultCode[currentCodeSegment]

        if (optCode == 1)
            resultCode[resultCode[currentCodeSegment + 3]] = resultCode[resultCode[currentCodeSegment + 1]] + resultCode[resultCode[currentCodeSegment + 2]]
        else if (optCode == 2)
            resultCode[resultCode[currentCodeSegment + 3]] = resultCode[resultCode[currentCodeSegment + 1]] * resultCode[resultCode[currentCodeSegment + 2]]
        else if (optCode == 99)
            isProgramTerminated = true
        else
            throw IllegalArgumentException("Code is not a valid IntCode. Optcode at position $currentCodeSegment after running equals $optCode while valid values are 1, 2 and 99")
    }
}