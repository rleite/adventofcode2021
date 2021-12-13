package year2021.day10

import utils.InputUtils
import kotlin.test.Test
import kotlin.test.assertEquals

internal class Day10Test {

    private val testInput = sequenceOf(
        "[({(<(())[]>[[{[]{<()<>>",
        "[(()[<>])]({[<{<<[]>>(",
        "{([(<{}[<>[]}>{[]{[(<()>",
        "(((({<>}<{<{<>}{[]{[]{}",
        "[[<[([]))<([[{}[[()]]]",
        "[{[{({}]{}}([{[{{{}}([]",
        "{<[[]]>}<{[{[{[]{()[[[]",
        "[<(<(<(<{}))><([]([]()",
        "<{([([[(<>()){}]>(<<{{",
        "<{([{{}}[<[[[<>{}]]]>[]]",
    )
    private val input = InputUtils.downloadAndGetLines(2021, 10)

    @Test
    fun part1() {
        assertEquals(Day10.part1(testInput), 26397)
        println("Part 1 ${Day10.part1(input)}")
    }

    @Test
    fun part2() {
        assertEquals(Day10.part2(testInput), 288957)
        println("Part 2 ${Day10.part2(input)}")
    }
}
