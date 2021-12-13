package year2021.day07

import kotlin.math.abs

object Day07 {

    private fun readInput(input: Sequence<String>): Sequence<Int> {
        return input.flatMap { it.split(',') }.map { it.toInt() }
    }

    private fun calculateDistances(positions: Sequence<Int>, selector: (Int) -> Int): Int {
        val min = positions.minOf { it }
        val max = positions.maxOf { it }
        return sequence {
            for (value in (min..max)) {
                yield(selector(value))
            }
        }.minOf { it }
    }

    fun part1(input: Sequence<String>): Int {
        val positions = readInput(input)
        return calculateDistances(positions) { value ->
            positions.sumOf { abs(value - it) }
        }
    }

    fun part2(input: Sequence<String>): Int {
        val positions = readInput(input)
        return calculateDistances(positions) { value ->
            positions.sumOf {
                val size = abs(value - it)
                ((size * (size + 1)) / 2)
            }
        }
    }
}
