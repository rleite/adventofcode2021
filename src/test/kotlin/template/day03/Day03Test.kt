package template.day03

import org.junit.jupiter.api.assertThrows
import kotlin.test.Test

internal class Day03Test {

    @Test
    fun part1() {
        assertThrows<NotImplementedError> {
            Day03.part1(sequenceOf())
            println("Part 1 ${Day03.part1(sequenceOf())}")
        }
    }

    @Test
    fun part2() {
        assertThrows<NotImplementedError> {
            Day03.part1(sequenceOf())
            println("Part 2 ${Day03.part2(sequenceOf())}")
        }
    }
}
