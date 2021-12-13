package year2021.day07

import utils.InputUtils
import kotlin.test.Test
import kotlin.test.assertEquals

internal class Day07Test {

    private val testInput = sequenceOf("16,1,2,0,4,2,7,1,2,14")
     private val input = InputUtils.downloadAndGetLines(2021, 7)

    @Test
    fun part1() {
        // test if implementation meets criteria from the description, like:
        assertEquals(Day07.part1(testInput), 37)
        println("Part 1 ${Day07.part1(input)}")
    }

    @Test
    fun part2() {
        assertEquals(Day07.part2(testInput), 168)
        println("Part 2 ${Day07.part2(input)}")
    }
}
