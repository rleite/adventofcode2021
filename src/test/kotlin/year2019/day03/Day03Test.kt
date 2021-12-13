package year2019.day03

import utils.InputUtils
import kotlin.test.Test
import kotlin.test.assertEquals

internal class Day03Test {

    private val testInput1 = sequenceOf(
        "R8,U5,L5,D3",
        "U7,R6,D4,L4",
    )
    private val testInput2 = sequenceOf(
        "R75,D30,R83,U83,L12,D49,R71,U7,L72",
        "U62,R66,U55,R34,D71,R55,D58,R83"
    )
    private val testInput3 = sequenceOf(
        "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51",
        "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"
    )

    private val input = InputUtils.downloadAndGetLines(2019, 3)

    @Test
    fun part1() {
        assertEquals(Day03.part1(testInput1), 6)
        assertEquals(Day03.part1(testInput2), 159)
        assertEquals(Day03.part1(testInput3), 135)
        println("Part 1 ${Day03.part1(input)}")
    }

    @Test
    fun part2() {
        assertEquals(Day03.part2(testInput1), 30)
        assertEquals(Day03.part2(testInput2), 610)
        assertEquals(Day03.part2(testInput3), 410)
        println("Part 2 ${Day03.part2(input)}")
    }
}
