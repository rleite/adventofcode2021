package year2021.day11

import utils.InputUtils
import kotlin.test.Test
import kotlin.test.assertEquals

internal class Day11Test {

    val inputTest = sequenceOf(
        "5483143223",
        "2745854711",
        "5264556173",
        "6141336146",
        "6357385478",
        "4167524645",
        "2176841721",
        "6882881134",
        "4846848554",
        "5283751526",
    )
    private val input = InputUtils.downloadAndGetLines(2021, 11)

    @Test
    fun part1() {
        assertEquals(Day11.part1(inputTest), 1656)
        println("Part 1 ${Day11.part1(input)}")
    }

    @Test
    fun part2() {
        assertEquals(Day11.part2(inputTest), 195)
        println("Part 2 ${Day11.part2(input)}")
    }
}
