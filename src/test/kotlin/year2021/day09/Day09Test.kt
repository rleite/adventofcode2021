package year2021.day09

import utils.InputUtils
import kotlin.test.Test
import kotlin.test.assertEquals

internal class Day09Test {

    private val testInput = sequenceOf(
        "2199943210",
        "3987894921",
        "9856789892",
        "8767896789",
        "9899965678",
    )
    private val input = InputUtils.downloadAndGetLines(2021, 9)

    @Test
    fun part1() {
        assertEquals(Day09.part1(testInput), 15)
        println("Part 1 ${Day09.part1(input)}")
    }

    @Test
    fun part2() {
        assertEquals(Day09.part2(testInput), 1134)
        println("Part 2 ${Day09.part2(input)}")
    }
}
