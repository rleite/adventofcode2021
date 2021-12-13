package year2021.day03

import utils.InputUtils
import kotlin.test.Test
import kotlin.test.assertEquals

internal class Day03Test {

    private val testInput = sequenceOf(
        "00100",
        "11110",
        "10110",
        "10111",
        "10101",
        "01111",
        "00111",
        "11100",
        "10000",
        "11001",
        "00010",
        "01010",
    )
    private val input = InputUtils.downloadAndGetLines(2021, 3)


    @Test
    fun part1() {
        // test if implementation meets criteria from the description, like:
        assertEquals(Day03.part1(testInput), 198)

        println("Part 1 ${Day03.part1(input)}")
    }

    @Test
    fun part2() {
        // test if implementation meets criteria from the description, like:
        assertEquals(Day03.part2(testInput), 230)

        println("Part 1 ${Day03.part2(input)}")
    }
}
