package year2021.day01

import utils.InputUtils
import kotlin.test.Test
import kotlin.test.assertEquals

internal class Day01Test {

    private val testInput = "199,200,208,210,200,207,240,269,260,263".split(',').asSequence()
    private val input = InputUtils.downloadAndGetLines(2021, 1)

    @Test
    fun part1() {
        // test if implementation meets criteria from the description, like:
        assertEquals(Day01.part1(testInput), 7)

        println("Part 1 ${Day01.part1(input)}")
    }

    @Test
    fun part2() {

        // test if implementation meets criteria from the description, like:
        assertEquals(Day01.part2(testInput), 5)

        println("Part 2 ${Day01.part2(input)}")
    }
}
