package Day1

import io.kotlintest.forAll
import io.kotlintest.matchers.shouldEqual
import io.kotlintest.properties.row
import io.kotlintest.specs.StringSpec

class ModuleFuelCalculatorTest : StringSpec({
    "given a module mass then the fuel output is as expected" {
    forAll(
        arrayOf(
            ModuleTestObject(12, 2),
            ModuleTestObject(14, 2),
            ModuleTestObject(1969, 654),
            ModuleTestObject(100756, 33583)
        )
      )
      {
        moduleTestObject -> ModuleFuelCalculator().calculate(moduleTestObject.mass) shouldEqual moduleTestObject.fuel
      }
    }

    "given a module mass then the fuel output is as expected different test style" {
        listOf(
            row(12, 2),
            row(14, 2),
            row(1969, 654),
            row(100756, 33583)
        ).map { (mass: Int, fuel: Int) ->
            ModuleFuelCalculator().calculate(mass) shouldEqual fuel
        }
    }
})

class ModuleTestObject(var mass: Int, var fuel: Int) {
}

