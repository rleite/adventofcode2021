package year2021.day12

import org.junit.jupiter.api.assertThrows
import utils.InputUtils
import kotlin.test.Test
import kotlin.test.assertEquals

internal class Day12Test {

    private val inputTest1 = sequenceOf(
        "start-A",
        "start-b",
        "A-c",
        "A-b",
        "b-d",
        "A-end",
        "b-end",
    )

    private val inputTest2 = sequenceOf(
        "dc-end",
        "HN-start",
        "start-kj",
        "dc-start",
        "dc-HN",
        "LN-dc",
        "HN-end",
        "kj-sa",
        "kj-HN",
        "kj-dc",
    )

    private val inputTest3 = sequenceOf(
        "fs-end",
        "he-DX",
        "fs-he",
        "start-DX",
        "pj-DX",
        "end-zg",
        "zg-sl",
        "zg-pj",
        "pj-he",
        "RW-he",
        "fs-DX",
        "pj-RW",
        "zg-RW",
        "start-pj",
        "he-WI",
        "zg-he",
        "pj-fs",
        "start-RW",
    )

    private val input = InputUtils.downloadAndGetLines(2021, 12)

    @Test
    fun part1() {
        assertEquals(Day12.part1(inputTest1), 10)
        assertEquals(Day12.part1(inputTest2), 19)
        assertEquals(Day12.part1(inputTest3), 226)
        println("Part 1 ${Day12.part1(input)}")
    }

    @Test
    fun part2() {
        assertEquals(Day12.part2(inputTest1), 10)
        assertEquals(Day12.part2(inputTest2), 19)
        assertEquals(Day12.part2(inputTest3), 226)
        println("Part 2 ${Day12.part2(input)}")
    }
}
