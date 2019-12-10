package Day1

import io.kotlintest.forAll
import io.kotlintest.matchers.shouldEqual
import io.kotlintest.properties.row
import io.kotlintest.specs.StringSpec

class PreciseModuleFuelCalculatorTest : StringSpec({
    "given a module mass then the fuel output is as expected" {
    forAll(
        arrayOf(
            PreciseModuleTestObject(14, 2),
            PreciseModuleTestObject(1969, 966),
            PreciseModuleTestObject(100756, 50346)
        )
      )
      {
        preciseModuleTestObject -> PreciseModuleFuelCalculator().calculate(preciseModuleTestObject.mass) shouldEqual preciseModuleTestObject.fuel
      }
    }

    "given a module mass then the fuel output is as expected different test style" {
        listOf(
            row(14, 2),
            row(1969, 966),
            row(100756, 50346)
        ).map { (mass: Int, fuel: Int) ->
            PreciseModuleFuelCalculator().calculate(mass) shouldEqual fuel
        }
    }
})

class PreciseModuleTestObject(var mass: Int, var fuel: Int) {
}

