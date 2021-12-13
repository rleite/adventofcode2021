package year2021.day06

import org.junit.jupiter.api.assertThrows
import utils.InputUtils
import kotlin.test.Test
import kotlin.test.assertEquals

internal class Day06Test {

    private val testInput = sequenceOf("3,4,3,1,2")
    private val input = InputUtils.downloadAndGetLines(2021, 6)


    @Test
    fun part1() {
        // test if implementation meets criteria from the description, like:
        assertEquals(Day06.part1(testInput), 5934L)

        println("Part 1 ${Day06.part1(input)}")
    }

    @Test
    fun part2() {
        // test if implementation meets criteria from the description, like:
        assertEquals(Day06.part2(testInput), 26984457539L)

        println("Part 1 ${Day06.part2(input)}")
    }
}
