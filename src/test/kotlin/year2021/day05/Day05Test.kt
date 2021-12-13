package year2021.day05

import utils.InputUtils
import kotlin.test.Test
import kotlin.test.assertEquals

internal class Day05Test {

    private val testInput = sequenceOf(
        "0,9 -> 5,9",
        "8,0 -> 0,8",
        "9,4 -> 3,4",
        "2,2 -> 2,1",
        "7,0 -> 7,4",
        "6,4 -> 2,0",
        "0,9 -> 2,9",
        "3,4 -> 1,4",
        "0,0 -> 8,8",
        "5,5 -> 8,2",
    )
    private val input = InputUtils.downloadAndGetLines(2021, 5)


    @Test
    fun part1() {
        // test if implementation meets criteria from the description, like:
        assertEquals(Day05.part1(testInput), 5)

        println("Part 1 ${Day05.part1(input)}")
    }

    @Test
    fun part2() {
        // test if implementation meets criteria from the description, like:
        assertEquals(Day05.part2(testInput), 12)

        println("Part 1 ${Day05.part2(input)}")
    }
}
