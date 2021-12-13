package template.day01

import org.junit.jupiter.api.assertThrows
import kotlin.test.Test

internal class Day01Test {

    @Test
    fun part1() {
        assertThrows<NotImplementedError> {
            Day01.part1(sequenceOf())
            println("Part 1 ${Day01.part1(sequenceOf())}")
        }
    }

    @Test
    fun part2() {
        assertThrows<NotImplementedError> {
            Day01.part1(sequenceOf())
            println("Part 2 ${Day01.part2(sequenceOf())}")
        }
    }
}
