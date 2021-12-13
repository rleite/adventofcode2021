package template.day05

import org.junit.jupiter.api.assertThrows
import kotlin.test.Test

internal class Day05Test {

    @Test
    fun part1() {
        assertThrows<NotImplementedError> {
            Day05.part1(sequenceOf())
            println("Part 1 ${Day05.part1(sequenceOf())}")
        }
    }

    @Test
    fun part2() {
        assertThrows<NotImplementedError> {
            Day05.part1(sequenceOf())
            println("Part 2 ${Day05.part2(sequenceOf())}")
        }
    }
}
