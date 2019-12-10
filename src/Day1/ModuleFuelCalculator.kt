package Day1

import kotlin.math.floor

class ModuleFuelCalculator {
    fun calculate(moduleMass: Int): Int {
        return floor(moduleMass.toFloat() / 3).toInt() - 2
    }
}

class PreciseModuleFuelCalculator {
    fun calculate(moduleMass: Int): Int {
        val requiredFuel = floor(moduleMass.toFloat() / 3).toInt() - 2

        return if (requiredFuel > 0)
            requiredFuel + calculate(requiredFuel)
        else
            0
    }
}