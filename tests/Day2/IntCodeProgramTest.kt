package Day2

import io.kotlintest.matchers.shouldEqual
import io.kotlintest.properties.row
import io.kotlintest.specs.StringSpec

class IntCodeProgramTest : StringSpec ({
    "given some IntCode programs when executing then the expected IntCode result is returned" {
        listOf(
            row(listOf(1,0,0,0,99), listOf(2,0,0,0,99)),
            row(listOf(2,3,0,3,99), listOf(2,3,0,6,99)),
            row(listOf(2,4,4,5,99,0), listOf(2,4,4,5,99,9801)),
            row(listOf(1,1,1,4,99,5,6,0,99), listOf(30,1,1,4,2,5,6,0,99))
        ).map { (inputIntCode: List<Int>, outputIntCode: List<Int>) ->
            IntCodeProgram(inputIntCode).execute() shouldEqual outputIntCode
        }
    }
})