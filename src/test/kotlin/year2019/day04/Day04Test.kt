package year2019.day04

import kotlin.test.Test
import kotlin.test.assertEquals

internal class Day04Test {

    private val testInput = "123001-123900"
    private val input = "158126-624574"

    @Test
    fun part1() {
        assertEquals(Day04.part1(testInput), 63)
        println("Part 1 ${Day04.part1(input)}")
    }

    @Test
    fun part2() {
        assertEquals(Day04.part2(testInput), 63 - 12)
        println("Part 2 ${Day04.part2(input)}")
    }
}
