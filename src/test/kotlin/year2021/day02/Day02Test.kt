package year2021.day02

import utils.InputUtils
import kotlin.test.Test
import kotlin.test.assertEquals

internal class Day02Test {

    private val testInput = sequenceOf(
        "forward 5",
        "down 5",
        "forward 8",
        "up 3",
        "down 8",
        "forward 2",
    )
    private val input = InputUtils.downloadAndGetLines(2021, 2)

    @Test
    fun part1() {
        // test if implementation meets criteria from the description, like:
        assertEquals(Day02.part1(testInput), 150)

        println("Part 1 ${Day02.part1(input)}")
    }

    @Test
    fun part2() {
        // test if implementation meets criteria from the description, like:
        assertEquals(Day02.part2(testInput), 900)

        println("Part 1 ${Day02.part2(input)}")
    }
}
